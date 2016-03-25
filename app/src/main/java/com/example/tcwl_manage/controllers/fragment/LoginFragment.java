package com.example.tcwl_manage.controllers.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tcwl_manage.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MAOYH on 2016/3/15.
 * 登入
 */
public class LoginFragment extends Fragment {
    @Bind(R.id.imagev_phone)
    ImageView mImagevPhone;
    @Bind(R.id.edit_phoneNum)
    EditText mEditPhoneNum;
    @Bind(R.id.imagev_password)
    ImageView mImagevPassword;
    @Bind(R.id.edit_password)
    EditText mEditPassword;
    @Bind(R.id.tv_forget_psw)
    TextView mTvForgetPsw;
    @Bind(R.id.tv_register)
    TextView mTvRegister;
    @Bind(R.id.btn_login)
    Button mBtnLogin;

    /**
     * 需要传递参数时有利于解耦
     */
    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, null);
        ButterKnife.bind(this, v);
        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({ R.id.tv_forget_psw, R.id.tv_register, R.id.btn_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_psw:
                break;
            case R.id.tv_register:
                break;
            case R.id.btn_login:
                break;
        }
    }
}
