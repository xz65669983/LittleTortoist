package com.example.administrator.littletortoisetortoise;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.adapter.HomepagerAdapter;
import com.example.administrator.qclCopy.BlurBehind;
import com.example.administrator.qclCopy.OnBlurCompleteListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zzc on 2017/6/11.
 */

public class HomepageActivity extends AppCompatActivity {


    private ViewPager vp_mainhomePage;
    private Toolbar tb;
    private TextView tv_title;
    private ImageView mtab1;
    private ImageView mtab2;
    private ImageView mtab3;
    private ImageView mtab4;
    private List<ImageView> imageViews=new ArrayList<>();
    private Button bt_login;
    private ImageView iv_medium;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        findid();
       intialToolBar();
        vp_mainhomePage.setAdapter(new HomepagerAdapter(getSupportFragmentManager()));

        vp_mainhomePage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        tv_title.setText("首页");
                        clickDone(position);
                        intialToolBar();
                        break;
                    case 1:
                        tv_title.setText("交友");
                        clickDone(position);
                        intialToolBar();
                        break;
                    case 2:
                        tv_title.setText("活动");
                        clickDone(position);
                        intialToolBar();
                        break;
                    case 3:
                        tv_title.setText("个人中心");
                        clickDone(position);
                        intialToolBar();

                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mtab1.setOnClickListener(new MyOnClickListener(0));
        mtab2.setOnClickListener(new MyOnClickListener(1));
        mtab3.setOnClickListener(new MyOnClickListener(2));
        mtab4.setOnClickListener(new MyOnClickListener(3));
        mtab1.performClick();
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        iv_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlurBehind.getInstance().execute(HomepageActivity.this, new OnBlurCompleteListener() {
                    @Override
                    public void onBlurComplete() {
                        Intent intent = new Intent(HomepageActivity.this, MoreActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }
                });

            }
        });

    }



    public class MyOnClickListener implements View.OnClickListener {
        private int index = 0;

        public MyOnClickListener(int i) {
            index = i;
        }

        public void onClick(View v) {
            vp_mainhomePage.setCurrentItem(index);
         clickDone(index);
        }
    };
private void clickDone(int index){
    for(int i=0;i<imageViews.size();i++){
        if(index==i){
            imageViews.get(i).setBackgroundColor(Color.GREEN);
        }else{
            imageViews.get(i).setBackgroundColor(Color.WHITE);
        }
    }

}
    private void findid() {
        vp_mainhomePage = (ViewPager)findViewById(R.id.vp_mainhomePager);
        tv_title = (TextView) findViewById(R.id.tv_title);
        bt_login = (Button) findViewById(R.id.bt_login);
        tb = (Toolbar) findViewById(R.id.tb);
        mtab1 = (ImageView) findViewById(R.id.iv_homepage);
        mtab2 = (ImageView) findViewById(R.id.iv_makefriend);
        mtab3 = (ImageView) findViewById(R.id.iv_activity);
        mtab4 = (ImageView) findViewById(R.id.iv_personalcenter);
        iv_medium = (ImageView) findViewById(R.id.iv_medium);
        imageViews.add(mtab1);
        imageViews.add(mtab2);
        imageViews.add(mtab3);
        imageViews.add(mtab4);


    }

    private void intialToolBar() {
        tb.setTitle("");
        bt_login.setVisibility(View.GONE);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }



}
