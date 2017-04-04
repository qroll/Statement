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

public class DetailItemAdapter extends RecyclerView.Adapter<DetailItemAdapter.ViewHolder> {
    private ArrayList<DetailItem> mTags;
    private ItemClickListener mClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public TextView mTextNameView;
        public TextView mTextDescriptionView;
        public Button mButtonAdd;

        public ViewHolder(RelativeLayout v) {
            super(v);
            mImageView =(ImageView) v.findViewById(R.id.productImage);
            mTextNameView = (TextView) v.findViewById(R.id.productName);
            mTextDescriptionView = (TextView) v.findViewById(R.id.productDescription);
            mButtonAdd =(Button) v.findViewById(R.id.button_add);
            mButtonAdd.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.onItemClick(view, getAdapterPosition());
                DetailItem item = mTags.get(getAdapterPosition());
                mButtonAdd.setText(item.isAdded() ? "Added to wishlist" : "Add to wishlist");
            }
        }
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DetailItemAdapter(ArrayList<DetailItem> tags) {
        mTags = tags;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DetailItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_detail, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.mImageView.getContext();
        DetailItem tag = mTags.get(position);
        // set image
        int id = context.getResources().getIdentifier("_item_" + tag.getItemId(), "drawable", context.getPackageName());
        Glide.with(context).load(id).into(holder.mImageView);
        // set name
        holder.mTextNameView.setText(tag.getItemName());
        // set description
        holder.mTextDescriptionView.setText(tag.getItemDescription());
        // set if item is on wishlist
        holder.mButtonAdd.setText(tag.isAdded() ? "Added to wishlist" : "Add to wishlist");
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mTags.size();
    }

    // Return the tag at specified position
    // Convenience method for getting data at click position
    public DetailItem getItem(int id) {
        return mTags.get(id);
    }

}