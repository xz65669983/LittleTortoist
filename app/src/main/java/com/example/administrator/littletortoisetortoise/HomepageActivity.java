package com.example.administrator.littletortoisetortoise;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.administrator.adapter.LvHomePageAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by zzc on 2017/6/11.
 */

public class HomepageActivity extends AppCompatActivity {

    private PullToRefreshListView mPullRefreshListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        findId();
        initiallistview();
    }


    private void findId() {
        mPullRefreshListView = (PullToRefreshListView)findViewById(R.id.home_pull_refresh_list);
    }

    private void initiallistview() {
        ListView listView = mPullRefreshListView.getRefreshableView();
        listView.setAdapter(new LvHomePageAdapter());

    }
}
