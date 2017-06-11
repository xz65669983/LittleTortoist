package com.example.administrator.littletortoisetortoise;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.adapter.FrangmentHomepagerHeadAdapter;
import com.example.administrator.adapter.LvHomePageAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by zzc on 2017/6/11.
 */

public class HomepageActivity extends AppCompatActivity {

    private PullToRefreshListView mPullRefreshListView;
    private ViewPager vp_homepage;
    private CirclePageIndicator indicator_homepage;
    private View headerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        findId();
        initiallistview();
    }


    private void findId() {
        headerview = LayoutInflater.from(HomepageActivity.this).inflate(R.layout.header_homepage, null);
        mPullRefreshListView = (PullToRefreshListView)findViewById(R.id.home_pull_refresh_list);
        vp_homepage = (ViewPager)  headerview.findViewById(R.id.vp_homepage);
        indicator_homepage = (CirclePageIndicator) headerview.findViewById(R.id.indicator_homepage);
    }

    private void initiallistview() {
        ListView listView = mPullRefreshListView.getRefreshableView();
        listView.addHeaderView(headerview);
        vp_homepage.setAdapter(new FrangmentHomepagerHeadAdapter(getSupportFragmentManager()));
        indicator_homepage.setViewPager(vp_homepage);
        listView.setAdapter(new LvHomePageAdapter());


    }
}
