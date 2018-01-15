package com.example.hu.finalexam.domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by ken on 2018/1/15.
 */

public class AutoLogin {
    private static AutoLogin instance;

    private AutoLogin() {
    }

    public static AutoLogin getInstance() {
        if (instance == null) {
            instance = new AutoLogin();
        }
        return instance;
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveAutoLoginInfo(Context context, int autoflag) {
        SharedPreferences sp = context.getSharedPreferences("AutoLoginInfo", Context.MODE_PRIVATE);
        //Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("AUTOFLAG", autoflag);
        editor.commit();
    }


    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public User getAutoLoginInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("AutoLoginInfo", Context.MODE_PRIVATE);
        User user = new User();
        user.setAutoLogin(sp.getInt("AUTOFLAG", -1));

        return user;
    }


    /**
     * userInfo中是否有数据
     */
    public boolean hasAutoLoginInfo(Context context) {
        User user = getAutoLoginInfo(context);
        if (user != null) {
            if (User.getAutoLogin()==0) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
