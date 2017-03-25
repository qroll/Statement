package com.qwissroll.statement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by qruol on 25/3/2017.
 */

public class FinalStyleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.style_page_2, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("msg"));

        return view;
    }

    public static FinalStyleFragment newInstance(String text) {

        FinalStyleFragment f = new FinalStyleFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
