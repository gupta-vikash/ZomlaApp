package com.zomla.zomlaapp.presenter;

/**
 * Created by vikashg on 05/06/17.
 */

public interface Presenter {
    void onCreate();

    void onPause();

    void onResume();

    void onDestroy();

    void getSearchResult(String query);
}
