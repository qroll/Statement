package com.qwissroll.statement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qwissroll.statement.view.TagInputView;
import com.qwissroll.statement.view.TagSelectView;
import com.tokenautocomplete.TokenCompleteTextView;

/**
 * Created by qruol on 25/3/2017.
 */

public class SecondStyleFragment extends Fragment implements TokenCompleteTextView.TokenListener {

    TagInputView tagInputView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.style_page_2, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(getArguments().getString("msg"));

        tagInputView = (TagInputView) view.findViewById(R.id.tagInputView);
        return view;
    }

    public static SecondStyleFragment newInstance(String text) {

        SecondStyleFragment f = new SecondStyleFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public void onTokenAdded(Object token) {
    }

    @Override
    public void onTokenRemoved(Object token) {
        tagInputView.addSuggestedTag((String) token);
    }

}
