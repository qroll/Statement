package com.qwissroll.statement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.qwissroll.statement.view.TagTokenTextView;

public class StyleActivity extends AppCompatActivity {

    TagTokenTextView tagView;
    String[] tags;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tags = new String[]{"cupcake", "donut", "eclair", "froyo", "gingerbread", "honeycomb",
                "icecream sandwich", "jellybean", "kitkat", "lollipop", "marshmallow", "nougat"};

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tags);

        tagView = (TagTokenTextView)findViewById(R.id.tagView);
        tagView.setAdapter(adapter);

        tagView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    final TagTokenTextView tac = (TagTokenTextView) v;
                    tac.performCompletion();
                    return true;
                }

                return false;
            }
        });
    }

}
