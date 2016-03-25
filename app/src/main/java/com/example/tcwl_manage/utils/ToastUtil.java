package com.example.tcwl_manage.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by MAOYH on 2016/3/25.
 */
public class ToastUtil {
    public static  void  toast(Context context,String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
