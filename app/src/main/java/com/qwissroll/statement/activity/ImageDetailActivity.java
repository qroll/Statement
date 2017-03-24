package com.qwissroll.statement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.qwissroll.statement.R;

public class ImageDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = getIntent();

        int itemId = i.getIntExtra("itemId", 0);
        TextView text = (TextView) findViewById(R.id.testText);
        text.setText("You selected " + itemId);

        String imageSource = "ootd_" + itemId;
        int id = getResources().getIdentifier(imageSource, "drawable", getPackageName());
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(id);

        boolean isComment = i.getBooleanExtra("isComment", false);
        if (isComment) {
            EditText input = (EditText) findViewById(R.id.commentInput);
            input.requestFocus();
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
