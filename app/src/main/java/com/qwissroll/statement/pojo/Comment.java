package com.qwissroll.statement.pojo;

/**
 * Created by qruol on 1/4/2017.
 */

public class Comment {

    private String mUsername;
    private String mComment;

    public Comment() {
        mUsername = "Guest";
        mComment = "";
    }

    public Comment(String username, String comment) {
        mUsername = username;
        mComment = comment;
    }

    public String getUsername() {
        return mUsername;
    }

    public String getComment() {
        return mComment;
    }

}
