package com.zomla.zomlaapp.view.views;

import android.content.Context;

import com.zomla.zomlaapp.model.viewmodels.Cuisine;

import java.util.List;

/**
 * Created by vikashg on 09/06/17.
 */

public interface MainView {
    Context getContext();

    void showProgress();

    void hideProgress();

    void showErrorDialogue(String errorMessage);

    void updateList(List<Cuisine> cuisineList);
}
