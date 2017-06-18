package com.example.administrator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.Fragment.HomePagerHeadFragment;

import java.util.ArrayList;

/**
 * Created by zzc on 2017/6/11.
 */

public class FrangmentHomepagerHeadAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> arrayList=new ArrayList<>();
    public FrangmentHomepagerHeadAdapter(FragmentManager fm) {
        super(fm);
        arrayList.add(HomePagerHeadFragment.getHomePagerFragmentInstance(0));
        arrayList.add(HomePagerHeadFragment.getHomePagerFragmentInstance(1));
        arrayList.add(HomePagerHeadFragment.getHomePagerFragmentInstance(2));
        arrayList.add(HomePagerHeadFragment.getHomePagerFragmentInstance(3));

    }


    @Override
    public Fragment getItem(int position) {

        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
