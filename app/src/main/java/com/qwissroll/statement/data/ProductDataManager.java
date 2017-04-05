package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qruol on 25/3/2017.
 */

public class ProductDataManager {

    protected static Map<Integer, ArrayList<DetailItem>> items;
    protected static ProductDataManager instance;

    protected ProductDataManager() {
        items = new HashMap<Integer, ArrayList<DetailItem>>();
    }

    public static ProductDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleProductDataManager();
        }
        return instance;
    }

    public ArrayList<DetailItem> get(Integer id) {
        return items.get(id);
    }

}
