package com.example.administrator.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.Constant.Fragmentid;
import com.example.administrator.littletortoisetortoise.HomepageActivity;
import com.example.administrator.littletortoisetortoise.LoginActivity;
import com.example.administrator.littletortoisetortoise.R;
import com.example.administrator.littletortoisetortoise.UserDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by zzc on 2017/6/18.
 */

public class PersonalCenterFrangment extends Fragment {

    private FragmentActivity mactivity;
    @BindView(R.id.nickname_txtv)
    public TextView tv_nickname;

    @OnClick(R.id.account_rlayout)
    public void accountManger(){
        Intent intent =new Intent(mactivity, UserDetailsActivity.class);
        startActivity(intent);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mactivity = getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_personal_informantion,container,false);
        ButterKnife.bind(this, view);
        tv_nickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomepageActivity mactivity = (HomepageActivity) PersonalCenterFrangment.this.mactivity;
                if (mactivity.islogin){
                    return;
                }else{
                    Intent intent=new Intent(mactivity, LoginActivity.class);
                    startActivityForResult(intent, Fragmentid.PersonalCenterFragment);
                }

            }
        });
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
