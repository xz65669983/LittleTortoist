package com.example.administrator.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.adapter.ListViewxinAdapter;
import com.example.administrator.adapter.XinFragmentPagerAdapter;
import com.example.administrator.littletortoisetortoise.R;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viewpagerindicator.CirclePageIndicator;

/**
 * Created by zzc on 2017/6/18.
 */

public class MakefriendFragment extends Fragment {
    private static final String TAG = "MakeFriendsFragment";
    private Toolbar tb;
    private ViewPager vp_xinyoulinxi;
    private CirclePageIndicator indicator;
    private View viewpagerheader;
    private PullToRefreshListView mPullRefreshListView;
    private Handler mhandler = new Handler();
    private FragmentActivity mactivity;
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_makfriend, container, false);
        findId();
        initiallistview();
        intialPulltoRefreshLayout();
        return view;
    }




    private void findId() {
        viewpagerheader = LayoutInflater.from(mactivity).inflate(R.layout.viewpagerheader, null);
        vp_xinyoulinxi = (ViewPager) viewpagerheader.findViewById(R.id.vp_xinyoulinxi);
        indicator = (CirclePageIndicator) viewpagerheader.findViewById(R.id.indicator);
        mPullRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);

    }
    private void initiallistview() {
        ListView actualListView = mPullRefreshListView.getRefreshableView();
        actualListView.addHeaderView(viewpagerheader);
        vp_xinyoulinxi.setAdapter(new XinFragmentPagerAdapter(mactivity.getSupportFragmentManager()));
        indicator.setViewPager(vp_xinyoulinxi);
        actualListView.setAdapter(new ListViewxinAdapter());
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