package com.example.administrator.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.application.MyAppliciation;
import com.example.administrator.littletortoisetortoise.R;

/**
 * Created by zzc on 2017/6/11.
 */

public class LvHomePageAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null){
            view=LayoutInflater.from(MyAppliciation.getcontext())
                    .inflate(R.layout.listview_homepage,parent,false);
        }else{
            view= convertView;
        }

        return view;
    }
}
