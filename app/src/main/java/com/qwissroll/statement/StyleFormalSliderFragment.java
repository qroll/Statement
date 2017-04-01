package com.qwissroll.statement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

/**
 * Created by qruol on 25/3/2017.
 */

public class StyleFormalSliderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.style_formal_slider, container, false);

        return view;
    }

    public static StyleFormalSliderFragment newInstance() {
        StyleFormalSliderFragment fragment = new StyleFormalSliderFragment();
        return fragment;
    }

}
