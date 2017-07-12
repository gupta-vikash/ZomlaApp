package com.zomla.zomlaapp.model.viewmodels;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import com.zomla.zomlaapp.model.pojo.Restaurant;

import java.util.List;

/**
 * Created by vikashg on 11/06/17.
 */

public class Cuisine implements Parent<Restaurant> {
    private List<Restaurant> mRestaurants;
    private String cuisineName;

    public Cuisine(String name,List<Restaurant> restaurants){
        mRestaurants = restaurants;
        cuisineName = name;
    }
    @Override
    public List<Restaurant> getChildList() {
        return mRestaurants;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }

    public String getName() {
        return cuisineName;
    }
}
