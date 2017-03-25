package com.qwissroll.statement.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qwissroll.statement.R;
import com.tokenautocomplete.TokenCompleteTextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qruol on 25/3/2017.
 */

public class SuggestedTagsView extends RelativeLayout {

    ArrayList<String> tags;

    TagTokenEditTextView userTags;
    ArrayAdapter<String> userTagsAdapter;

    TagTokenTextView suggestedTags;
    ArrayAdapter<String> suggestedTagsAdapter;

    public SuggestedTagsView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.suggested_tags, this, true);

        tags = new ArrayList<String>(Arrays.asList("cupcake", "donut", "eclair",
                "froyo", "gingerbread", "honeycomb",
                "icecream sandwich", "jellybean", "kitkat",
                "lollipop", "marshmallow", "nougat"));

        userTags = (TagTokenEditTextView) findViewById(R.id.userTags);
        userTagsAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, tags);
        userTags.setAdapter(userTagsAdapter);
        userTags.allowCollapse(false);
        userTags.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    final TagTokenEditTextView tac = (TagTokenEditTextView) v;
                    tac.performCompletion();
                    return true;
                }

                return false;
            }
        });

        suggestedTags = (TagTokenTextView) findViewById(R.id.suggestedTags);
        suggestedTags.addObject("this is a test");
        suggestedTags.addObject("mhmm");
        suggestedTags.addObject("android");
        suggestedTags.addObject("crop top");
        suggestedTags.addObject("beachwear");
        suggestedTags.addObject("sundress");
        suggestedTags.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Delete);
        suggestedTags.allowCollapse(false);
        suggestedTags.setKeyListener(null);
        suggestedTags.setTextIsSelectable(false);
    }

    public void addSuggestedTag(String text) {
        suggestedTags.removeObject(text);
        userTags.addObject(text);
        userTags.requestFocus();
        InputMethodManager imm = (InputMethodManager) userTags.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(userTags, InputMethodManager.SHOW_IMPLICIT);
    }

}
