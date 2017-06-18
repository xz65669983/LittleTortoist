package com.example.administrator.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.adapter.ActivityCenterAdapter;
import com.example.administrator.littletortoisetortoise.R;

/**
 * Created by zzc on 2017/6/18.
 */

public class ActivityFrament extends Fragment {

    private FragmentActivity mactivity;
    private ListView lv_activity_center;
    private View view;
    private View list_header;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_actvity, container, false);
        findId();
        initiallistview();
        return view;
    }

    private void findId() {
        lv_activity_center = (ListView) view.findViewById(R.id.lv_activity_center);
        list_header = LayoutInflater.from(mactivity).inflate(R.layout.head_lv_activitiy_center, null);
    }


    private void initiallistview() {
        lv_activity_center.addHeaderView(list_header);
        lv_activity_center.setAdapter(new ActivityCenterAdapter());

    }

}
