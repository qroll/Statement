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
        dashboardItems.add(new DashboardItemTag(1, false));
        dashboardItems.add(new DashboardItemTag(2, true));
        dashboardItems.add(new DashboardItemTag(3, false));
        dashboardItems.add(new DashboardItemTag(4, false));
        dashboardItems.add(new DashboardItemTag(1, false));
        dashboardItems.add(new DashboardItemTag(2, false));
    }

    public ArrayList<DashboardItemTag> getAll() {
        return dashboardItems;
    }

}
