package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Outfit;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class MaleStyleDataManager extends StyleDataManager {

    protected MaleStyleDataManager() {
        outfits = new ArrayList<>();

        Outfit outfit1 = new Outfit("Casual", "#EEEEEE");
        outfit1.addItems(10, 23, 6);
        outfits.add(outfit1);

        Outfit outfit2 = new Outfit("Stripes", "#AAAAAA");
        outfit2.addItems(17, 22);
        outfits.add(outfit2);

        Outfit outfit3 = new Outfit("Blue", "#273E62");
        outfit3.addItems(30, 22);
        outfits.add(outfit3);

        Outfit outfit4 = new Outfit("Bold", "#C24F3A");
        outfit4.addItems(14, 21);
        outfits.add(outfit4);
    }

    public static StyleDataManager getInstance() {
        if (instance == null) {
            instance = new MaleStyleDataManager();
        }
        return instance;
    }

    public Outfit get(int id) {
        return outfits.get(id);
    }
}
