package com.qwissroll.statement.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.qwissroll.statement.R;
import com.qwissroll.statement.DashboardItemTag;

/**
 * Created by qruol on 22/3/2017.
 */

public class DashboardItem extends RelativeLayout {

    public DashboardItem(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_dashboard, this, true);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.labelValue, 0, 0);
        int itemId = Integer.parseInt(array.getString(R.styleable.labelValue_value));
        DashboardItemTag tag = new DashboardItemTag(itemId);
        setTag(tag);

        String imageSource = "ootd_" + itemId;
        int id = context.getResources().getIdentifier(imageSource, "drawable", context.getPackageName());
        ImageView img = (ImageView) findViewById(R.id.image);
        img.setImageResource(id);

        array.recycle();
    }

}
