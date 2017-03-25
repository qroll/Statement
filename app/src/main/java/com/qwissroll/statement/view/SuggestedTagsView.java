package com.qwissroll.statement.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qwissroll.statement.R;
import com.qwissroll.statement.SuggestedTagsAdapter;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qruol on 25/3/2017.
 */

public class SuggestedTagsView extends RelativeLayout {

    ArrayList<String> tags;

    TagTokenTextView userTags;
    ArrayAdapter<String> userTagsAdapter;

    FlowLayoutManager flowLayoutManager;
    RecyclerView suggestedTags;
    SuggestedTagsAdapter suggestedTagsAdapter;

    public SuggestedTagsView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.suggested_tags, this, true);

        tags = new ArrayList<String>(Arrays.asList("cupcake", "donut", "eclair",
                "froyo", "gingerbread", "honeycomb",
                "icecream sandwich", "jellybean", "kitkat",
                "lollipop", "marshmallow", "nougat"));

        userTags = (TagTokenTextView) findViewById(R.id.userTags);
        userTagsAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, tags);
        userTags.setAdapter(userTagsAdapter);
        userTags.allowCollapse(false);
        userTags.addObject("this is a test");

        suggestedTags = (RecyclerView) findViewById(R.id.suggestedTags);
        flowLayoutManager = new FlowLayoutManager();
        flowLayoutManager.setAutoMeasureEnabled(true);
        suggestedTags.setLayoutManager(flowLayoutManager);
        suggestedTagsAdapter = new SuggestedTagsAdapter(tags);
        suggestedTags.setAdapter(suggestedTagsAdapter);
    }

}
