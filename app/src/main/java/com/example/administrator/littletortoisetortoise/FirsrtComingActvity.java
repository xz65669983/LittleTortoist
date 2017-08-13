package com.example.administrator.littletortoisetortoise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.adapter.FirstComingAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zzc on 2017/8/13.
 */


public class FirsrtComingActvity extends AppCompatActivity {

    @BindView(R.id.vp_firstcoming)
    ViewPager vp_firstcoming;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_coming);
        ButterKnife.bind(this);
        vp_firstcoming.setAdapter(new FirstComingAdapter(getSupportFragmentManager()));

    }
}
