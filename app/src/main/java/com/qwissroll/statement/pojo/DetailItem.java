package com.qwissroll.statement.pojo;

/**
 * Created by qruol on 23/3/2017.
 */

public class DetailItem {

    public int itemId;
    public String itemName;
    public String itemDescription;
    public boolean isAdded;

    public DetailItem() {
        itemId = 0;
        itemName = "item_name";
        itemDescription = "item_description";
        isAdded = false;
    }

    public DetailItem(int id, String name, String description, boolean _isAdded) {
        itemId = id;
        itemName = name;
        itemDescription = description;
        isAdded = _isAdded;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public boolean isAdded() {
        return isAdded;
    }

    public void setAdded(boolean b) {
        isAdded = b;
    }

    public int getItemId() {
        return itemId;
    }

    public String toString() {
        return "" + itemId + ": \"" + itemName + "\",\"" + itemDescription + "\"";
    }
}
