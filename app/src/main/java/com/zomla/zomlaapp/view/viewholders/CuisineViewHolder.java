package com.zomla.zomlaapp.view.viewholders;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.zomla.zomlaapp.R;
import com.zomla.zomlaapp.model.viewmodels.Cuisine;

/**
 * Created by vikashg on 11/06/17.
 */

public class CuisineViewHolder extends ParentViewHolder {
    private TextView cuisineTextView;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this ViewHolder
     */
    public CuisineViewHolder(@NonNull View itemView) {
        super(itemView);
        cuisineTextView = (TextView) itemView.findViewById(R.id.cuisineTextView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpanded()) {
                    collapseView();
                } else {
                    expandView();
                }
            }
        });
    }

    public void bind(Cuisine cuisine) {
        cuisineTextView.setText(cuisine.getName());
    }
}
