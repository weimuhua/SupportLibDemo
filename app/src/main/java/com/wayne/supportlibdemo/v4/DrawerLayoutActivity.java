package com.wayne.supportlibdemo.v4;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wayne.supportlibdemo.BuildConfig;
import com.wayne.supportlibdemo.R;

public class DrawerLayoutActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    private static final String TAG = "DrawerLayoutActivity";
    private static final boolean DEBUG = BuildConfig.DEBUG;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        initView();
        initData();
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
    }

    private void initData() {
        mDrawerLayout.setDrawerListener(this);
        String[] strArr = getResources().getStringArray(R.array.home_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArr);
        mDrawerList.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        if (DEBUG) Log.d(TAG, "onDrawerSlide : " + slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        if (DEBUG) Log.d(TAG, "onDrawerOpened");
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        if (DEBUG) Log.d(TAG, "onDrawerClosed");
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        if (DEBUG) Log.d(TAG, "onDrawerStateChanged");
    }
}
