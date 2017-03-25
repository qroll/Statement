package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.DashboardItemTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by qruol on 25/3/2017.
 */

public class OutfitDataManager {

    private ArrayList<DashboardItemTag> dashboardItems;

    public OutfitDataManager() {
        dashboardItems = new ArrayList<DashboardItemTag>();
        dashboardItems.add(new DashboardItemTag(1, "Casual Friday", false,
                new ArrayList<String>(Arrays.asList("casual", "jeans", "long sleeved", "white"))));
        dashboardItems.add(new DashboardItemTag(2, "Safari", true,
                new ArrayList<String>(Arrays.asList("hijab", "lace", "long sleeved", "khaki"))));
        dashboardItems.add(new DashboardItemTag(3, "Sea breeze", false,
                new ArrayList<String>(Arrays.asList("casual", "bohemian", "loose", "white"))));
        dashboardItems.add(new DashboardItemTag(4, "Girl Next Door", false,
                new ArrayList<String>(Arrays.asList("casual", "jeans", "checkered", "long sleeved"))));
        dashboardItems.add(new DashboardItemTag(1, "Whatever", false,
                new ArrayList<String>(Arrays.asList("casual", "jeans", "long sleeved", "white"))));
        dashboardItems.add(new DashboardItemTag(2, "Anything", false,
                new ArrayList<String>(Arrays.asList("hijab", "lace", "long sleeved", "khaki"))));
    }

    public ArrayList<DashboardItemTag> getAll() {
        return dashboardItems;
    }

    public ArrayList<DashboardItemTag> getAllWithTag(String tag) {
        ArrayList<DashboardItemTag> items = new ArrayList<DashboardItemTag>();
        for (DashboardItemTag item : dashboardItems) {
            if (item.isTaggedWith(tag)) {
                items.add(item);
            }
        }
        return items;
    }

    public ArrayList<DashboardItemTag> getAllWithAnyTags(Collection<String> tags) {
        ArrayList<DashboardItemTag> items = new ArrayList<DashboardItemTag>();
        for (DashboardItemTag item : dashboardItems) {
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
