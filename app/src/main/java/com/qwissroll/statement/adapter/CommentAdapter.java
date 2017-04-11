package com.qwissroll.statement.adapter;

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
import com.qwissroll.statement.R;
import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private ArrayList<Comment> mComments;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextUsernameView;
        public TextView mTextCommentView;

        public ViewHolder(RelativeLayout v) {
            super(v);
            mImageView =(ImageView) v.findViewById(R.id.comment_avatar);
            mTextUsernameView = (TextView) v.findViewById(R.id.comment_username);
            mTextCommentView = (TextView) v.findViewById(R.id.comment_text);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public CommentAdapter(ArrayList<Comment> comments) {
        mComments = comments;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.mImageView.getContext();
        Comment comment = mComments.get(position);
        // set image
        int id = context.getResources().getIdentifier("user_" + comment.getUsername().toLowerCase(), "drawable", context.getPackageName());
        Glide.with(context).load(id).into(holder.mImageView);
        // set name
        holder.mTextUsernameView.setText(comment.getUsername());
        // set description
        holder.mTextCommentView.setText(comment.getComment());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mComments.size();
    }

}