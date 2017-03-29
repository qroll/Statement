package com.qwissroll.statement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qwissroll.statement.DashboardItemAdapter;
import com.qwissroll.statement.R;
import com.qwissroll.statement.data.OutfitDataManager;
import com.qwissroll.statement.pojo.DashboardItemTag;

import java.util.ArrayList;

public class SearchResultsActivity extends AppCompatActivity implements DashboardItemAdapter.ItemClickListener {

    DashboardItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        ArrayList<String> searchTags = i.getStringArrayListExtra("searchTags");

        OutfitDataManager outfitDataManager = OutfitDataManager.getInstance();
        ArrayList<DashboardItemTag> dashboardItems = outfitDataManager.getAllWithAnyTags(searchTags);

        RecyclerView dashboard = (RecyclerView) findViewById(R.id.dashboard);
        adapter = new DashboardItemAdapter(dashboardItems);
        adapter.setClickListener(this);
        dashboard.setLayoutManager(new LinearLayoutManager(this));
        dashboard.setAdapter(adapter);
        dashboard.setNestedScrollingEnabled(false);
    }

    @Override
    public void onItemImageClick(View view, int position) {
        Intent intent = new Intent(this, ImageDetailActivity.class);

        int itemId = adapter.getItem(position).getItemId();
        intent.putExtra("itemId", itemId);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onItemLikeClick(View view, int position) {
        DashboardItemTag tag = adapter.getItem(position);
        tag.setLiked(!tag.isLiked());
    }

    @Override
    public void onItemCommentClick(View view, int position) {
        Intent intent = new Intent(this, ImageDetailActivity.class);

        int itemId = position + 1;
        intent.putExtra("itemId", itemId);
        intent.putExtra("isComment", true);
        startActivityForResult(intent, 1);
    }

}
