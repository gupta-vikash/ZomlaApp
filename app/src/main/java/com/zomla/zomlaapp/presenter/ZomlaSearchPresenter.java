package com.zomla.zomlaapp.presenter;

import android.content.Context;

import com.zomla.zomlaapp.model.networkservices.NetworkManager;
import com.zomla.zomlaapp.model.networkutils.NetworkDetails;
import com.zomla.zomlaapp.model.pojo.Restaurant;
import com.zomla.zomlaapp.model.pojo.SearchRequest;
import com.zomla.zomlaapp.model.pojo.SearchResponse;
import com.zomla.zomlaapp.model.pojo.ZRestaurant;
import com.zomla.zomlaapp.model.viewmodels.Cuisine;
import com.zomla.zomlaapp.utils.ZLog;
import com.zomla.zomlaapp.view.views.MainView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vikashg on 05/06/17.
 */

public class ZomlaSearchPresenter implements Presenter, Callback<SearchResponse> {
    private static final String TAG = ZomlaSearchPresenter.class.getSimpleName();
    private MainView mView;
    private Context mContext;

    public ZomlaSearchPresenter(MainView view) {
        mView = view;
        mContext = view.getContext();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }

    public void getSearchResult(String query) {
        mView.showProgress();
        NetworkManager networkManager = NetworkManager.getInstance();
        if (networkManager != null && networkManager.isConnectedToNetwork(mContext)) {
            searchRestaurants(query);
        } else {
            mView.hideProgress();
            mView.showErrorDialogue("Not connected to Internet...");
        }
    }

    private void searchRestaurants(String query) {
        SearchRequest searchRequest = createSearchRequest(query);
        NetworkManager.getInstance().searchRestaurants(searchRequest, this);
    }

    private SearchRequest createSearchRequest(String query) {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setKeyWords(query);
        searchRequest.setUserKey(NetworkDetails.API_KEY);
        return searchRequest;
    }

    @Override
    public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
        mView.hideProgress();
        ZLog.d(TAG, "onResponse - " + response.code());
        if (response.isSuccessful()) {
            ZLog.d(TAG, "successfully received data");
            createAndPassDataTOView(response);
        } else {
            ZLog.d(TAG, " failed to load data " + response.code());
            mView.showErrorDialogue("Failed to fetch data. \nError Code" + response.code());
        }
    }

    @Override
    public void onFailure(Call<SearchResponse> call, Throwable t) {
        ZLog.d(TAG, "failed to load data");
        mView.hideProgress();
        mView.showErrorDialogue("Something went wrong");
    }

    private void createAndPassDataTOView(Response<SearchResponse> response) {
        if (response == null || response.body() == null) {
            ZLog.e(TAG, "response body is null");
            return;
        }
        List<ZRestaurant> zRestaurants = response.body().getRestaurants();
        if (zRestaurants.size() == 0) {
            mView.showErrorDialogue("No Restaurant found with this keyword");
            return;
        }
        HashMap<String, Cuisine> cuisineAndRestaurantMap = new HashMap<>();
        for (ZRestaurant zRestaurant : zRestaurants) {
            Restaurant restaurant = zRestaurant.getRestaurant();
            String cuisines = restaurant.getCuisines();
            List<String> cuisineList = Arrays.asList(cuisines.split("\\s*,\\s*"));
            for (String c : cuisineList) {
                if (!cuisineAndRestaurantMap.containsKey(c)) {
                    ArrayList<Restaurant> restaurants = new ArrayList<>();
                    restaurants.add(restaurant);
                    Cuisine cuisine = new Cuisine(c, restaurants);
                    cuisineAndRestaurantMap.put(c, cuisine);
                } else {
                    Cuisine cuisine = cuisineAndRestaurantMap.get(c);
                    cuisine.getChildList().add(restaurant);
                }
            }
        }

        Iterator it = cuisineAndRestaurantMap.entrySet().iterator();
        List<Cuisine> cuisineList = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            cuisineList.add((Cuisine) pair.getValue());
        }
        mView.updateList(cuisineList);
    }
}
