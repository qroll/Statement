package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by qruol on 6/4/2017.
 */

public class MaleOutfitDataManager extends OutfitDataManager {

    protected MaleOutfitDataManager() {
        dashboardItems = new LinkedHashMap<>();

        DashboardItem item1 = new DashboardItem(10, "Prom Day", false,
                new ArrayList<>(Arrays.asList("formal", "bowtie", "long sleeved", "monochrome")));
        item1.setLikes(7);
        dashboardItems.put(10, item1);

        DashboardItem item2 = new DashboardItem(5, "Black is the new black", false,
                new ArrayList<>(Arrays.asList("casual", "jacket", "jeans", "long sleeved", "denim", "black", "monochrome")));
        item2.addComment(new Comment("Jonathan", "You look like a celebrity :)"));
        item2.setLikes(2);
        dashboardItems.put(5, item2);
    }

    public static OutfitDataManager getInstance() {
        if (instance == null) {
            instance = new MaleOutfitDataManager();
        }
        return instance;
    }

}
