package com.example.administrator.littletortoisetortoise;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
/**
 * Created by zzc on 2017/6/11.
 */

public class IssueActivityActivity extends AppCompatActivity {

    private Toolbar tb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issueactivity);
        findview();
        initialtoolbar();
    }

    private void findview() {
        tb = (Toolbar) findViewById(R.id.tb);
    }

    private void initialtoolbar() {
        tb.setTitle("");
        setSupportActionBar(tb);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
