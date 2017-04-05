package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Created by qruol on 6/4/2017.
 */

public class FemaleOutfitDataManager extends OutfitDataManager {

    protected FemaleOutfitDataManager() {
        dashboardItems = new LinkedHashMap<>();

        DashboardItem item1 = new DashboardItem(1, "Casual Friday", false,
                new ArrayList<>(Arrays.asList("casual", "jeans", "long sleeved", "white")));
        item1.addComment(new Comment("Jalina", "Love the jacket!"));
        item1.addComment(new Comment("Bella", "Inspiration <3"));
        item1.setLikes(5);
        dashboardItems.put(1, item1);

        DashboardItem item2 = new DashboardItem(2, "Safari", true,
                new ArrayList<>(Arrays.asList("hijab", "lace", "long sleeved", "khaki")));
        item2.addComment(new Comment("Jalina", "White and khaki is always classic"));
        item2.setLikes(4);
        dashboardItems.put(2, item2);

        DashboardItem item3 = new DashboardItem(3, "Sea breeze", false,
                new ArrayList<>(Arrays.asList("casual", "bohemian", "loose", "white")));
        item3.setLikes(1);
        dashboardItems.put(3, item3);

        DashboardItem item4 = new DashboardItem(4, "Girl Next Door", false,
                new ArrayList<>(Arrays.asList("casual", "jeans", "checkered", "long sleeved")));
        item4.setLikes(0);
        dashboardItems.put(4, item4);

        DashboardItem item5 = new DashboardItem(6, "Anything", false,
                new ArrayList<>(Arrays.asList("casual", "dress", "boots", "florals", "prints", "bag")));
        item5.addComment(new Comment("Julia", "cute!!!"));
        item5.setLikes(3);
        dashboardItems.put(6, item5);
    }

    public static OutfitDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleOutfitDataManager();
        }
        return instance;
    }

}
