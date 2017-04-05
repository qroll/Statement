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

import com.bumptech.glide.Glide;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qruol on 25/3/2017.
 */

public class DashboardItemAdapter extends RecyclerView.Adapter<DashboardItemAdapter.ViewHolder> {
    private ArrayList<DashboardItem> mItems;
    private DashboardItemClickListener mClickListener;

    private static final Integer PAYLOAD_BUTTON_LIKE_CLICKED = 1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public DashboardItemAdapter(ArrayList<DashboardItem> items) {
        mItems = items;
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Context context = holder.mImageView.getContext();
        final DashboardItem item = mItems.get(position);
        int id = context.getResources().getIdentifier("ootd_" + item.getItemId(), "drawable", context.getPackageName());
        holder.mImageView.setImageDrawable(null);
        Glide.with(context).load(id).into(holder.mImageView);
        holder.mButtonLike.setActivated(item.isLiked());
        holder.mTextComment.setText("" + item.getComments().size());
        holder.mTextLike.setText("" + item.getLikes());
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            final DashboardItem item = mItems.get(position);
            holder.mButtonLike.setActivated(item.isLiked());
            holder.mTextComment.setText("" + item.getComments().size());
            holder.mTextLike.setText("" + item.getLikes());
        }
    }

    // Return the size of the dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mItems.size();
    }

    // Return the tag at specified position
    // Convenience method for getting data at click position
    public DashboardItem getItem(int id) {
        return mItems.get(id);
    }

    // Allows clicks events to be caught by the parent activity
    public void setClickListener(DashboardItemClickListener dashboardItemClickListener) {
        this.mClickListener = dashboardItemClickListener;
    }

    // Parent activity will implement these methods to respond to click events
    public interface DashboardItemClickListener {
        void onItemImageClick(View view, int position);
        void onItemCommentClick(View view, int position);
        void onItemLikeClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mImageView;
        public ImageButton mButtonLike;
        public ImageButton mButtonComment;
        public TextView mTextLike;
        public TextView mTextComment;

        public ViewHolder(RelativeLayout v) {
            super(v);
            mImageView =(ImageView) v.findViewById(R.id.image);
            mImageView.setOnClickListener(this);
            mButtonLike =(ImageButton) v.findViewById(R.id.button_like);
            mButtonLike.setOnClickListener(this);
            mButtonComment =(ImageButton) v.findViewById(R.id.button_comment);
            mButtonComment.setOnClickListener(this);
            mTextLike = (TextView) v.findViewById(R.id.text_like);
            mTextComment = (TextView) v.findViewById(R.id.text_comment);
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
                        DashboardItem tag = mItems.get(getAdapterPosition());
                        mButtonLike.setActivated(tag.isLiked());
                        notifyItemChanged(getAdapterPosition(), PAYLOAD_BUTTON_LIKE_CLICKED);
                        break;
                    case R.id.button_comment:
                        mClickListener.onItemCommentClick(view, getAdapterPosition());
                        break;
                }
            }
        }
    }

}