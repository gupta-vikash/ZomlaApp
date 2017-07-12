package com.zomla.zomlaapp.model.networkservices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.zomla.zomlaapp.model.pojo.SearchRequest;
import com.zomla.zomlaapp.model.pojo.SearchResponse;
import com.zomla.zomlaapp.utils.ZLog;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by vikashg on 05/06/17.
 */

public class NetworkManager {
    private final String TAG = NetworkManager.class.getSimpleName();
    private static NetworkManager networkManager;
    private ZomatoNetworkServices zomatoNetworkServices;

    public static NetworkManager getInstance() {
        if (networkManager == null) {
            synchronized (NetworkManager.class) {
                if (networkManager == null) {
                    networkManager = new NetworkManager();
                }
            }
        }
        return networkManager;
    }

    public final boolean isConnectedToNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            } else {
                ZLog.d(TAG, "Not connected to network");
            }
        } else {
            ZLog.e(TAG, "connectivityManager is null");
        }
        return false;
    }

    private NetworkManager() {
        zomatoNetworkServices = ServiceGenerator.createService(ZomatoNetworkServices.class);
    }

    public void searchRestaurants(SearchRequest searchRequest, Callback<SearchResponse> callback) {
        Call<SearchResponse> call = zomatoNetworkServices.getSearchResults(searchRequest.getUserKey(),
                searchRequest.getQueries());
        call.enqueue(callback);
    }


}
