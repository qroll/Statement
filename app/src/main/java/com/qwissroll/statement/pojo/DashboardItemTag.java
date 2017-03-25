package com.qwissroll.statement.pojo;

import java.util.ArrayList;

/**
 * Created by qruol on 23/3/2017.
 */

public class DashboardItemTag {

    public int itemId;
    public String itemName;
    public boolean isLiked;
    private ArrayList<String> itemTags;

    public DashboardItemTag() {
        itemId = 0;
        itemName = "item_name";
        isLiked = false;
        itemTags = new ArrayList<String>();
    }

    public DashboardItemTag(int id, String name, boolean _isSelected, ArrayList<String> tags) {
        itemId = id;
        itemName = name;
        isLiked = _isSelected;
        itemTags = tags;
    }

    public ArrayList<String> getItemTags() { return itemTags; }

    public String getItemName() {
        return itemName;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean b) {
        isLiked = b;
    }

    public int getItemId() {
        return itemId;
    }

    public String toString() {
        return "" + itemId + ": " + isLiked;
    }

    public boolean isTaggedWith(String tag) {
        return itemTags.contains(tag.toLowerCase());
    }
}
