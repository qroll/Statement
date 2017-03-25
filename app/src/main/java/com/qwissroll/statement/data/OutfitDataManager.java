package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.DashboardItemTag;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class OutfitDataManager {

    private ArrayList<DashboardItemTag> dashboardItems;

    public OutfitDataManager() {
        dashboardItems = new ArrayList<DashboardItemTag>();
        dashboardItems.add(new DashboardItemTag(1, "Casual Friday", false));
        dashboardItems.add(new DashboardItemTag(2, "Safari", true));
        dashboardItems.add(new DashboardItemTag(3, "Sea breeze", false));
        dashboardItems.add(new DashboardItemTag(4, "Girl Next Door", false));
        dashboardItems.add(new DashboardItemTag(1, "Whatever", false));
        dashboardItems.add(new DashboardItemTag(2, "Anything", false));
    }

    public ArrayList<DashboardItemTag> getAll() {
        return dashboardItems;
    }

}
