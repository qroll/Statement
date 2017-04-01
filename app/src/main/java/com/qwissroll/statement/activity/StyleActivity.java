package com.qwissroll.statement.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.qwissroll.statement.FirstStyleFragment;
import com.qwissroll.statement.R;
import com.qwissroll.statement.SecondStyleFragment;

import com.qwissroll.statement.view.TagInputView;
import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;

public class StyleActivity extends AppCompatActivity implements FirstStyleFragment.SliderChangeListener {

    private static final int PAGE_COUNT = 2;

    private int formalSliderValue = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);

        // init toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    @Override
    public void onSliderChange(int sliderValue) {
        formalSliderValue = sliderValue;
        Log.d("!!!!INFO", "" + formalSliderValue);
    }

    private class StylePagerAdapter extends FragmentPagerAdapter {

        public StylePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch(pos) {
                case 0:
                    return FirstStyleFragment.newInstance("FirstStyleFragment, Instance 1");
                case 1:
                    return SecondStyleFragment.newInstance("SecondStyleFragment, Instance 1");
                default:
                    return FirstStyleFragment.newInstance("FirstFragment, Default");
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }

}
