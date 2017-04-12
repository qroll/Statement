package com.qwissroll.statement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qwissroll.statement.activity.ImageDetailActivity;
import com.qwissroll.statement.adapter.DashboardItemAdapter;
import com.qwissroll.statement.data.OutfitDataManager;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class ProfilePhotoFragment extends Fragment
        implements DashboardItemAdapter.DashboardItemClickListener {

    private static final int REQUEST_CODE_DEFAULT = 1;
    private static final int REQUEST_CODE_ITEM_DETAIL_COMMENT = 2;

    DashboardItemAdapter dashboardItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_photo, container, false);
        OutfitDataManager outfitDataManager = OutfitDataManager.getInstance();
        ArrayList<DashboardItem> dashboardItems = new ArrayList<>();
        dashboardItems.add(outfitDataManager.get(8));
        dashboardItems.add(outfitDataManager.get(6));

        RecyclerView dashboard = (RecyclerView) view.findViewById(R.id.dashboard);
        dashboardItemAdapter = new DashboardItemAdapter(dashboardItems);
        dashboardItemAdapter.setClickListener(this);
        dashboard.setLayoutManager(new LinearLayoutManager(getContext()));
        dashboard.setAdapter(dashboardItemAdapter);
        dashboard.setNestedScrollingEnabled(false);
        RecyclerView.ItemAnimator animator = dashboard.getItemAnimator();
        if (animator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        return view;
    }

    public static ProfilePhotoFragment newInstance() {
        ProfilePhotoFragment fragment = new ProfilePhotoFragment();
        return fragment;
    }

    @Override
    public void onItemImageClick(View view, int position) {
        int itemId = dashboardItemAdapter.getItem(position).getItemId();
        dispatchItemDetailActivity(itemId, REQUEST_CODE_DEFAULT);
    }

    @Override
    public void onItemCommentClick(View view, int position) {
        int itemId = dashboardItemAdapter.getItem(position).getItemId();
        dispatchItemDetailActivity(itemId, REQUEST_CODE_ITEM_DETAIL_COMMENT);
    }

    @Override
    public void onItemLikeClick(View view, int position) {
        int itemId = dashboardItemAdapter.getItem(position).getItemId();
        dispatchItemDetailActivity(itemId, REQUEST_CODE_DEFAULT);
    }

    public void dispatchItemDetailActivity(int itemId, int requestCode) {
        Intent intent = new Intent(getActivity(), ImageDetailActivity.class);
        intent.putExtra("itemId", itemId);
        intent.putExtra("isComment", requestCode == REQUEST_CODE_ITEM_DETAIL_COMMENT);
        startActivityForResult(intent, requestCode);
    }

}
