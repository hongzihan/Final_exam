package com.example.hu.finalexam.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.hu.finalexam.R;
import com.example.hu.finalexam.domain.IndexLimit;


/**
 * Created by a1398 on 2018/1/13.
 */

public class EnvironmentMinMax extends TitleActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.environment_minmax);
        setTitle("CO2曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);

    }

    public void Set_tem(View view){
        EditText min = (EditText) findViewById(R.id.tem_set_min);
        EditText max = (EditText) findViewById(R.id.tem_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else{
            IndexLimit.setMinTemLimit(min_data);
            IndexLimit.setMaxTemLimit(max_data);
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
    public void Set_hum(View view){
        EditText min = (EditText) findViewById(R.id.hum_set_min);
        EditText max = (EditText) findViewById(R.id.hum_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else{
            IndexLimit.setMinHumLimit(min_data);
            IndexLimit.setMaxHumLimit(max_data);
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
    public void Set_co2(View view){
        EditText min = (EditText) findViewById(R.id.co2_set_min);
        EditText max = (EditText) findViewById(R.id.co2_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else{
            IndexLimit.setMinCoLimit(min_data);
            IndexLimit.setMaxCoLimit(max_data);
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
    public void Set_pm25(View view){
        EditText min = (EditText) findViewById(R.id.pm_set_min);
        EditText max = (EditText) findViewById(R.id.pm_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else{
            IndexLimit.setMinPmLimit(min_data);
            IndexLimit.setMaxPmLimit(max_data);
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
    public void Set_sun(View view){
        EditText min = (EditText) findViewById(R.id.sun_set_min);
        EditText max = (EditText) findViewById(R.id.sun_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else{
            IndexLimit.setMinSunLimit(min_data);
            IndexLimit.setMaxSunLimit(max_data);
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
    public void Set_road(View view){
        EditText min = (EditText) findViewById(R.id.road_set_min);
        EditText max = (EditText) findViewById(R.id.road_set_max);
        String min_data = min.getText().toString().trim();
        String max_data = max.getText().toString().trim();
        if(TextUtils.isEmpty(min_data)||TextUtils.isEmpty(max_data)){
            Toast.makeText(this,"请先输入数值",Toast.LENGTH_SHORT).show();
        }else{
            IndexLimit.setMinRoadLimit(min_data);
            IndexLimit.setMaxRoadLimit(max_data);
            Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
        }
    }
}