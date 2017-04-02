package com.qwissroll.statement.pojo;

import java.util.ArrayList;

/**
 * Created by qruol on 1/4/2017.
 */

public class Outfit {

    private ArrayList<Integer> mItems;
    private String mStyle;
    private String mColor;

    public Outfit() {
        mItems = new ArrayList<>();
        mStyle = "";
        mColor = "#EEEEEE";
    }

    public Outfit(String style, String color) {
        mItems = new ArrayList<>();
        mStyle = style;
        mColor = color;
    }

    public void setStyle(String s) {
        mStyle = s;
    }

    public void addItem(Integer s) {
        mItems.add(s);
    }

    public void addItems(Integer... items) {
        for (Integer s : items) {
            mItems.add(s);
        }
    }

    public ArrayList<Integer> getItems() {
        return mItems;
    }

    public String getStyle() { return mStyle; }

    public String getColor() { return mColor; }

}
