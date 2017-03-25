package com.qwissroll.statement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.qwissroll.statement.view.TagTokenTextView;
import com.xiaofeng.flowlayoutmanager.Alignment;
import com.xiaofeng.flowlayoutmanager.FlowLayoutManager;

/**
 * Created by qruol on 25/3/2017.
 */

public class SecondStyleFragment extends Fragment {

    String[] tags;

    TagTokenTextView tagView;
    ArrayAdapter<String> adapter;

    FlowLayoutManager flowLayoutManager;
    RecyclerView suggestedTagView;
    SuggestedTagsAdapter suggestAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.style_page_2, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("msg"));


        tags = new String[]{"cupcake", "donut", "eclair", "froyo", "gingerbread", "honeycomb",
                "icecream sandwich", "jellybean", "kitkat", "lollipop", "marshmallow", "nougat"};

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tags);

        tagView = (TagTokenTextView) view.findViewById(R.id.tagView);
        tagView.setAdapter(adapter);
        tagView.allowCollapse(false);
        tagView.addObject("this is a test");

        suggestAdapter = new SuggestedTagsAdapter(tags);
        suggestedTagView = (RecyclerView) view.findViewById(R.id.suggestedTagView);
        flowLayoutManager = new FlowLayoutManager();
        flowLayoutManager.setAutoMeasureEnabled(true);
        suggestedTagView.setLayoutManager(flowLayoutManager);
        suggestedTagView.setAdapter(suggestAdapter);

        return view;
    }

    public static SecondStyleFragment newInstance(String text) {

        SecondStyleFragment f = new SecondStyleFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public void onSelectTag(String text) {
        tagView.addObject(text);
    }

}
