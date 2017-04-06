package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by qruol on 6/4/2017.
 */

public class MaleProductDataManager extends ProductDataManager {

    protected MaleProductDataManager() {
        items = new LinkedHashMap<Integer, ArrayList<DetailItem>>();

        ArrayList<DetailItem> first = new ArrayList<DetailItem>();
        first.add(new DetailItem(10, "White t-shirt", "", false));
        first.add(new DetailItem(23, "Blue jeans", "", false));
        items.put(11, first);

        ArrayList<DetailItem> second = new ArrayList<DetailItem>();
        second.add(new DetailItem(31, "T-shirt", "", false));
        second.add(new DetailItem(32, "Black jeans", "", false));
        items.put(5, second);

        ArrayList<DetailItem> third = new ArrayList<DetailItem>();
        third.add(new DetailItem(33, "Fedora", "", false));
        third.add(new DetailItem(15, "White button-up shirt", "", false));
        items.put(10, third);
    }

    public static ProductDataManager getInstance() {
        if (instance == null) {
            instance = new MaleProductDataManager();
        }
        return instance;
    }

}
