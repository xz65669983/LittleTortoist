package com.example.administrator.littletortoisetortoise;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.example.administrator.Constant.ErrorCode;
import com.example.administrator.Retrofit.MyRetrofit;
import com.example.administrator.Retrofit.UserService;
import com.example.administrator.model.Header;
import com.example.administrator.model.RegisterModel;
import com.example.administrator.model.User;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Administrator on 2017/7/23.
 */

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    @OnClick(R.id.btn_back)
    public void back() {
        finish();
    }

    @OnClick(R.id.btn_signup)
    public void finsihSignup() {
        //判断输入是否正确
     /*   int legal = isLegal();
        switch (legal) {
            case ErrorCode.EMPTY_NAME:
                Toast.makeText(this, "账户不能为空", Toast.LENGTH_SHORT).show();
                break;
            case ErrorCode.EMPTY_PASSWARD:
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                break;
            case ErrorCode.NOT_SAME_PASSWORD:
                Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                break;
        }*/
        //输入正确
        // if(legal==0){
//        RegisterModel registerModel = new RegisterModel();
//        User user=new User();
//        user.setUserAcc("xz65669983");
//        user.setPwd("123456789");
//        user.setPhoneNumber("65669983");
//        user.setUserName("zzc");
//        user.setMale(0);
//        user.setEmail("zzcfuji@126.com");
//        user.setNickName("curry");
//        user.setUserGrade(0);
//        user.setVerifyType(0);
//        registerModel.setHeader(new Header());
//        registerModel.setUser(user);
//
//        Retrofit retrofit = MyRetrofit.getGsonRetrofitInstance();
//        UserService userService = retrofit.create(UserService.class);
//
//        Call<ResponseBody> responseBodyCall = userService.signUp(registerModel);
//        responseBodyCall.enqueue(new Callback<ResponseBody>() {
//
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                try {
//                    Log.i(TAG, response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e(TAG,"注册失败");
//            }
//        });
        // }
        Intent intent=new Intent(SignupActivity.this,IdentifyIDActivity.class);
        startActivity(intent);
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
