package com.example.administrator.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.adapter.FrangmentHomepagerHeadAdapter;
import com.example.administrator.adapter.HomepagerAdapter;
import com.example.administrator.adapter.LvHomePageAdapter;
import com.example.administrator.littletortoisetortoise.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by zzc on 2017/6/18.
 */

public class HomePagerFragment extends Fragment {

    private View view;
    private PullToRefreshListView mPullRefreshListView;
    private ViewPager vp_homepage;
    private CirclePageIndicator indicator_homepage;
    private View headerview;
    private FragmentActivity mactivity;
    private Handler mhandler=new Handler();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_viewpager,container,false);
        findId();
        initiallistview();
        intialPulltoRefreshLayout();
        return view;
    }
    private void findId() {
        headerview = LayoutInflater.from(mactivity).inflate(R.layout.header_homepage, null);
        mPullRefreshListView = (PullToRefreshListView)view.findViewById(R.id.home_pull_refresh_list);
        vp_homepage = (ViewPager)  headerview.findViewById(R.id.vp_homepage);
        indicator_homepage = (CirclePageIndicator) headerview.findViewById(R.id.indicator_homepage);
    }
    private void initiallistview() {
        ListView listView = mPullRefreshListView.getRefreshableView();
        listView.addHeaderView(headerview);
//        vp_homepage.setAdapter(new FrangmentHomepagerHeadAdapter(mactivity.getSupportFragmentManager()));
        vp_homepage.setAdapter(new FrangmentHomepagerHeadAdapter(getChildFragmentManager()));
        indicator_homepage.setViewPager(vp_homepage);
        listView.setAdapter(new LvHomePageAdapter());


    }
    private void intialPulltoRefreshLayout() {
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(mactivity.getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                mhandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullRefreshListView.onRefreshComplete();
                    }
                }, 2000);


            }
        });
    }
}
