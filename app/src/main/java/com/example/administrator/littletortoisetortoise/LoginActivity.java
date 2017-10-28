package com.example.administrator.littletortoisetortoise;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.Retrofit.MyRetrofit;
import com.example.administrator.Retrofit.UserService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by zzc on 2017/6/18.
 */

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity ";
    @BindView(R.id.login_phone)
    EditText login_phone;
    @BindView(R.id.login_password)
    EditText login_password;

    @OnClick(R.id.forget_password)
    public void forgetPassword() {
        Intent intent = new Intent(this, FindPasswordActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_register)
    public void signUp() {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_back)
    public void backUp() {
        finish();
    }

    @OnClick(R.id.btn_login)
    public void login()  {

        Retrofit retrofit = MyRetrofit.getInstance();
        UserService userService = retrofit.create(UserService.class);
        JSONObject jsonObject=new JSONObject();

        try {
            jsonObject.put("username","贺老板");
            jsonObject.put("password","大帅哥");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String s = jsonObject.toString();
        Log.i(TAG,s);

        RequestBody body= RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),s);
        Call<ResponseBody> call = userService.login(body);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.i(TAG,"接收到的信息为："+response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i(TAG,"连接服务器失败");

            }
        });

//
//        SharedPreferences userInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
//        String username = userInfo.getString("username", "");
//        String password = userInfo.getString("password", "");
//        Log.i(TAG,"用户名为："+username);
//        Log.i(TAG,"密码为："+password);
//        String loginPhone = login_phone.getText().toString();
//        String loginPassword = login_password.getText().toString();
//        if(username.contentEquals(loginPhone)&&password.equals(loginPassword)){
//            Intent intent=new Intent();
//            intent.putExtra("username",username);
//            setResult(1,intent);
//            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
//            finish();
//        }else{
//            Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
//        }



    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
