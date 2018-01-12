package com.example.hu.finalexam;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hu.finalexam.domain.User;
import com.example.hu.finalexam.ui.TitleActivity;

/**
 * Created by a1398 on 2018/1/11.
 */

public class MinMax extends TitleActivity {
    EditText editText_Min;
    EditText editText_Max;
    Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minmax);

        setTitle("设置阈值");
        showBackwardView(R.string.text_back,false);
        showEndView(false);

        editText_Min = (EditText) findViewById(R.id.dialog_Ed_Min);
        editText_Max = (EditText) findViewById(R.id.dialog_Ed_Max);
        button = (Button) findViewById(R.id.dialog_btn_agree);

        //((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(editText_Min, 0);
    }

    public void dialog (View v){
        switch (v.getId()){
            case R.id.dialog_btn_agree:
                //Toast.makeText(this,"111",Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(this, Login.class));
                String min = editText_Min.getText().toString().trim();
                User.setMinSpeed(min);
                String max = editText_Max.getText().toString().trim();
                User.setMaxSpeed(max);
                User.setSpeedLimitFlag(0);
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.dialog_btn_null:
                //startActivity(new Intent(this, Register.class));
                startActivity(new Intent(this,MainActivity.class));
            default:
                break;
        }
    }
}