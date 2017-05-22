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
        Bitmap bitmap = null;
        switch (postion) {
            case 0:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pxm);
                break;
            case 1:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pusuyan);
                break;
            case 2:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.qbl);
                break;
            case 3:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ljl);
                break;
            default:
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pxm);
                break;
        }
        iv_xin.setImageBitmap(bitmap);
        return view;
    }
    public void setPostion(int postion){
        this.postion=postion;
    }
}
