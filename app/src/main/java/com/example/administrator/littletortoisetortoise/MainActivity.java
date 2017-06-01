package com.example.administrator.littletortoisetortoise;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.adapter.ListViewxinAdapter;
import com.example.administrator.adapter.XinFragmentPagerAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viewpagerindicator.CirclePageIndicator;



public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    private static final int REFRESH_COMPLETE = 0X110 ;
    private Toolbar tb;
    private ListView lv_xinyoulinxi;
    private ViewPager vp_xinyoulinxi;
    private CirclePageIndicator indicator;
    private View viewpagerheader;

    private PullToRefreshListView mPullRefreshListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        intialToolBar();
       intialPulltoRefreshLayout();

        lv_xinyoulinxi.addHeaderView(viewpagerheader);
        vp_xinyoulinxi.setAdapter(new XinFragmentPagerAdapter(getSupportFragmentManager()));
        indicator.setViewPager(vp_xinyoulinxi);
         lv_xinyoulinxi.setAdapter(new ListViewxinAdapter());
    }

    private void intialPulltoRefreshLayout() {
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                Toast.makeText(MainActivity.this, "哈哈刷新啦", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    private void intialSwipeRefreshLayout() {
////        srl_main.setProgressViewOffset(true, 50, 200);
//        srl_main.setColorSchemeResources(
//                android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light,
//                android.R.color.holo_orange_light,
//                android.R.color.holo_red_light);
////        srl_main.setProgressBackgroundColorSchemeColor(Color.RED);
//        srl_main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                mHandler.sendEmptyMessageDelayed(REFRESH_COMPLETE, 2000);
//            }
//        });
//    }

    private void intialToolBar() {
      tb.setTitle("");
//        tb.setTitleTextColor(Color.GREEN);
//        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
//        Display defaultDisplay = wm.getDefaultDisplay();
//        int width = defaultDisplay.getWidth();
        setSupportActionBar(tb);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void findId(){
        tb = (Toolbar) findViewById(R.id.tb);
        lv_xinyoulinxi = (ListView) findViewById(R.id.lv_xinyoulinxi);
        viewpagerheader = LayoutInflater.from(this).inflate(R.layout.viewpagerheader, null);
        vp_xinyoulinxi = (ViewPager)  viewpagerheader.findViewById(R.id.vp_xinyoulinxi);
        indicator = (CirclePageIndicator) viewpagerheader.findViewById(R.id.indicator);
//        srl_main = (SwipeRefreshLayout) findViewById(R.id.srl_main);
        mPullRefreshListView=    (PullToRefreshListView) findViewById(R.id.pull_refresh_list);

    }

}
