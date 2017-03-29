package com.qwissroll.statement.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.qwissroll.statement.FirstStyleFragment;
import com.qwissroll.statement.R;
import com.qwissroll.statement.SecondStyleFragment;

import com.rd.PageIndicatorView;
import com.rd.animation.AnimationType;

public class StyleActivity extends AppCompatActivity implements FirstStyleFragment.SliderChangeListener {

    private int formalSliderValue = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new StylePagerAdapter(getSupportFragmentManager()));

        PageIndicatorView pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setAnimationType(AnimationType.DROP);
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
            return 2;
        }
    }

}
