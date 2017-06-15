package com.example.administrator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.administrator.Fragment.XinVeiwPagerFragment;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/5/21.
 */

public class XinFragmentPagerAdapter extends FragmentPagerAdapter {
     ArrayList<Fragment> arrayList=new ArrayList<>();
    public XinFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        arrayList.add(XinVeiwPagerFragment.getXinFragmentInstance(0));
        arrayList.add(XinVeiwPagerFragment.getXinFragmentInstance(1));
        arrayList.add(XinVeiwPagerFragment.getXinFragmentInstance(2));
        arrayList.add(XinVeiwPagerFragment.getXinFragmentInstance(3));
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
