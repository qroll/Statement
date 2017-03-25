package com.qwissroll.statement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.qwissroll.statement.pojo.DashboardItemTag;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class DashboardItemAdapter extends RecyclerView.Adapter<DashboardItemAdapter.ViewHolder> {
    private ArrayList<DashboardItemTag> mTags;
    private ItemClickListener mClickListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public ImageButton mButtonLike;
        public ImageButton mButtonComment;

        public ViewHolder(RelativeLayout v) {
            super(v);
            mImageView =(ImageView) v.findViewById(R.id.image);
            mImageView.setOnClickListener(this);
            mButtonLike =(ImageButton) v.findViewById(R.id.button_like);
            mButtonLike.setOnClickListener(this);
            mButtonComment =(ImageButton) v.findViewById(R.id.button_comment);
            mButtonComment.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                switch (view.getId()) {
                    case R.id.image:
                        mClickListener.onItemImageClick(view, getAdapterPosition());
                        break;
                    case R.id.button_like:
                        mClickListener.onItemLikeClick(view, getAdapterPosition());
                        DashboardItemTag tag = mTags.get(getAdapterPosition());
                        mButtonLike.setSelected(tag.isSelected());
                        break;
                    case R.id.button_comment:
                        mClickListener.onItemCommentClick(view, getAdapterPosition());
                        break;
                }
            }
        }
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemImageClick(View view, int position);
        void onItemCommentClick(View view, int position);
        void onItemLikeClick(View view, int position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DashboardItemAdapter(ArrayList<DashboardItemTag> tags) {
        mTags = tags;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DashboardItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_dashboard, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.mImageView.getContext();
        DashboardItemTag tag = mTags.get(position);
        int id = context.getResources().getIdentifier("ootd_" + tag.getItemId(), "drawable", context.getPackageName());
        Glide.with(context).load(id).into(holder.mImageView);
        holder.mButtonLike.setSelected(tag.isSelected());
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
    public DashboardItemTag getItem(int id) {
        return mTags.get(id);
    }

}