package com.qwissroll.statement;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by qruol on 25/3/2017.
 */

public class FirstStyleFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private SliderChangeListener mSliderChangeListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.style_page_1, container, false);

        SeekBar seekBar = (SeekBar) view.findViewById(R.id.slider);
        seekBar.setOnSeekBarChangeListener(this);
        return view;
    }

    public static FirstStyleFragment newInstance(String text) {

        FirstStyleFragment f = new FirstStyleFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mSliderChangeListener = (SliderChangeListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Must implement SliderChangeListener");
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (mSliderChangeListener != null) {
            mSliderChangeListener.onSliderChange(progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public void setSliderChangeListener(SliderChangeListener listener) {
        mSliderChangeListener = listener;
    }

    // parent activity will implement this method to respond to slider change events
    public interface SliderChangeListener {
        void onSliderChange(int sliderValue);
    }

}
