package com.example.tcwl_manage.controllers.fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.controllers.activity.MainActivity;
import com.example.tcwl_manage.controllers.activity.RegisterActivity;
import com.example.tcwl_manage.controllers.activity.ResetPWActivity;
import com.example.tcwl_manage.models.enties.Login;
import com.example.tcwl_manage.models.services.ApiLoginService;
import com.example.tcwl_manage.utils.RetrofitUtil;
import com.example.tcwl_manage.utils.ToastUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by MAOYH on 2016/3/15.
 * 登入
 */
public class LoginFragment extends Fragment {
    private static  int CODE_SUCCESS = 50000;
    private static  int CODE_USER_NOT_EXIST = 20207;
    private static  int CODE_USER_DISABLE = 20208;
    private static  int CODE_WRONG_PASSWORD = 60001;


    @Bind(R.id.edit_phoneNum)
    EditText mEditPhoneNum;
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
                Intent intent = new Intent(getMyActivity(), ResetPWActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_register:
                Intent intent2 = new Intent(getMyActivity(), RegisterActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_login:
             login();
        }
    }

    private void login() {
        String  phoneNum  = mEditPhoneNum.getText().toString();
        String password = mEditPassword.getText().toString();
        //参数检查
        if(TextUtils.isEmpty(phoneNum)) {
            ToastUtil.toast(getMyActivity(), this.getResources().getString(R.string.input_phone_num));
            return;
        }
        Pattern pattern = Pattern.compile("1\\d{10}");
        Matcher matcher = pattern.matcher(phoneNum);
        if (!matcher.matches()) {
            ToastUtil.toast(getMyActivity(), this.getResources().getString(R.string.error_phone_num));
            return;
        }
        if(TextUtils.isEmpty(password)) {
            ToastUtil.toast(getMyActivity(), this.getResources().getString(R.string.input_password));
            return;
        }
        //请求api
        RetrofitUtil mRetrofitUtil = new RetrofitUtil();
        ApiLoginService apiLoginService= mRetrofitUtil.create(ApiLoginService.class);
        Observable<Login> observable = apiLoginService.getLogin("null",1,password,Long.valueOf(phoneNum));
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Login>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.toast(getMyActivity(),getMyActivity().getResources().getString(R.string.network_error));

                    }

                    @Override
                    public void onNext(Login login) {
                       int code = login.getCode();
                        if(code == CODE_USER_NOT_EXIST) {
                            ToastUtil.toast(getMyActivity(),getMyActivity().getResources().getString(R.string.user_not_exist));
                            return;
                        }
                        if(code == CODE_USER_DISABLE) {
                            ToastUtil.toast(getMyActivity(),getMyActivity().getResources().getString(R.string.user_disable));
                            return;
                        }
                        if(code == CODE_WRONG_PASSWORD) {
                            ToastUtil.toast(getMyActivity(),getMyActivity().getResources().getString(R.string.wrong_password));
                            return;
                        }
                       // if(code == CODE_SUCCESS )
                        if(code == 16385 )
                        {
                            Intent intent = new Intent(getMyActivity(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            ToastUtil.toast(getMyActivity(),getMyActivity().getResources().getString(R.string.server_error));
                            return;
                        }
                    }
                });




    }
}
