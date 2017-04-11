package com.qwissroll.statement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qruol on 25/3/2017.
 */

public class ProfileWishlistFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_wishlist, container, false);

        return view;
    }

    public static ProfileWishlistFragment newInstance() {
        ProfileWishlistFragment fragment = new ProfileWishlistFragment();
        return fragment;
    }

}
