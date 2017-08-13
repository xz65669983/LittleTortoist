package com.example.administrator.littletortoisetortoise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zzc on 2017/6/18.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity ";

    @OnClick(R.id.forget_password)
    public void forgetPassword(){
        Intent intent =new Intent(this,FindPasswordActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_register)
    public void signUp(){
        Intent intent=new Intent(this,SignupActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_back)
    public void backUp(){
        finish();
    }
    @OnClick(R.id.btn_login)
    public void login(){
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
        finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
