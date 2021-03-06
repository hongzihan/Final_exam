package com.example.hu.finalexam.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hu.finalexam.Dialog;
import com.example.hu.finalexam.MainActivity;
import com.example.hu.finalexam.R;
import com.example.hu.finalexam.db.dao.UserDao;
import com.example.hu.finalexam.domain.AutoLogin;
import com.example.hu.finalexam.domain.CheckLogin;
import com.example.hu.finalexam.domain.User;

/**
 * Created by a1398 on 2018/1/5.
 */

public class Login extends Dialog {
    private EditText login_account;
    private EditText login_password;
    private long exit_time;//用于实现按两次back退出
    private CheckBox whether_login;
    private int checkLoginFlag=-1;

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
        whether_login = (CheckBox) findViewById(R.id.whether_login);

        UserDao udao = new UserDao(this);
        //默认用户
        if(AutoLogin.getInstance().hasAutoLoginInfo(Login.this)){

        }else{
            udao.insert("admin","12345678901","123456",100);
            udao.insert("carOne","1","123456",100);
            udao.insert("carTwo","2","123456",100);
            udao.insert("carThree","3","123456",100);
            udao.insert("carFour","4","123456",100);
            Toast.makeText(this,"默认管理员admin,手机号12345678901密码123456",Toast.LENGTH_LONG).show();
            AutoLogin.getInstance().saveAutoLoginInfo(Login.this, 0);
        }



    }
//made by ken ,2018/1/8
    public void login(View view) {

        String account = login_account.getText().toString().trim();
        String password = login_password.getText().toString().trim();
        UserDao udao = new UserDao(this);
        String username = udao.findUsername(account);
        Integer balance = udao.findBalance(account);
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
            if(account.equals(udao.checkAccount(account)) && password.equals(udao.checkPassword(password))){
                //向MainActivity传递数据
                //Intent intent = new Intent();
//                String account_user = account;
//                String account_password = password;
                //intent.putExtra("account",account);

                //设置全局用户变量
                User.setAccount(account);
                User.setPassword(password);
                User.setUsername(username);
                User.setBalance(balance);


                //如果选中自动登录，则将用户的账号密码存入CheckLogin
                if(checkLoginFlag==0){
                    CheckLogin.getInstance().saveUserInfo(Login.this, username, password, udao.findAccount(username,password));
                }else;
                //跳转主界面,登录成功
                //startActivity(intent.setClass(this,MainActivity.class));
                startActivity(new Intent(this,MainActivity.class));
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

        if(TextUtils.isEmpty(account)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_SHORT).show();
        }else if(udao.reCheckAccount(account)){
            Toast.makeText(this,"该账号未注册，请检查账号是否输入正确",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"您的密码是" + password,Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * @param v
     * made by ken
     * 2018/1/13
     * 自动登录checkBox调用的点击方法
     */
    public void autologin(View v){
        if (whether_login.isChecked()){
            checkLoginFlag=0;
        }else{
            checkLoginFlag=-1;
        }
    }
}
