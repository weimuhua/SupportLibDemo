package com.wayne.supportlibdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wayne.supportlibdemo.v4.DrawerLayoutActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final int INTENT_DRAWERLAYOUT_ACTIVITY = 0;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.home_listview);
    }

    private void initData() {
        String[] strArr = getResources().getStringArray(R.array.home_item);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strArr);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case INTENT_DRAWERLAYOUT_ACTIVITY:
                startActivity(new Intent(this, DrawerLayoutActivity.class));
                break;
        }
    }
}
