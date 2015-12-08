package com.wayne.supportlibdemo.v7;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wayne.supportlibdemo.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        initData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    }

    private void initData() {
        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("acb");
        strList.add("bac");
        strList.add("bca");
        strList.add("cba");
        strList.add("cab");
        TemplateAdapter adapter = new TemplateAdapter(strList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }

    private class TemplateAdapter extends RecyclerView.Adapter<TemplateViewHolder> {

        private List<String> mStringList;

        public TemplateAdapter(List<String> stringList) {
            mStringList = stringList;
        }

        @Override
        public TemplateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.recycler_view_item, null);
            return new TemplateViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TemplateViewHolder holder, int position) {
            if (mStringList != null) {
                holder.mTextView.setText(mStringList.get(position));
                holder.mButton.setText(mStringList.get(position));
            }
        }

        @Override
        public int getItemCount() {
            if (mStringList == null) {
                return 0;
            }
            return mStringList.size();
        }
    }

    private class TemplateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTextView;
        public Button mButton;

        public TemplateViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.item_textview);
            mButton = (Button) itemView.findViewById(R.id.item_button);
            mButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), mTextView.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
