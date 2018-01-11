package com.example.hu.dazuoye.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hu.dazuoye.R;
import com.example.hu.dazuoye.db.dao.UserDao;

/**
 * Created by a1398 on 2018/1/5.
 */

public class Register extends TitleActivity {
    EditText ed_user;
    EditText ed_username;
    EditText ed_password;
    EditText ed_repassword;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        setTitle("用户注册");
        showBackwardView(R.string.text_back,false);
        showEndView(false);


        ed_user = (EditText) findViewById(R.id.ed_user);
        ed_username = (EditText) findViewById(R.id.ed_username);
        ed_password = (EditText) findViewById(R.id.ed_password);
        ed_repassword = (EditText) findViewById(R.id.ed_repassword);

    }

    /**
     * made by ken
     * 用户的注册
     * 2018/1/8
     */
    public void btn_register(View view) {
        //点击注册
        String username = ed_username.getText().toString().trim();
        String account = ed_user.getText().toString().trim();
        String password = ed_password.getText().toString().trim();
        String repassword = ed_repassword.getText().toString().trim();
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(account) || TextUtils.isEmpty(password) || TextUtils.isEmpty(repassword)){
            Toast.makeText(this, "请检查是否有信息未填入", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.getTrimmedLength(account)!=11){
            Toast.makeText(this,"手机号只能为11位纯数字",Toast.LENGTH_SHORT).show();
        }else if(TextUtils.getTrimmedLength(password)<6 || TextUtils.getTrimmedLength(repassword)<6){
            Toast.makeText(this,"最小密码长度为6位！",Toast.LENGTH_SHORT).show();
        }else{
            if(password.equals(repassword) ) {

                //调用dao保存学生的信息
                UserDao udao = new UserDao(this);
                if(username.equals(udao.checkUsername(username))){
                    Toast.makeText(this,"用户名已存在",Toast.LENGTH_SHORT).show();
                }else if(account.equals(udao.checkAccount(account))) {
                    Toast.makeText(this, "该账号已存在", Toast.LENGTH_SHORT).show();
                }else{
                    udao.insert(username, account, password, 0);

                    Toast.makeText(this, "恭喜你！注册成功", Toast.LENGTH_SHORT).show();
                    //跳转登录界面
                    startActivity(new Intent(this,Login.class));
                }
            }else{
                Toast.makeText(this,"注册失败，两次密码输入不一致", Toast.LENGTH_SHORT).show();
            }
        }






    }
}
