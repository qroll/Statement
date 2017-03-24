package com.qwissroll.statement;

import com.qwissroll.statement.view.DashboardItem;

/**
 * Created by qruol on 23/3/2017.
 */

public class DashboardItemTag {

    public boolean isSelected;
    public int itemId;

    public DashboardItemTag() {
        isSelected = false;
        itemId = 0;
    }

    public DashboardItemTag(int id) {
        isSelected = false;
        itemId = id;
    }

    public void setSelected(boolean b) {
        isSelected = b;
    }

    public void setItemId(int i) {
        itemId = i;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getItemId() {
        return itemId;
    }

    public String toString() {
        return "" + itemId + ": " + isSelected;
    }
}
