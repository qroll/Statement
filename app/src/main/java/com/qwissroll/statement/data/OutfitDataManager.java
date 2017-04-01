package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by qruol on 25/3/2017.
 */

public class OutfitDataManager {

    private static ArrayList<DashboardItem> dashboardItems;
    private static OutfitDataManager instance;

    private OutfitDataManager() {
        dashboardItems = new ArrayList<>();

        DashboardItem item1 = new DashboardItem(1, "Casual Friday", false,
                new ArrayList<>(Arrays.asList("casual", "jeans", "long sleeved", "white")));
        item1.addComment(new Comment("Jalina", "Love the jacket!"));
        item1.addComment(new Comment("Bella", "Inspiration <3"));
        item1.setLikes(5);
        dashboardItems.add(item1);

        DashboardItem item2 = new DashboardItem(2, "Safari", true,
                new ArrayList<>(Arrays.asList("hijab", "lace", "long sleeved", "khaki")));
        item2.addComment(new Comment("Jalina", "White and khaki is always classic"));
        item2.setLikes(4);
        dashboardItems.add(item2);

        DashboardItem item3 = new DashboardItem(3, "Sea breeze", false,
                new ArrayList<>(Arrays.asList("casual", "bohemian", "loose", "white")));
        item3.setLikes(1);
        dashboardItems.add(item3);

        DashboardItem item4 = new DashboardItem(4, "Girl Next Door", false,
                new ArrayList<>(Arrays.asList("casual", "jeans", "checkered", "long sleeved")));
        item4.setLikes(0);
        dashboardItems.add(item4);

        DashboardItem item5 = new DashboardItem(5, "Whatever", false,
                new ArrayList<>(Arrays.asList("casual", "cool", "jeans", "jacket", "black", "monotone")));
        item5.addComment(new Comment("Jonathan", "You look like a celebrity :)"));
        item5.setLikes(2);
        dashboardItems.add(item5);

        DashboardItem item6 = new DashboardItem(6, "Anything", false,
                new ArrayList<>(Arrays.asList("casual", "dress", "boots", "florals", "prints", "bag")));
        item6.addComment(new Comment("Julia", "cute!!!"));
        item6.setLikes(3);
        dashboardItems.add(item6);
    }

    public static OutfitDataManager getInstance() {
        if (instance == null) {
            instance = new OutfitDataManager();
        }
        return instance;
    }

    public ArrayList<DashboardItem> getAll() {
        return dashboardItems;
    }

    public ArrayList<DashboardItem> getAllWithTag(String tag) {
        ArrayList<DashboardItem> items = new ArrayList<DashboardItem>();
        for (DashboardItem item : dashboardItems) {
            if (item.isTaggedWith(tag)) {
                items.add(item);
            }
        }
        return items;
    }

    public ArrayList<DashboardItem> getAllWithAnyTags(Collection<String> tags) {
        ArrayList<DashboardItem> items = new ArrayList<DashboardItem>();
        for (DashboardItem item : dashboardItems) {
            for (String tag : tags) {
                if (item.isTaggedWith(tag)) {
                    items.add(item);
                    break;
                }
            }
        }
        return items;
    }

}
