package com.example.administrator.littletortoisetortoise;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.application.MyAppliciation;
import com.squareup.picasso.Picasso;


/**
 * Created by Administrator on 2017/5/20.
 */

public class XinVeiwPagerFragment extends Fragment {
    private int postion;

   public static XinVeiwPagerFragment getXinFragmentInstance(int postion) {
       XinVeiwPagerFragment xvpf=new XinVeiwPagerFragment();
       xvpf.setPostion(postion);
        return  xvpf;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_xin, container, false);
        ImageView iv_xin = (ImageView) view.findViewById(R.id.iv_xin);


        switch (postion) {
            case 0:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.pxm).into(iv_xin);
                break;
            case 1:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.pusuyan).into(iv_xin);
                break;
            case 2:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.qbl).into(iv_xin);
                break;
            case 3:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.ljl).into(iv_xin);
                break;
            default:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.pxm).into(iv_xin);
                break;
        }
        return view;
    }
    public void setPostion(int postion){
        this.postion=postion;
    }
}