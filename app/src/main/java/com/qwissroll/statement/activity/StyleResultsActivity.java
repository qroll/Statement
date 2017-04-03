package com.qwissroll.statement.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;
import com.qwissroll.statement.OutfitItemAdapter;
import com.qwissroll.statement.R;
import com.qwissroll.statement.data.StyleDataManager;
import com.qwissroll.statement.pojo.Outfit;

public class StyleResultsActivity extends AppCompatActivity {

    private static final int PAGE_COUNT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_style_results);

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

        // init outfit carousel
        HorizontalInfiniteCycleViewPager carousel = (HorizontalInfiniteCycleViewPager) findViewById(R.id.carousel);
        carousel.setAdapter(new StylePagerAdapter(this, false));
    }

    private class StylePagerAdapter extends PagerAdapter {

        private LayoutInflater mLayoutInflater;
        private OutfitItemAdapter adapter;

        public StylePagerAdapter(final Context context, final boolean isTwoWay) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(final ViewGroup container, final int position) {
            final View view;
            view = mLayoutInflater.inflate(R.layout.style_outfit, container, false);

            int outfitId = position;

            StyleDataManager styleDataManager = StyleDataManager.getInstance();
            Outfit outfit = styleDataManager.get(outfitId);

            TextView textView = (TextView) view.findViewById(R.id.outfit_style);
            textView.setText(outfit.getStyle());
            textView.setTextColor(pickTextColorBasedOnBgColor(outfit.getColor()));
            textView.setBackgroundColor(Color.parseColor(outfit.getColor()));

            RecyclerView outfitItems = (RecyclerView) view.findViewById(R.id.outfit_items);

            outfitItems.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            adapter = new OutfitItemAdapter(outfit.getItems());
            outfitItems.setAdapter(adapter);
            outfitItems.setNestedScrollingEnabled(false);

            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public int getItemPosition(final Object object) {
            return POSITION_NONE;
        }

        @Override
        public void destroyItem(final ViewGroup container, final int position, final Object object) {
            container.removeView((View) object);
        }

        private int pickTextColorBasedOnBgColor(String bgColor) {
            int colorIntValue = Color.parseColor(bgColor);
            int red = Color.red(colorIntValue);
            int green = Color.green(colorIntValue);
            int blue = Color.blue(colorIntValue);
            double lum = (((0.299 * red) + ((0.587 * green) + (0.114 * blue))));
            return lum > 186 ? Color.BLACK : Color.WHITE;
        }
    }

}
