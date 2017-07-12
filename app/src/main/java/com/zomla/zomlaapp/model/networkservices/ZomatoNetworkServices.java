package com.zomla.zomlaapp.model.networkservices;

import com.zomla.zomlaapp.model.pojo.SearchResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

/**
 * Created by vikashg on 05/06/17.
 */

public interface ZomatoNetworkServices {

    @GET("search")
    Call<SearchResponse> getSearchResults(@Header("user-key") String user_key,
                                          @QueryMap Map<String, String> queries);

}
