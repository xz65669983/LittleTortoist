package com.example.administrator.littletortoisetortoise;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.Constant.Fragmentid;
import com.example.administrator.Fragment.PersonalCenterFrangment;
import com.example.administrator.adapter.HomepagerAdapter;
import com.example.administrator.qclCopy.BlurBehind;
import com.example.administrator.qclCopy.OnBlurCompleteListener;

import java.security.cert.CertPathValidatorException;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by zzc on 2017/6/11.
 */

public class HomepageActivity extends AppCompatActivity {

    private static final String TAG ="HomepageActivity" ;
    public boolean islogin=false;
    private ViewPager vp_mainhomePage;
    private Toolbar tb;
    private TextView tv_title;
    private ImageView mtab1;
    private ImageView mtab2;
    private ImageView mtab3;
    private ImageView mtab4;
    private List<ImageView> imageViews = new ArrayList<>();
    private ImageView iv_medium;
    private TextView tv_title_right;
    private final int issueActivityCode=1;
    @OnClick(R.id.tv_title_right)
    public void issueactivity(){
        Intent intent=new Intent(this,IssueActivityActivity.class);
        startActivityForResult(intent,issueActivityCode);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        findid();

        vp_mainhomePage.setAdapter(new HomepagerAdapter(getSupportFragmentManager()));

        vp_mainhomePage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tv_title.setText("首页");
                        clickDone(position);
//                        intialToolBar();
                        break;
                    case 1:
                        tv_title.setText("交友");
                        clickDone(position);
//                        intialToolBar();
                        break;
                    case 2:
                        tv_title.setText("活动");
                        clickDone(position);
//                        intialToolBar();
                        break;
                    case 3:
                        tv_title.setText("个人中心");
                        clickDone(position);
//                        intialToolBar();

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
    }

    ;

    private void clickDone(int index) {
        for (int i = 0; i < imageViews.size(); i++) {
            if (index == i) {
                imageViews.get(i).setBackgroundColor(Color.GREEN);
            } else {
                imageViews.get(i).setBackgroundColor(Color.WHITE);
            }
        }
        switch (index){
            case 0:
                tv_title_right.setVisibility(View.GONE);
                break;
            case 1:
                tv_title_right.setVisibility(View.GONE);
                break;
            case 2:
                tv_title_right.setVisibility(View.VISIBLE);
                break;
            case 3:
                tv_title_right.setVisibility(View.GONE);
                break;

        }

    }

    private void findid() {
        vp_mainhomePage = (ViewPager) findViewById(R.id.vp_mainhomePager);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
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

//    private void intialToolBar() {
//        tb.setTitle("");
//        setSupportActionBar(tb);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i(TAG,"进入了activityresult");
        Log.i(TAG,"Code是"+String.valueOf(requestCode));
        switch (resultCode){

            case 1:
                islogin=true;
                Log.i(TAG,"r进入了equestCode");
                String username = data.getStringExtra("username");
                PagerAdapter adapter = vp_mainhomePage.getAdapter();
                PersonalCenterFrangment pcf = (PersonalCenterFrangment)adapter.instantiateItem(vp_mainhomePage, 3);
                pcf.tv_nickname.setText(username);
                break;
        }
    }
}
