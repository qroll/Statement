package com.qwissroll.statement.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qwissroll.statement.DashboardItemAdapter;
import com.qwissroll.statement.R;
import com.qwissroll.statement.data.OutfitDataManager;
import com.qwissroll.statement.data.ProductDataManager;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;

/*
The main entry point of the application.
Contains:
    - dashboard for Explore task
    - search button
    - bottom bar linking to Profile, Style and Share tasks
 */
public class MainActivity extends AppCompatActivity
        implements DashboardItemAdapter.DashboardItemClickListener {

    private static final int REQUEST_CODE_DEFAULT = 1;
    private static final int REQUEST_CODE_ITEM_DETAIL_COMMENT = 2;

    OutfitDataManager outfitDataManager;
    ProductDataManager productDataManager;

    DashboardItemAdapter dashboardItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // set title font
        TextView title = (TextView) findViewById(R.id.title);
        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "fonts/playfairdisplaysc_regular.ttf");
        title.setTypeface(typeface);

        // init bottom nav bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_profile:
                            break;
                        case R.id.action_style:
                            dispatchStyleActivity(null);
                            break;
                        case R.id.action_share:
                            dispatchShareActivity(null);
                            break;
                    }
                    return false;
                }
            }
        );

        // run any first time code
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            String message = "Hello toast!";
            Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        // init data managers here to mock persistence
        outfitDataManager = OutfitDataManager.getInstance();
        productDataManager = ProductDataManager.getInstance();

        // init dashboard
        ArrayList<DashboardItem> dashboardItems = outfitDataManager.getAll();

        RecyclerView dashboard = (RecyclerView) findViewById(R.id.dashboard);
        dashboardItemAdapter = new DashboardItemAdapter(dashboardItems);
        dashboardItemAdapter.setClickListener(this);
        dashboard.setLayoutManager(new LinearLayoutManager(this));
        dashboard.setAdapter(dashboardItemAdapter);
        dashboard.setNestedScrollingEnabled(false);
        RecyclerView.ItemAnimator animator = dashboard.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }
    }

    /*
    Click listeners
     */

    public void onItemImageClick(View view, int position) {
        dispatchItemDetailActivity(position + 1, REQUEST_CODE_DEFAULT);
    }

    public void onItemLikeClick(View view, int position) {
        DashboardItem item = dashboardItemAdapter.getItem(position);
        if (item.isLiked()) {
            item.setLikes(item.getLikes() - 1);
        } else {
            item.setLikes(item.getLikes() + 1);
        }
        item.setLiked(!item.isLiked());
    }

    public void onItemCommentClick(View view, int position) {
        dispatchItemDetailActivity(position + 1, REQUEST_CODE_ITEM_DETAIL_COMMENT);
    }

    /*
    Activity dispatchers start new activities
     */

    public void dispatchStyleActivity(View view) {
        Intent intent = new Intent(this, StyleActivity.class);
        startActivityForResult(intent, REQUEST_CODE_DEFAULT);
    }

    public void dispatchSearchActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivityForResult(intent, REQUEST_CODE_DEFAULT);
    }

    public void dispatchShareActivity(View view) {
        Intent intent = new Intent(this, ShareActivity.class);
        startActivityForResult(intent, REQUEST_CODE_DEFAULT);
    }

    public void dispatchItemDetailActivity(int itemId, int requestCode) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        intent.putExtra("itemId", itemId);
        intent.putExtra("isComment", requestCode == REQUEST_CODE_ITEM_DETAIL_COMMENT);
        startActivityForResult(intent, requestCode);
    }

}
