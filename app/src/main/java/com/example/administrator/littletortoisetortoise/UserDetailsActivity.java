package com.example.administrator.littletortoisetortoise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/30.
 */

public class UserDetailsActivity extends AppCompatActivity {
    @OnClick(R.id.revise_password_txt)
    public void revisePassword(){
        Intent intent =new Intent(UserDetailsActivity.this,RevisePasswordActivity.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn_save)
    public void save(){
        finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spuser_details);
        ButterKnife.bind(this);
    }
}
