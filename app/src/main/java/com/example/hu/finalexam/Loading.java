package com.example.hu.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hu.finalexam.domain.CheckLogin;
import com.example.hu.finalexam.domain.User;
import com.example.hu.finalexam.ui.Login;

/**
 * 跳转时间倒计时页面
 * Created by a1398 on 2018/1/5.
 */

public class Loading extends AppCompatActivity {
    TextView textView;
    Button button;
    int time = 3;

    private int checkLoginFlag;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        textView = (TextView) findViewById(R.id.tv);
        button = (Button) findViewById(R.id.btn);

        handler.postDelayed(runnable,1000);

        if(!CheckLogin.getInstance().hasUserInfo(this)){
            checkLoginFlag=-1;
        }else{
            checkLoginFlag=0;
        }
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            handler.postDelayed(this, 1000);
            textView.setText("跳转：" + time + "秒");

            if (time == 0) {
                if(checkLoginFlag == -1) {
                    Intent intent = new Intent(Loading.this, Login.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(Loading.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            } else {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(checkLoginFlag == -1) {
                            Intent intent = new Intent(Loading.this, Login.class);
                            startActivity(intent);
                        }else{
                            Intent intent = new Intent(Loading.this, MainActivity.class);
                            startActivity(intent);
                        }

                        //结束进程
                        handler.removeCallbacks(runnable);
                        finish();
                    }
                });
            }
        }
    };
}
