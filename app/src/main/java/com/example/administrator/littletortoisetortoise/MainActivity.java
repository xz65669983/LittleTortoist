package com.example.administrator.littletortoisetortoise;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.example.administrator.adapter.ListViewxinAdapter;
import com.example.administrator.adapter.XinFragmentPagerAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.viewpagerindicator.CirclePageIndicator;



public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    private Toolbar tb;
    private ViewPager vp_xinyoulinxi;
    private CirclePageIndicator indicator;
    private View viewpagerheader;
    private PullToRefreshListView mPullRefreshListView;
    private Handler mhandler=new Handler();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        intialToolBar();
       intialPulltoRefreshLayout();

        ListView actualListView = mPullRefreshListView.getRefreshableView();
        actualListView.addHeaderView(viewpagerheader);
        vp_xinyoulinxi.setAdapter(new XinFragmentPagerAdapter(getSupportFragmentManager()));
        indicator.setViewPager(vp_xinyoulinxi);
        actualListView.setAdapter(new ListViewxinAdapter());

    }

    private void intialPulltoRefreshLayout() {
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                String label = DateUtils.formatDateTime(getApplicationContext(), System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                // Update the LastUpdatedLabel
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                mhandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "哈哈 刷新完成啦", Toast.LENGTH_SHORT).show();
                        mPullRefreshListView.onRefreshComplete();
                    }
                }, 2000);


            }
        });


    }


    private void intialToolBar() {
      tb.setTitle("");
        setSupportActionBar(tb);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void findId(){
        tb = (Toolbar) findViewById(R.id.tb);
        viewpagerheader = LayoutInflater.from(this).inflate(R.layout.viewpagerheader, null);
        vp_xinyoulinxi = (ViewPager)  viewpagerheader.findViewById(R.id.vp_xinyoulinxi);
        indicator = (CirclePageIndicator) viewpagerheader.findViewById(R.id.indicator);
        mPullRefreshListView=    (PullToRefreshListView) findViewById(R.id.pull_refresh_list);

    }

}
