package com.example.administrator.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.application.MyAppliciation;
import com.example.administrator.littletortoisetortoise.R;
import com.squareup.picasso.Picasso;

/**
 * Created by zzc on 2017/6/11.
 */

public class HomePagerFragment extends Fragment {
    private int postion;

    public static HomePagerFragment getHomePagerFragmentInstance(int postion) {
        HomePagerFragment  hpf=new HomePagerFragment ();
        hpf.setPostion(postion);
        return  hpf;

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepager_listhead,container, false);
        ImageView iv_homepage_vp= (ImageView) view.findViewById(R.id.iv_homepage_vp);
        switch (postion) {
            case 0:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.qbl).into(iv_homepage_vp);
                break;
            case 1:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.flower).into(iv_homepage_vp);
                break;
            case 2:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.pxm).into(iv_homepage_vp);
                break;
            case 3:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.ljl).into(iv_homepage_vp);
                break;
            default:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.flower).into(iv_homepage_vp);
                break;
        }

        return view;
    }
    public void setPostion(int postion){
        this.postion=postion;
    }
}
