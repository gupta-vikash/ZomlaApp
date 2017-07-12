package com.zomla.zomlaapp.view.viewholders;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.squareup.picasso.Picasso;
import com.zomla.zomlaapp.R;
import com.zomla.zomlaapp.model.pojo.Restaurant;
import com.zomla.zomlaapp.utils.ZLog;

/**
 * Created by vikashg on 11/06/17.
 */

public class RestaurantViewHolder extends ChildViewHolder {
    private static final String TAG = RestaurantViewHolder.class.getSimpleName();
    private ImageView restaurantImageView;
    private TextView restaurantNameTextView;
    private TextView ratingTextView;
    private TextView costTextView;
    private TextView addressTextView;

    public RestaurantViewHolder(View itemView) {
        super(itemView);
        restaurantImageView = (ImageView) itemView.findViewById(R.id.restaurantThumbImage);
        restaurantNameTextView = (TextView) itemView.findViewById(R.id.restaurantName);
        ratingTextView = (TextView) itemView.findViewById(R.id.ratingText);
        costTextView = (TextView) itemView.findViewById(R.id.avgCostForTwoValue);
        addressTextView = (TextView) itemView.findViewById(R.id.restaurantAddress);
    }

    public void bind(Context context, Restaurant restaurant) {
        restaurantNameTextView.setText(restaurant.getName());
        ratingTextView.setText(restaurant.getUserRating().getAggregateRating());
        try {
            ratingTextView.setBackgroundColor(Color.parseColor("#" + restaurant.getUserRating().getRatingColor()));
        } catch (Exception ex) {
            ZLog.w(TAG, ex.getMessage());
        }
        costTextView.setText(restaurant.getCurrency() + " " + restaurant.getAverageCostForTwo());
        addressTextView.setText(restaurant.getLocation().getAddress());
        try {
            Picasso.with(context)
                    .load(restaurant.getThumb())
                    .error(R.drawable.zomato_default)
                    .fit()
                    .into(restaurantImageView);
        } catch (Exception ex) {
            restaurantImageView.setImageResource(R.drawable.zomato_default);
        }
    }
}
