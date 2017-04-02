package com.qwissroll.statement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class OutfitItemAdapter extends RecyclerView.Adapter<OutfitItemAdapter.ViewHolder> {
    private ArrayList<Integer> mItemIds;
    private ItemClickListener mClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;

        public ViewHolder(ImageView v) {
            super(v);
            mImageView = v;
            mImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public OutfitItemAdapter(ArrayList<Integer> itemIds) {
        mItemIds = itemIds;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OutfitItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        ImageView v = (ImageView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_outfit, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.mImageView.getContext();
        // set image
        int id = context.getResources().getIdentifier("_item_" + getItem(position), "drawable", context.getPackageName());
        Glide.with(context).load(id).into(holder.mImageView);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItemIds.size();
    }

    // Return the tag at specified position
    // Convenience method for getting data at click position
    public Integer getItem(int id) {
        return mItemIds.get(id);
    }

}