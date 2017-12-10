package com.example.easywallet;

/**
 * Created by Jack on 12/10/2017.
 */

public class moneyitem {

    public final int id;
    public final String title;
    public final int money;
    public final String picture;

    public moneyitem(int id, String title, int money, String picture) {
        this.id = id;
        this.title = title;
        this.money = money;
        this.picture = picture;
    }
    @Override
    public String toString() {
        return title;
    }
}


