package com.qwissroll.statement.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.qwissroll.statement.StyleFormalSliderFragment;
import com.qwissroll.statement.R;
import com.qwissroll.statement.StyleTagsFragment;

import com.qwissroll.statement.view.TagInputView;
import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;

import java.util.ArrayList;

public class StyleActivity extends AppCompatActivity {

    private static final int PAGE_COUNT = 2;
    private static final int REQUEST_CODE_DEFAULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        // init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // set title font
        TextView title = (TextView) findViewById(R.id.title);
        Typeface typeface = Typeface.createFromAsset(getAssets(),
                "fonts/playfairdisplaysc_regular.ttf");
        title.setTypeface(typeface);

        final Button doneBtn = (Button) findViewById(R.id.doneBtn);
        doneBtn.setVisibility(View.INVISIBLE);

        final ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new StylePagerAdapter(getSupportFragmentManager()));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position < PAGE_COUNT - 1) {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(pager.getWindowToken(), 0);
                    doneBtn.setVisibility(View.INVISIBLE);
                } else {
                    ((TagInputView) pager.findViewById(R.id.tagInputView)).requestFocusForTagInput();
                    doneBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setAnimationType(AnimationType.SLIDE);
        pageIndicatorView.setUnselectedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorGrey));
        pageIndicatorView.setSelectedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
    }

    private class StylePagerAdapter extends FragmentPagerAdapter {

        public StylePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0:
                    return StyleFormalSliderFragment.newInstance();
                case 1:
                    return StyleTagsFragment.newInstance();
                default:
                    return StyleFormalSliderFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }

    public void dispatchStyleOutfitActivity(View view) {
        Intent intent = new Intent(this, StyleResultsActivity.class);

        SeekBar seekBar = (SeekBar) findViewById(R.id.formalSlider);
        int formalValue = seekBar.getProgress();
        intent.putExtra("formalValue", formalValue);

        TagInputView tagInputView = (TagInputView) findViewById(R.id.tagInputView);
        ArrayList<String> tags = tagInputView.getTags();
        intent.putStringArrayListExtra("tags", tags);

        startActivityForResult(intent, REQUEST_CODE_DEFAULT);
    }

}
