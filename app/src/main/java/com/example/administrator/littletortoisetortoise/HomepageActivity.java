package com.example.administrator.littletortoisetortoise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.example.administrator.Fragment.PersonalCenterFrangment;
import com.example.administrator.adapter.HomepagerAdapter;
import butterknife.BindView;
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

    private TextView tv_title_right;
    private final int issueActivityCode=1;
    @OnClick(R.id.tv_title_right)
    public void issueactivity(){
        Intent intent=new Intent(this,IssueActivityActivity.class);
        startActivityForResult(intent,issueActivityCode);

    }
    @BindView(R.id.home_navigation)
   public BottomNavigationView btHomeNavigation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        ButterKnife.bind(this);
        findid();

        btHomeNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_navgation_first:
                        vp_mainhomePage.setCurrentItem(0);
                        break;
                    case R.id.home_navgation_second:
                        vp_mainhomePage.setCurrentItem(1);
                        break;
                    case R.id.home_navgation_third:
                        vp_mainhomePage.setCurrentItem(2);
                        break;
                    case R.id.home_navgation_forth:
                        vp_mainhomePage.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

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
                        tv_title_right.setVisibility(View.GONE);
                        btHomeNavigation.getMenu().getItem(position).setChecked(true);
                        break;
                    case 1:
                        tv_title.setText("交友");
                        tv_title_right.setVisibility(View.GONE);
                        btHomeNavigation.getMenu().getItem(position).setChecked(true);
                        break;
                    case 2:
                        tv_title.setText("活动");
                        tv_title_right.setVisibility(View.VISIBLE  );
                        btHomeNavigation.getMenu().getItem(position).setChecked(true);
                        break;
                    case 3:
                        tv_title.setText("个人中心");
                        tv_title_right.setVisibility(View.GONE);
                        btHomeNavigation.getMenu().getItem(position).setChecked(true);

                    default:
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void findid() {
        vp_mainhomePage = (ViewPager) findViewById(R.id.vp_mainhomePager);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title_right = (TextView) findViewById(R.id.tv_title_right);
        tb = (Toolbar) findViewById(R.id.tb);

    }

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
