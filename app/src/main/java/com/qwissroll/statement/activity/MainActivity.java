package com.qwissroll.statement.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.qwissroll.statement.DashboardItemAdapter;
import com.qwissroll.statement.R;
import com.qwissroll.statement.data.OutfitDataManager;
import com.qwissroll.statement.pojo.DashboardItemTag;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DashboardItemAdapter.ItemClickListener {

    DashboardItemAdapter adapter;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_style:
                        openStyleActivity(null);
                        break;
                    case R.id.action_share:
                        if (performCameraPermissionCheck()) {
                            openCameraActivity();
                        }
                        break;
                    case R.id.action_profile:
                }
                return false;
            }
        });

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

    public void openCameraActivity() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String targetFilename = sdf.format(new Date());

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
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

    public void openShareActivity(Bitmap image) {
        Intent intent = new Intent(this, ShareActivity.class);
        intent.putExtra("image", image);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            openShareActivity((Bitmap) data.getExtras().get("data"));
        }
    }

    private boolean performCameraPermissionCheck() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, REQUEST_IMAGE_CAPTURE);
        }
        return false;
    }

}

