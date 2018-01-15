package com.example.hu.finalexam;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hu.finalexam.domain.SpeedLimit;
import com.example.hu.finalexam.ui.TitleActivity;

/**
 * Created by a1398 on 2018/1/11.
 */

public class SpeedMinMax extends TitleActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minmax);

        setTitle("设置阈值");
        showBackwardView(R.string.text_back,true);
        showEndView(false);

//        editText_Min = (EditText) findViewById(R.id.dialog_Ed_Min);
//        editText_Max = (EditText) findViewById(R.id.dialog_Ed_Max);
//        button = (Button) findViewById(R.id.dialog_btn_agree);

        //((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE)).showSoftInput(editText_Min, 0);
    }

    public void Set_car1(View view){
        EditText min = (EditText) findViewById(R.id.car1_set_min);
        EditText max = (EditText) findViewById(R.id.car1_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(min_data)>Integer.parseInt(max_data)){
            Toast.makeText(this,"最小值必须比最大值小",Toast.LENGTH_SHORT).show();
        }else{
            SpeedLimit.setMinSpeedLimitCarOne(min_data);
            SpeedLimit.setMaxSpeedLimitCarOne(max_data);
            startActivity(new Intent(SpeedMinMax.this,MainActivity.class));
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void Set_car2(View view){
        EditText min = (EditText) findViewById(R.id.car2_set_min);
        EditText max = (EditText) findViewById(R.id.car2_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(min_data)>Integer.parseInt(max_data)){
            Toast.makeText(this,"最小值必须比最大值小",Toast.LENGTH_SHORT).show();
        }else{
            SpeedLimit.setMinSpeedLimitCarTwo(min_data);
            SpeedLimit.setMaxSpeedLimitCarTwo(max_data);
            startActivity(new Intent(SpeedMinMax.this,MainActivity.class));
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void Set_car3(View view){
        EditText min = (EditText) findViewById(R.id.car3_set_min);
        EditText max = (EditText) findViewById(R.id.car3_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(min_data)>Integer.parseInt(max_data)){
            Toast.makeText(this,"最小值必须比最大值小",Toast.LENGTH_SHORT).show();
        }else{
            SpeedLimit.setMinSpeedLimitCarThree(min_data);
            SpeedLimit.setMaxSpeedLimitCarThree(max_data);
            startActivity(new Intent(SpeedMinMax.this,MainActivity.class));
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }

    public void Set_car4(View view){
        EditText min = (EditText) findViewById(R.id.car4_set_min);
        EditText max = (EditText) findViewById(R.id.car4_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(min_data)>Integer.parseInt(max_data)){
            Toast.makeText(this,"最小值必须比最大值小",Toast.LENGTH_SHORT).show();
        }else{
            SpeedLimit.setMinSpeedLimitCarFour(min_data);
            SpeedLimit.setMaxSpeedLimitCarFour(max_data);
            startActivity(new Intent(SpeedMinMax.this,MainActivity.class));
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }

}