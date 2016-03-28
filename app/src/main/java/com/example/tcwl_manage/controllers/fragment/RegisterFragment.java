package com.example.tcwl_manage.controllers.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tcwl_manage.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MAOYH on 2016/3/15.
 * 注册
 */
public class RegisterFragment extends Fragment {


    @Bind(R.id.iv_back)
    ImageView mIvBack;
    @Bind(R.id.iv_icon)
    ImageView mIvIcon;
    @Bind(R.id.edit_phone)
    EditText mEditPhone;
    @Bind(R.id.edit_verify_code)
    EditText mEditVerifyCode;
    @Bind(R.id.btn_get_verify_code)
    Button mBtnGetVerifyCode;
    @Bind(R.id.edit_password)
    EditText mEditPassword;
    @Bind(R.id.edit_psw_again)
    EditText mEditPswAgain;
    @Bind(R.id.btn_register)
    Button mBtnRegister;

    /**
     * 需要传递参数时有利于解耦
     */
    public static RegisterFragment newInstance() {
        Bundle args = new Bundle();
        RegisterFragment fragment = new RegisterFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Activity getMyActivity() {
        Activity act = getActivity();
        if (act == null) {
            act = this.getActivity();
        }
        return act;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, null);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.iv_back, R.id.iv_icon, R.id.btn_get_verify_code, R.id.btn_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                break;
            case R.id.iv_icon:
                break;
            case R.id.btn_get_verify_code:
                break;
            case R.id.btn_register:
                break;
        }
    }
}
