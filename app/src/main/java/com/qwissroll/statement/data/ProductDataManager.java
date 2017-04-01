package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qruol on 25/3/2017.
 */

public class ProductDataManager {

    private static Map<Integer, ArrayList<DetailItem>> items;
    private static ProductDataManager instance;

    private ProductDataManager() {
        items = new HashMap<Integer, ArrayList<DetailItem>>();

        ArrayList<DetailItem> first = new ArrayList<DetailItem>();
        first.add(new DetailItem(1, "Embroidered Jacket", "aaa", false));
        first.add(new DetailItem(2, "White button-up shirt", "aaa", false));
        first.add(new DetailItem(3, "Blue jeans", "aaa", false));
        items.put(1, first);

        ArrayList<DetailItem> second = new ArrayList<DetailItem>();
        second.add(new DetailItem(4, "Hijab", "aaa", false));
        second.add(new DetailItem(5, "Lace top", "aaa", false));
        items.put(2, second);

        ArrayList<DetailItem> third = new ArrayList<DetailItem>();
        third.add(new DetailItem(6, "Free Spirit Top", "aaa", false));
        items.put(3, third);

        ArrayList<DetailItem> fourth = new ArrayList<DetailItem>();
        fourth.add(new DetailItem(7, "Checkered shirt", "aaa", false));
        fourth.add(new DetailItem(8, "Black jeans", "aaa", false));
        items.put(4, fourth);
    }

    public static ProductDataManager getInstance() {
        if (instance == null) {
            instance = new ProductDataManager();
        }
        return instance;
    }

    public ArrayList<DetailItem> get(Integer id) {
        return items.get(id);
    }

}
