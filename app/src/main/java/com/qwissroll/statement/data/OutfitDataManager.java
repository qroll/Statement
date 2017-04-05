package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Comment;
import com.qwissroll.statement.pojo.DashboardItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qruol on 25/3/2017.
 */

public class OutfitDataManager {

    protected static Map<Integer, DashboardItem> dashboardItems;
    protected static OutfitDataManager instance;

    protected OutfitDataManager() {
        dashboardItems = new HashMap<>();
    }

    public static OutfitDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleOutfitDataManager();
        }
        return instance;
    }

    public DashboardItem get(int id) {
        return dashboardItems.get(id);
    }

    public ArrayList<DashboardItem> getAll() {
        return new ArrayList(Arrays.asList(dashboardItems.values().toArray()));
    }

    public ArrayList<DashboardItem> getAllWithTag(String tag) {
        ArrayList<DashboardItem> items = new ArrayList<DashboardItem>();
        for (Map.Entry<Integer, DashboardItem> item : dashboardItems.entrySet()) {
            if (item.getValue().isTaggedWith(tag)) {
                items.add(item.getValue());
            }
        }
        return items;
    }

    public ArrayList<DashboardItem> getAllWithAnyTags(Collection<String> tags) {
        ArrayList<DashboardItem> items = new ArrayList<DashboardItem>();
        for (Map.Entry<Integer, DashboardItem> item : dashboardItems.entrySet()) {
            for (String tag : tags) {
                if (item.getValue().isTaggedWith(tag)) {
                    items.add(item.getValue());
                    break;
                }
            }
        }
        return items;
    }

}
