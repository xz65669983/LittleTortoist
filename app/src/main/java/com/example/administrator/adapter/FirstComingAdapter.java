package com.example.administrator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.Fragment.FirstComingFragment;
import com.example.administrator.littletortoisetortoise.FirsrtComingActvity;

import java.util.ArrayList;

/**
 * Created by zzc on 2017/8/13.
 */

public class FirstComingAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> arrayList=new ArrayList<>();
    public FirstComingAdapter(FragmentManager fm){
        super(fm);
        arrayList.add(FirstComingFragment.getFirstComingFragmentInstance(0));
        arrayList.add(FirstComingFragment.getFirstComingFragmentInstance(1));
        arrayList.add(FirstComingFragment.getFirstComingFragmentInstance(2));

    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }
}
