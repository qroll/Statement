package com.qwissroll.statement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qwissroll.statement.R;
import com.qwissroll.statement.view.TagInputView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_DEFAULT = 1;

    TagInputView tagInputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // init tag input view
        tagInputView = (TagInputView) findViewById(R.id.tagInputView);
    }

    public void dispatchSearchResultsActivity(View view) {
        Intent intent = new Intent(this, SearchResultsActivity.class);
        ArrayList<String> searchTags = tagInputView.getTags();
        intent.putStringArrayListExtra("searchTags", searchTags);
        startActivityForResult(intent, REQUEST_CODE_DEFAULT);
    }

}
