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
                new ArrayList<>(Arrays.asList("casual", "jeans", "pants", "long sleeved", "long-sleeved", "layer", "jacket", "white", "trainers")));
        item1.addComment(new Comment("Jalina", "Love the jacket!"));
        item1.addComment(new Comment("Bella", "Inspiration <3"));
        item1.setLikes(5);
        dashboardItems.put(1, item1);

        DashboardItem item2 = new DashboardItem(2, "Safari", true,
                new ArrayList<>(Arrays.asList("hijab", "tudung", "lace", "lacy", "spring", "long sleeved", "long-sleeved", "khaki", "white")));
        item2.addComment(new Comment("Jalina", "Classic colour combination :)"));
        item2.setLikes(4);
        dashboardItems.put(2, item2);

        DashboardItem item3 = new DashboardItem(3, "Sea breeze", false,
                new ArrayList<>(Arrays.asList("casual", "bohemian", "beachwear", "spring", "summer", "embroidered", "loose", "long sleeve", "long-sleeved", "white")));
        item3.setLikes(1);
        dashboardItems.put(3, item3);

        DashboardItem item4 = new DashboardItem(4, "Girl Next Door", false,
                new ArrayList<>(Arrays.asList("casual", "jeans", "pants", "checker", "pattern", "jacket", "layer", "long sleeve", "long-sleeved", "boots")));
        item4.setLikes(0);
        dashboardItems.put(4, item4);

        DashboardItem item5 = new DashboardItem(12, "Monday Blues", false,
                new ArrayList<>(Arrays.asList("casual", "bold", "summer", "hijab", "tudung", "print", "pattern", "jacket", "layer", "long sleeve", "long-sleeved", "denim", "blue")));
        item5.addComment(new Comment("Julia", "I can relate omg"));
        item5.setLikes(6);
        dashboardItems.put(12, item5);

        DashboardItem item6 = new DashboardItem(6, "Whatever", false,
                new ArrayList<>(Arrays.asList("casual", "dress", "boots", "spring", "floral", "print", "pattern", "leggings")));
        item6.addComment(new Comment("Jalina", "cute!!!"));
        item6.setLikes(3);
        dashboardItems.put(6, item6);

        DashboardItem item7 = new DashboardItem(13, "Red", false,
                new ArrayList<>(Arrays.asList("casual", "bold", "hijab", "tudung", "checker", "pattern", "red", "long sleeved", "long-sleeved")));
        item7.setLikes(1);
        dashboardItems.put(13, item7);
    }

    public static OutfitDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleOutfitDataManager();
        }
        return instance;
    }

}
