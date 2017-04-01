package com.qwissroll.statement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qwissroll.statement.view.TagInputView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qruol on 25/3/2017.
 */

public class StyleTagsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.style_tags, container, false);

        return view;
    }

    public static StyleTagsFragment newInstance() {
        StyleTagsFragment fragment = new StyleTagsFragment();
        return fragment;
    }

}
