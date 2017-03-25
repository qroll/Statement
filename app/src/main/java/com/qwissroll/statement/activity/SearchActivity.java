package com.qwissroll.statement.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.qwissroll.statement.R;
import com.qwissroll.statement.SuggestedTagsAdapter;
import com.qwissroll.statement.view.TagTokenTextView;

public class SearchActivity extends AppCompatActivity {

    TagTokenTextView tagView;
    String[] tags;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tags = new String[]{"cupcake", "donut", "eclair", "froyo", "gingerbread", "honeycomb",
                "icecream sandwich", "jellybean", "kitkat", "lollipop", "marshmallow", "nougat"};

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tags);

        tagView = (TagTokenTextView) findViewById(R.id.tagView);
        tagView.setAdapter(adapter);

        tagView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    final TagTokenTextView tac = (TagTokenTextView) v;
                    tac.performCompletion();
                    return true;
                }

                return false;
            }
        });

        tagView.addObject("this is a test");
    }

}
