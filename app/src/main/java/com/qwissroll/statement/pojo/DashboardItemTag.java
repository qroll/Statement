package com.qwissroll.statement.pojo;

/**
 * Created by qruol on 23/3/2017.
 */

public class DashboardItemTag {

    public int itemId;
    public String itemName;
    public boolean isLiked;

    public DashboardItemTag() {
        itemId = 0;
        itemName = "item_name";
        isLiked = false;
    }

    public DashboardItemTag(int id, String name, boolean _isSelected) {
        itemId = id;
        itemName = name;
        isLiked = _isSelected;
    }

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
}
