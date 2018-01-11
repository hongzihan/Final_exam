package com.example.hu.dazuoye;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.hu.dazuoye.ui.Login;
import com.example.hu.dazuoye.ui.Register;

/**
 * Created by a1398 on 2018/1/9.
 */

public class Dialog extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_login);

    }
    public void dialog (View v){
        switch (v.getId()){
            case R.id.dialog_btn_back:
                //Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.dialog_btn_register:
                startActivity(new Intent(this, Register.class));
            default:
                break;
        }
    }
}