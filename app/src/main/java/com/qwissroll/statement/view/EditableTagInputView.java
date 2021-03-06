package com.qwissroll.statement.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qwissroll.statement.R;
import com.tokenautocomplete.TokenCompleteTextView;


/**
 * Created by qruol on 24/3/2017.
 */

public class EditableTagInputView extends TokenCompleteTextView<String>
        implements TokenCompleteTextView.TokenListener {

    private OnTokenRemovedListener mListener;

    public EditableTagInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTokenListener(this);
    }

    @Override
    protected View getViewForObject(String tag) {
        LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        TextView view = (TextView) l.inflate(R.layout.tag_token, (ViewGroup) getParent(), false);
        allowDuplicates(false);
        setTokenClickStyle(TokenClickStyle.Select);
        setThreshold(1);

        view.setText(tag);
        return view;
    }

    @Override
    protected String defaultObject(String completionText) {
        return completionText;
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        setCompoundDrawablesWithIntrinsicBounds(0, 0, selected ? R.drawable.ic_action_close : 0, 0);
    }

    @Override
    public void onTokenAdded(Object token) {

    }

    @Override
    public void onTokenRemoved(Object token) {
        removeObject((String) token);
        if (mListener != null) {
            mListener.removeInputTag((String) token);
        }
    }

    public void setListener(OnTokenRemovedListener l) {
        mListener = l;
    }

    public interface OnTokenRemovedListener {
        void removeInputTag(String token);
    }

}