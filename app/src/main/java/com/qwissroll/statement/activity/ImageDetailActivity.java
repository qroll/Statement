package com.qwissroll.statement.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.qwissroll.statement.adapter.CommentAdapter;
import com.qwissroll.statement.adapter.DetailItemAdapter;
import com.qwissroll.statement.R;
import com.qwissroll.statement.data.MaleOutfitDataManager;
import com.qwissroll.statement.data.MaleProductDataManager;
import com.qwissroll.statement.data.OutfitDataManager;
import com.qwissroll.statement.data.ProductDataManager;
import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DashboardItem;
import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;

public class ImageDetailActivity extends AppCompatActivity implements DetailItemAdapter.ItemClickListener {

    DetailItemAdapter detailItemAdapter;
    CommentAdapter commentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        int itemId = i.getIntExtra("itemId", 0);

        OutfitDataManager outfitDataManager = MaleOutfitDataManager.getInstance();
        final DashboardItem item = outfitDataManager.get(itemId);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setSelected(item.isLiked());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isLiked = !item.isLiked();
                item.setLiked(isLiked);
                fab.setSelected(isLiked);
            }
        });

        // set outfit title in toolbar
        getSupportActionBar().setTitle(item.getItemName().toLowerCase());

        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "fonts/playfairdisplaysc_regular.ttf");
        CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbarLayout.setExpandedTitleTypeface(typeface);
        toolbarLayout.setCollapsedTitleTypeface(typeface);

        String imageSource = "ootd_" + itemId;
        int id = getResources().getIdentifier(imageSource, "drawable", getPackageName());
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(id);

        ProductDataManager productDataManager = MaleProductDataManager.getInstance();
        ArrayList<DetailItem> productList = productDataManager.get(itemId);

        RecyclerView productListView = (RecyclerView) findViewById(R.id.productList);
        productListView.setLayoutManager(new LinearLayoutManager(this));
        detailItemAdapter = new DetailItemAdapter(productList);
        detailItemAdapter.setClickListener(this);
        productListView.setAdapter(detailItemAdapter);
        productListView.setNestedScrollingEnabled(false);

        RecyclerView commentListView = (RecyclerView) findViewById(R.id.commentList);
        commentListView.setLayoutManager(new LinearLayoutManager(this));
        commentAdapter = new CommentAdapter(item.getComments());
        commentListView.setAdapter(commentAdapter);
        commentListView.setNestedScrollingEnabled(false);

        boolean isComment = i.getBooleanExtra("isComment", false);
        if (isComment) {
            EditText input = (EditText) findViewById(R.id.commentInput);
            input.requestFocus();
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        } else {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        }
    }

    public void onCommentClick(View view) {
        EditText input = (EditText) findViewById(R.id.commentInput);
        input.setText("");
        input.clearFocus();

        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onItemClick(View view, int position) {
        DetailItem tag = detailItemAdapter.getItem(position);
        tag.setAdded(!tag.isAdded());
    }

}
