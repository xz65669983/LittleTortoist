package com.example.administrator.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.application.MyAppliciation;
import com.example.administrator.littletortoisetortoise.EventDetailsActivity;
import com.example.administrator.littletortoisetortoise.R;

import java.util.LinkedList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2017/6/5.
 */

public class ActivityCenterAdapter extends BaseAdapter {
    LinkedList<View> linkedList;

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
        if (convertView == null) {
            view = LayoutInflater.from(MyAppliciation.getcontext()).inflate(R.layout.listview_activity_center, parent, false);

        } else {
            view = convertView;
        }
        Button bt_activitydetials= (Button) view.findViewById(R.id.bt_activitydetials);
        bt_activitydetials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyAppliciation.getcontext(), EventDetailsActivity.class);
                MyAppliciation.getcontext().startActivity(intent);
            }
        });
        return view;
    }

    public void setLinkedList(LinkedList linkedList) {
        this.linkedList = linkedList;

    }
}
