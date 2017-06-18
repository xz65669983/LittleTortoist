package com.example.administrator.littletortoisetortoise;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.qclCopy.BlurBehind;

/**
 * Created by zzc on 2017/6/18.
 */

public class MoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        BlurBehind.getInstance()//在你需要添加模糊或者透明的背景中只需要设置这几行简单的代码就可以了
                .withAlpha(50)
                .withFilterColor(Color.parseColor("#ffffff"))
                .setBackground(this);
        ImageView iv_minus= (ImageView) findViewById(R.id.iv_minus);
        iv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
