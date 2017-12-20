package com.example.android.foodpanda;

/**
 * Created by Hunter on 12/16/2017.
 * Each object has 3 properties: item name, item price, and image resource ID.

 */

public class MenuItem {
    private String mItemName;
    private String mItemPrice;
    private int mImageResourceId;


    public MenuItem(String iName, String iPrice)
    {
        mItemName = iName;
        mItemPrice = iPrice;
    }
    public MenuItem(String iName, String iPrice, int imageResourceId)
    {
        mItemName = iName;
        mItemPrice = iPrice;
        mImageResourceId = imageResourceId;
    }

    public String getItemName() {
        return mItemName;
    }

    public String getmItemPrice() {
        return mItemPrice;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

}
