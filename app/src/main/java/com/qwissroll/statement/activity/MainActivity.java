package com.qwissroll.statement.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.qwissroll.statement.R;
import com.qwissroll.statement.view.DashboardItem;
import com.qwissroll.statement.view.DashboardItemTag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void openStyleActivity(View view) {
        Intent intent = new Intent(this, StyleActivity.class);
        startActivityForResult(intent, 1);
    }

    public void openSearchActivity(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivityForResult(intent, 1);
    }

    public void viewImageDetails(View view) {
        Intent intent = new Intent(this, ImageDetailActivity.class);

        DashboardItem parentView = (DashboardItem)((RelativeLayout) view.getParent()).getParent();
        DashboardItemTag tag = (DashboardItemTag) parentView.getTag();

        int itemId = tag.getItemId();
        intent.putExtra("itemId", itemId);
        startActivityForResult(intent, 1);
    }

    public void commentImage(View view) {
        Intent intent = new Intent(this, ImageDetailActivity.class);

        DashboardItem parentView = (DashboardItem)((RelativeLayout) view.getParent()).getParent();
        DashboardItemTag tag = (DashboardItemTag) parentView.getTag();

        int itemId = tag.getItemId();
        intent.putExtra("itemId", itemId);
        intent.putExtra("isComment", true);
        startActivityForResult(intent, 1);
    }

    public void likeImage(View view) {
        ImageButton likeButton = (ImageButton) view;

        DashboardItem parentView = (DashboardItem)((RelativeLayout) likeButton.getParent()).getParent();
        DashboardItemTag tag = (DashboardItemTag) parentView.getTag();

        if (tag.isSelected()) {
            tag.setSelected(false);
            int grey = ContextCompat.getColor(getApplicationContext(), R.color.colorGrey);
            likeButton.setColorFilter(grey);
        } else {
            tag.setSelected(true);
            int like = ContextCompat.getColor(getApplicationContext(), R.color.colorLike);
            likeButton.setColorFilter(like);
        }
    }

}
