package com.example.hu.dazuoye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hu.dazuoye.db.dao.UserDao;

/**
 * Created by a1398 on 2018/1/5.
 */

public class Login extends Dialog {
    EditText login_account;
    EditText login_password;
    private long exit_time;//用于实现按两次back退出

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //获取按键并比较两次按back的时间大于2s不退出，否则退出
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exit_time > 2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                exit_time = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        login_account = (EditText) findViewById(R.id.login_account);
        login_password = (EditText) findViewById(R.id.login_password);

    }
//made by ken ,2018/1/8
    public void login(View view) {

        String account = login_account.getText().toString().trim();
        String password = login_password.getText().toString().trim();
        UserDao udao = new UserDao(this);
        if(TextUtils.isEmpty(account) || TextUtils.isEmpty(password)){
            /*
            * 自定义AlertDialog
            * */
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.show();
            Window window = alertDialog.getWindow();
            window.setContentView(R.layout.dialog_login);
            Toast.makeText(this,"请检查账号或者密码是否为空！", Toast.LENGTH_SHORT).show();
        }else{
            if(account.equals(udao.checkAccount(account)) && password.equals(udao.CheckPassword(password))){
                //向MainActivity传递数据
                Intent intent = new Intent();

//                String account_user = account;
//                String account_password = password;
                intent.putExtra("account",account);

                //跳转主界面,登录成功
                startActivity(intent.setClass(this,MainActivity.class));
//                startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(this,"登录成功！",Toast.LENGTH_SHORT).show();
            }else{
                //登录失败，账号或者密码错误
                Toast.makeText(this,"登录失败，账号或者密码错误！",Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void register(View v){

        startActivity(new Intent(this,Register.class));
    }


    public void forget(View v){
        String account = login_account.getText().toString().trim();
        UserDao udao = new UserDao(this);
        String password = udao.findPassword(account);
        Toast.makeText(this,"您的密码是" + password,Toast.LENGTH_SHORT).show();
    }
}
