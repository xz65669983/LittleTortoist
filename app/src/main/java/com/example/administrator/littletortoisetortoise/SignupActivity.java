package com.example.administrator.littletortoisetortoise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import com.example.administrator.Constant.ErrorCode;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/7/23.
 */

public class SignupActivity extends AppCompatActivity {
    @OnClick(R.id.btn_back)
    public void back() {
        finish();
    }

    @OnClick(R.id.btn_signup)
    public void finsihSignup() {
        //判断输入是否正确
        int legal = isLegal();
        switch (legal) {
            case 0:
                SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = userInfo.edit();
                edit.putString("username", input_name.getText().toString());
                edit.putString("password", input_password.getText().toString());
                edit.commit();
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, IdentifyIDActivity.class);
                startActivity(intent);
                finish();
                break;
            case ErrorCode.EMPTY_NAME:
                Toast.makeText(this, "账户不能为空", Toast.LENGTH_SHORT).show();
                break;
            case ErrorCode.EMPTY_PASSWARD:
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                break;
            case ErrorCode.NOT_SAME_PASSWORD:
                Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                break;


        }

    }

    @BindView(R.id.input_name)
    EditText input_name;
    @BindView(R.id.input_email)
    EditText input_email;
    @BindView(R.id.input_mobile)
    EditText input_mobile;
    @BindView(R.id.input_password)
    EditText input_password;
    @BindView(R.id.input_reEnterPassword)
    EditText input_reEnterPassword;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

    }

    private int isLegal() {
        if (input_name.getText().toString().equals("")) {
            return ErrorCode.EMPTY_NAME;
        } else if (input_password.getText().toString().equals("")) {
            return ErrorCode.EMPTY_PASSWARD;
        } else if (!input_password.getText().toString().equals(input_reEnterPassword.getText().toString())) {
            return ErrorCode.NOT_SAME_PASSWORD;
        } else {
            return 0;
        }
    }

}
