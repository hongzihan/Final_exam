package com.example.hu.finalexam.domain;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by ken on 2018/1/12.
 */

public class CheckLogin {

    private static CheckLogin instance;

    private CheckLogin() {
    }

    public static CheckLogin getInstance() {
        if (instance == null) {
            instance = new CheckLogin();
        }
        return instance;
    }


    /**
     * 保存自动登录的用户信息
     */
    public void saveUserInfo(Context context, String username, String password) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        //Context.MODE_PRIVATE表示SharePrefences的数据只有自己应用程序能访问。
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("USER_NAME", username);
        editor.putString("PASSWORD", password);
        editor.commit();
    }


    /**
     * 获取用户信息model
     *
     * @param context
     * @param
     * @param
     */
    public User getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        User user = new User();
        user.setUsername(sp.getString("USER_NAME", ""));
        user.setPassword(sp.getString("PASSWORD", ""));
        return user;
    }


    /**
     * userInfo中是否有数据
     */
    public boolean hasUserInfo(Context context) {
        User user = getUserInfo(context);
        if (user != null) {
            if ((!TextUtils.isEmpty(user.getUsername())) && (!TextUtils.isEmpty(user.getPassword()))) {//有数据
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
