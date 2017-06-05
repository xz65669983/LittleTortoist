package com.example.administrator.littletortoisetortoise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.adapter.ActivityCenterAdapter;

/**
 * Created by Administrator on 2017/6/3.
 */

public class ActivityActivity extends AppCompatActivity {

    private Toolbar tb;
    private ListView lv_activity_center;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actiivity);
        findId();
        initialtoolbar();
        initiallistview();

    }

    private void initiallistview() {
        lv_activity_center.setAdapter(new ActivityCenterAdapter());
    }

    private void initialtoolbar() {
        tb.setTitle("");
        setSupportActionBar(tb);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void findId() {
        tb = (Toolbar) findViewById(R.id.tb);
        lv_activity_center = (ListView) findViewById(R.id.lv_activity_center);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
}
