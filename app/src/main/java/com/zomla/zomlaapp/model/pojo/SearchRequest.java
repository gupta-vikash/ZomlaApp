package com.zomla.zomlaapp.model.pojo;

import com.google.gson.annotations.SerializedName;
import com.zomla.zomlaapp.model.networkutils.ZomatoConstants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vikashg on 07/06/17.
 */

public class SearchRequest {
    private Map<String, String> queries;

    public SearchRequest() {
        queries = new HashMap<>();
    }

    @SerializedName("user-key")
    private String userKey;

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public Map<String, String> getQueries() {
        return queries;
    }

    public void setEntityId(String entityId) {
        queries.put(ZomatoConstants.ENTITY_ID, entityId);
    }

    public void setEntityType(String entityType) {
        queries.put(ZomatoConstants.ENTITY_TYPE, entityType);
    }

    public void setKeyWords(String keyWords) {
        queries.put(ZomatoConstants.SEARCH_KEYWORD, keyWords);
    }

    public void setStart(String start) {
        queries.put(ZomatoConstants.START, start);
    }

    public void setCount(String count) {
        queries.put(ZomatoConstants.COUNT, count);
    }

    public void setLatitude(String lat) {
        queries.put(ZomatoConstants.LATITUDE, lat);
    }

    public void setLongitude(String lon) {
        queries.put(ZomatoConstants.LONGITUDE, lon);
    }

    public void setRadius(String radius) {
        queries.put(ZomatoConstants.RADIUS, radius);
    }

    public void setCuisines(String cuisines) {
        queries.put(ZomatoConstants.CUISINES, cuisines);
    }

    public void setEstablishmentType(String establishmentType) {
        queries.put(ZomatoConstants.ESTABLISHMENT_TYPE, establishmentType);
    }

    public void setCollectionId(String collectionId) {
        queries.put(ZomatoConstants.COLLECTION_ID, collectionId);
    }

    public void setCategory(String category) {
        queries.put(ZomatoConstants.CATEGORY, category);
    }

    public void setSortOption(String sort) {
        queries.put(ZomatoConstants.SORT, sort);
    }

    public void setSortingOrder(String order) {
        queries.put(ZomatoConstants.ORDER, order);
    }
}
