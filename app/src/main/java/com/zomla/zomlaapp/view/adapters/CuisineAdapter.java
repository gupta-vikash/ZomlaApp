package com.zomla.zomlaapp.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.zomla.zomlaapp.R;
import com.zomla.zomlaapp.model.pojo.Restaurant;
import com.zomla.zomlaapp.model.viewmodels.Cuisine;
import com.zomla.zomlaapp.view.viewholders.CuisineViewHolder;
import com.zomla.zomlaapp.view.viewholders.RestaurantViewHolder;

import java.util.List;

/**
 * Created by vikashg on 06/06/17.
 */

public class CuisineAdapter extends ExpandableRecyclerAdapter<Cuisine, Restaurant, CuisineViewHolder, RestaurantViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<Cuisine> mCuisineList;

    public CuisineAdapter(Context context, @NonNull List<Cuisine> cuisineList) {
        super(cuisineList);
        mContext = context;
        mCuisineList = cuisineList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CuisineViewHolder onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
        View cuisineView = mInflater.inflate(R.layout.list_item_cuisine, parentViewGroup, false);
        return new CuisineViewHolder(cuisineView);
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
        View restaurantView = mInflater.inflate(R.layout.list_item_restraunt, childViewGroup, false);
        return new RestaurantViewHolder(restaurantView);
    }

    @Override
    public void onBindParentViewHolder(@NonNull CuisineViewHolder parentViewHolder, int parentPosition, @NonNull Cuisine parent) {
        parentViewHolder.bind(parent);
    }

    @Override
    public void onBindChildViewHolder(@NonNull RestaurantViewHolder childViewHolder, int parentPosition, int childPosition, @NonNull Restaurant child) {
        childViewHolder.bind(mContext, child);
    }
}
