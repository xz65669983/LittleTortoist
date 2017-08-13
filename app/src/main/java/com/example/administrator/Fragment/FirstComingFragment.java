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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zzc on 2017/8/13.
 */

public class FirstComingFragment extends Fragment {
    @BindView(R.id.iv_first_coming)
    ImageView iv_first_coming;
    private int postion;
    private Unbinder unbinder;

    public static FirstComingFragment getFirstComingFragmentInstance(int postion) {
        FirstComingFragment fcf=new FirstComingFragment();
        fcf.setPostion(postion);
        return  fcf;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_firstcoming,container, false);
        ButterKnife.bind(this,view);
        switch (postion){
            case 0:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.firstcoming1).into(iv_first_coming);
                break;

            case 1:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.firstcoming2).into(iv_first_coming);
                break;
            case 2:
                Picasso.with(MyAppliciation.getcontext()).load(R.drawable.firstcoming3).into(iv_first_coming);
                break;

        }

        return view;

    }

    public void setPostion(int postion){
        this.postion=postion;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();

    }
}
