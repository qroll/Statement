package com.qwissroll.statement.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.qwissroll.statement.R;
import com.qwissroll.statement.view.SuggestedTagsView;
import com.qwissroll.statement.view.TagTokenTextView;
import com.tokenautocomplete.TokenCompleteTextView;

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

}
