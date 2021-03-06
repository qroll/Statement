package com.qwissroll.statement.data;

import com.qwissroll.statement.pojo.Outfit;

import java.util.ArrayList;

/**
 * Created by qruol on 25/3/2017.
 */

public class FemaleStyleDataManager extends StyleDataManager {

    protected FemaleStyleDataManager() {
        outfits = new ArrayList<>();

        Outfit outfit1 = new Outfit("Basic", "#EEEEEE");
        outfit1.addItems(1, 2);
        outfits.add(outfit1);

        Outfit outfit2 = new Outfit("Pastel", "#A1DBB2");
        outfit2.addItems(5);
        outfits.add(outfit2);

        Outfit outfit3 = new Outfit("Casual", "#273E62");
        outfit3.addItems(4, 6);
        outfits.add(outfit3);

        Outfit outfit4 = new Outfit("Bold", "#00A1CF");
        outfit4.addItems(10, 3, 8);
        outfits.add(outfit4);
    }

    public static StyleDataManager getInstance() {
        if (instance == null) {
            instance = new FemaleStyleDataManager();
        }
        return instance;
    }

    public Outfit get(int id) {
        return outfits.get(id);
    }
}
