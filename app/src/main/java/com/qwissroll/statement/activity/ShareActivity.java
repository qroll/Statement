package com.qwissroll.statement.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.qwissroll.statement.R;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Intent intent = getIntent();
        String photoPath = (String) intent.getExtras().get("photoPath");

        Bitmap photo = BitmapFactory.decodeFile(photoPath);
        ImageView imageView = (ImageView) findViewById(R.id.photo);
        imageView.setImageBitmap(photo);
    }
}
