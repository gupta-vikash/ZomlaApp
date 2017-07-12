package com.zomla.zomlaapp.view.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.zomla.zomlaapp.R;
import com.zomla.zomlaapp.model.viewmodels.Cuisine;
import com.zomla.zomlaapp.presenter.Presenter;
import com.zomla.zomlaapp.presenter.ZomlaSearchPresenter;
import com.zomla.zomlaapp.utils.SharedPrefUtil;
import com.zomla.zomlaapp.utils.ZLog;
import com.zomla.zomlaapp.view.adapters.CuisineAdapter;
import com.zomla.zomlaapp.view.views.MainView;

import java.util.ArrayList;
import java.util.List;

public class ZomlaMainActivity extends AppCompatActivity implements MainView {
    private final String TAG = ZomlaMainActivity.class.getSimpleName();
    private Presenter mPresenter;
    private RecyclerView mRecyclerView;
    private CuisineAdapter cuisineAdapter;
    private List<Cuisine> mCuisineList;
    private ProgressDialog progressDialog;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ZLog.d(TAG, "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        initListViews();
    }

    private void initData() {
        mCuisineList = SharedPrefUtil.getSavedCuisineList(getApplicationContext());
        if (mCuisineList == null || mCuisineList.isEmpty()) {
            ZLog.e(TAG, "cuisine list is null or empty");
            mCuisineList = new ArrayList<>();
            showEmptyMessage();
        } else {
            ZLog.e(TAG, "cuisine list is null or empty");
            hideEmptyMessage();
        }
    }

    private void showEmptyMessage() {
        emptyTextView.setVisibility(View.VISIBLE);
    }

    private void hideEmptyMessage() {
        emptyTextView.setVisibility(View.GONE);
    }

    private void initViews() {
        emptyTextView = (TextView) findViewById(R.id.emptyTextMessage);
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading...");
    }

    private void initListViews() {
        mPresenter = new ZomlaSearchPresenter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //mCuisineList = new ArrayList<>();
        cuisineAdapter = new CuisineAdapter(this, mCuisineList);
        mRecyclerView.setAdapter(cuisineAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        } else {
            ZLog.d(TAG, "search view is null");
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        ZLog.d(TAG, "onNewIntent");
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        ZLog.d(TAG, "handle intent");
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            mPresenter.getSearchResult(query);
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

    //View Methods
    @Override
    public void showProgress() {
        if (progressDialog != null) {
            progressDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }

    }

    @Override
    public void showErrorDialogue(String errorMessage) {
        ZLog.e(TAG, "Show error dialogue " + errorMessage);
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(errorMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void updateList(List<Cuisine> cuisineList) {
        ZLog.d(TAG, "update list " + cuisineList.size());
        if (cuisineList.isEmpty()) {
            showEmptyMessage();
        } else {
            hideEmptyMessage();
        }
        SharedPrefUtil.saveCuisineList(getApplicationContext(), cuisineList);
        cuisineAdapter.setParentList(cuisineList, false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
        progressDialog = null;
    }
}
