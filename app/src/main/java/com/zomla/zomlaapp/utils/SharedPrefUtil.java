package com.zomla.zomlaapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zomla.zomlaapp.model.viewmodels.Cuisine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikashg on 12/06/17.
 */

public class SharedPrefUtil {

    private static final String TAG = "ZomlaSharedPref";
    private static final String ZOMLA_SHARED_PREF = "ZOMLA_SHARED_PREF";
    private static final String CUISINE_LIST = "cuisine_list";

    //Saving last search result.
    public static void saveCuisineList(Context context, List<Cuisine> cuisineList) {
        ZLog.d(TAG, "");
        String cuisinesJSON = new Gson().toJson(cuisineList);
        SharedPreferences sharedpreferences = context.getSharedPreferences(ZOMLA_SHARED_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(CUISINE_LIST, cuisinesJSON);
        editor.apply();
    }

    // will give last search result.
    public static List<Cuisine> getSavedCuisineList(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(ZOMLA_SHARED_PREF, Context.MODE_PRIVATE);
        String cuisineJSON = sharedpreferences.getString(CUISINE_LIST, null);
        List<Cuisine> cuisineList = new ArrayList<>();
        try {
            cuisineList = new Gson().fromJson(cuisineJSON, new TypeToken<List<Cuisine>>() {
            }.getType());
        } catch (Exception ex) {
            ZLog.e(TAG, ex.getMessage());
        }
        return cuisineList;
    }
}
