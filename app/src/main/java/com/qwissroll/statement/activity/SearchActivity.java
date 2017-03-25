package com.qwissroll.statement.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.qwissroll.statement.R;
import com.qwissroll.statement.view.SuggestedTagsView;
import com.qwissroll.statement.view.TagTokenTextView;
import com.tokenautocomplete.TokenCompleteTextView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements TokenCompleteTextView.TokenListener {

    SuggestedTagsView suggestedTagsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        suggestedTagsView = (SuggestedTagsView) findViewById(R.id.suggestedTagsView);
        TagTokenTextView suggestedTags = (TagTokenTextView) suggestedTagsView.findViewById(R.id.suggestedTags);
        suggestedTags.setTokenListener(this);
    }

    @Override
    public void onTokenAdded(Object token) {
    }

    @Override
    public void onTokenRemoved(Object token) {
        suggestedTagsView.addSuggestedTag((String) token);
    }

    public void openSearchResultsActivity(View view) {
        Intent intent = new Intent(this, SearchResultsActivity.class);
        ArrayList<String> searchTags = suggestedTagsView.getTags();
        intent.putStringArrayListExtra("searchTags", searchTags);
        startActivityForResult(intent, 1);
    }

}
