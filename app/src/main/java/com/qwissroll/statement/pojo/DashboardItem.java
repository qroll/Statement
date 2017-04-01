package com.qwissroll.statement.pojo;

import java.util.ArrayList;

/**
 * Created by qruol on 23/3/2017.
 */

public class DashboardItem {

    private int itemId;
    private String itemName;
    private boolean isLiked;
    private ArrayList<Comment> comments;
    private int likes;
    private ArrayList<String> itemTags;

    public DashboardItem() {
        itemId = 0;
        itemName = "item_name";
        isLiked = false;
        comments = new ArrayList<>();
        likes = 0;
        itemTags = new ArrayList<>();
    }

    public DashboardItem(int id, String name, boolean _isSelected, ArrayList<String> tags) {
        itemId = id;
        itemName = name;
        isLiked = _isSelected;
        comments = new ArrayList<>();
        likes = 0;
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

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(String username, String comment) {
        comments.add(new Comment(username, comment));
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(int num) {
        likes = num;
    }

}
