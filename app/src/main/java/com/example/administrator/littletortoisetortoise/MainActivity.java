package com.example.administrator.littletortoisetortoise;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.adapter.ListViewxinAdapter;
import com.example.administrator.adapter.XinFragmentPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {

    private Toolbar tb;
    private ListView lv_xinyoulinxi;
    private ViewPager vp_xinyoulinxi;
    private CirclePageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        tb.setNavigationIcon(R.mipmap.back);
        tb.setTitle("");
        setSupportActionBar(tb);
        vp_xinyoulinxi.setAdapter(new XinFragmentPagerAdapter(getSupportFragmentManager()));
        indicator.setViewPager(vp_xinyoulinxi);
         lv_xinyoulinxi.setAdapter(new ListViewxinAdapter());
    }
    private void findId(){
        tb = (Toolbar) findViewById(R.id.tb);
        lv_xinyoulinxi = (ListView) findViewById(R.id.lv_xinyoulinxi);
        vp_xinyoulinxi = (ViewPager) findViewById(R.id.vp_xinyoulinxi);
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
    }
}
