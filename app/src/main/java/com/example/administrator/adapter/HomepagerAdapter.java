package com.example.administrator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.Fragment.ActivityFrament;
import com.example.administrator.Fragment.HomePagerFragment;
import com.example.administrator.Fragment.MakefriendFragment;
import com.example.administrator.Fragment.PersonalCenterFrangment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzc on 2017/6/18.
 */

public class HomepagerAdapter extends FragmentPagerAdapter {
      List<Fragment> fragments=new ArrayList<>();
    public HomepagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new HomePagerFragment());
        fragments.add(new MakefriendFragment());
        fragments.add(new ActivityFrament());
        fragments.add(new PersonalCenterFrangment());

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
