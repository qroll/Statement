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
import java.util.List;

/**
 * Created by qruol on 25/3/2017.
 */

public class TagInputView extends RelativeLayout
        implements TagSelectView.OnTokenRemovedListener,
                   EditableTagInputView.OnTokenRemovedListener {

    private ArrayList<String> suggestedTags; // tags that can be selected directly
    private ArrayList<String> autocompleteTags; // tags that are suggested when user begins typing

    private EditableTagInputView editableTagsView;
    private ArrayAdapter<String> editableTagsAdapter;

    private TagSelectView selectableTagsView;
    private ArrayAdapter<String> selectableTagsAdapter;

    private TagChangeListener mTagChangeListener;

    public TagInputView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.tag_input, this, true);

        suggestedTags = new ArrayList<>(Arrays.asList(
                "80s", "bold", "dress", "florals",
                "minimal", "spring", "stripes", "summer"
        ));

        autocompleteTags = new ArrayList<>(Arrays.asList(
                "80s", "beachwear", "bohemian", "bold", "casual",
                "checkered", "crop top", "dress", "florals", "formal",
                "hijab", "jeans", "khaki", "lace", "long sleeved", "loose",
                "minimal", "spring", "stripes", "summer", "white"
        ));

        // init editable tags
        editableTagsView = (EditableTagInputView) findViewById(R.id.editableTagsView);
        // assign tags for autocompletion
        editableTagsAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_list_item_1, autocompleteTags);
        editableTagsView.setAdapter(editableTagsAdapter);
        // prevent tags from collapsing into a single line
        editableTagsView.allowCollapse(false);
        // allow free entry of tags
        editableTagsView.performBestGuess(false);
        // prevent keyboard from closing when a tag is completed
        editableTagsView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    final EditableTagInputView tac = (EditableTagInputView) v;
                    tac.performCompletion();
                    return true;
                }
                return false;
            }
        });

        // init selectable tags
        selectableTagsView = (TagSelectView) findViewById(R.id.selectableTagsView);
        // add suggestions
        for (String tag : suggestedTags) {
            selectableTagsView.addObject(tag);
        }
        selectableTagsView.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Delete);
        selectableTagsView.allowCollapse(false);

        editableTagsView.setListener(this);
        selectableTagsView.setListener(this);
    }

    public ArrayList<String> getTags() {
        return new ArrayList<String>(editableTagsView.getObjects());
    }

    @Override
    public void removeSuggestedTag(String token) {
        editableTagsView.addObject(token);
        selectableTagsView.removeObject(token);
    }

    @Override
    public void removeInputTag(String token) {
        if (suggestedTags.contains(token)) {
            selectableTagsView.addObject(token);
        }
        editableTagsView.removeObject(token);
        if (mTagChangeListener != null) {
            mTagChangeListener.onTagChange(editableTagsView.getObjects());
        }
    }

    public void requestFocusForTagInput() {
        editableTagsView.requestFocus();
        InputMethodManager imm = (InputMethodManager)
                getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editableTagsView, InputMethodManager.SHOW_IMPLICIT);
    }

    public void setTagChangeListener(TagChangeListener l) {
        mTagChangeListener = l;
    }

    public interface TagChangeListener {
        void onTagChange(List<String> tags);
    }

}
