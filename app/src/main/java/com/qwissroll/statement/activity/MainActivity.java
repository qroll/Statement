package com.qwissroll.statement.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.qwissroll.statement.DashboardItemAdapter;
import com.qwissroll.statement.R;
import com.qwissroll.statement.data.OutfitDataManager;
import com.qwissroll.statement.pojo.DashboardItemTag;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DashboardItemAdapter.ItemClickListener {

    DashboardItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            Toast toast = Toast.makeText(getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
            toast.show();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        OutfitDataManager outfitDataManager = OutfitDataManager.getInstance();
        ArrayList<DashboardItemTag> dashboardItems = outfitDataManager.getAll();

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

        int itemId = position + 1;
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

    public void openStyleActivity(View view) {
        Intent intent = new Intent(this, StyleActivity.class);
        startActivityForResult(intent, 1);
    }

    public void openSearchActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivityForResult(intent, 1);
    }

}
