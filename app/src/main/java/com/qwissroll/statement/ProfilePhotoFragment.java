package com.qwissroll.statement;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by qruol on 25/3/2017.
 */

public class ProfilePhotoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_photo, container, false);

        return view;
    }

    public static ProfilePhotoFragment newInstance() {
        ProfilePhotoFragment fragment = new ProfilePhotoFragment();
        return fragment;
    }

}
