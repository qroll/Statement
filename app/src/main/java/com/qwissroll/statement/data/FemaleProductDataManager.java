package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.DetailItem;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by qruol on 6/4/2017.
 */

public class FemaleProductDataManager extends ProductDataManager {

    protected FemaleProductDataManager() {
        items = new LinkedHashMap<>();

        ArrayList<DetailItem> first = new ArrayList<DetailItem>();
        first.add(new DetailItem(15, "White button-up shirt", "", false));
        first.add(new DetailItem(23, "Blue jeans", "", false));
        first.add(new DetailItem(12, "Embroidered Jacket", "", false));
        items.put(1, first);

        ArrayList<DetailItem> second = new ArrayList<DetailItem>();
        second.add(new DetailItem(35, "Tudung", "", false));
        second.add(new DetailItem(18, "Lace dress", "", false));
        items.put(2, second);

        ArrayList<DetailItem> third = new ArrayList<DetailItem>();
        third.add(new DetailItem(6, "Free Spirit Top", "", false));
        items.put(3, third);

        ArrayList<DetailItem> fourth = new ArrayList<DetailItem>();
        fourth.add(new DetailItem(34, "Checkered shirt", "", false));
        fourth.add(new DetailItem(32, "Black jeans", "", false));
        items.put(4, fourth);

        ArrayList<DetailItem> fifth = new ArrayList<DetailItem>();
        fifth.add(new DetailItem(36, "Denim jacket", "", false));
        items.put(12, fifth);

        ArrayList<DetailItem> sixth = new ArrayList<DetailItem>();
        sixth.add(new DetailItem(7, "Blue dress", "", false));
        items.put(6, sixth);

        ArrayList<DetailItem> seventh = new ArrayList<DetailItem>();
        items.put(13, seventh);
    }

    public static ProductDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleProductDataManager();
        }
        return instance;
    }

}
