package com.example.administrator.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/5/21.
 */

public class MyAppliciation extends Application {

     static Context mycontext;

    @Override
    public void onCreate() {
        super.onCreate();
        mycontext = getApplicationContext();
    }
    public static Context getcontext(){
        return mycontext;

    }
}
