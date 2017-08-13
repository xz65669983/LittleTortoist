package com.example.administrator.littletortoisetortoise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/23.
 */

public class SignupActivity extends AppCompatActivity {
    @OnClick(R.id.btn_back)
    public void back(){
        finish();
    }
    @OnClick(R.id.btn_signup)
    public  void finsihSignup(){
        Intent intent=new Intent(this,IdentifyIDActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);
    }
}
