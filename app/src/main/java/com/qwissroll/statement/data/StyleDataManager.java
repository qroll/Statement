package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DashboardItem;
import com.qwissroll.statement.pojo.Outfit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by qruol on 25/3/2017.
 */

public class StyleDataManager {

    protected static ArrayList<Outfit> outfits;
    protected static StyleDataManager instance;

    protected StyleDataManager() {
        outfits = new ArrayList<>();
    }

    public static StyleDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleStyleDataManager();
        }
        return instance;
    }

    public Outfit get(int id) {
        return outfits.get(id);
    }
}
