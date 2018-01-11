package com.example.hu.dazuoye;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.hu.dazuoye.charset.CO2Activity;
import com.example.hu.dazuoye.charset.HumidityActivity;
import com.example.hu.dazuoye.charset.PM25Activity;
import com.example.hu.dazuoye.charset.RoadwayActivity;
import com.example.hu.dazuoye.charset.SunlightActivity;
import com.example.hu.dazuoye.charset.TemperatureActivity;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by a1398 on 2018/1/9.
 */

public class EnvironmentIndex extends TitleActivity {
    private Integer CO2data;
    private Integer Temperaturedata;
    private Integer PM25data;
    private Integer Humiditydata;
    private Integer Sunlightdata;
    private Integer Roadwaydata;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.environment_index);
        setTitle("环境指标");
        showBackwardView(R.string.text_back,true);
        showEndView(true);

        //启动定时器
        cdt.start();


        //指标调用随机函数显示
        //made by ken 2018/1/9



    }
    //随机函数
    public Integer randomDatas(Integer minnum, Integer maxnum){
        return (int)(minnum+Math.random()*(maxnum-minnum+1));
    }

    //六个按钮跳转环境指标图表
    public void gototemperature(View view){
        startActivity(new Intent(this,TemperatureActivity.class));
    }
    public void gotohumidity(View view){
        startActivity(new Intent(this, HumidityActivity.class));
    }
    public void gotoco2(View view){
        startActivity(new Intent(this,CO2Activity.class));
    }
    public void gotopm25(View view){
        startActivity(new Intent(this,PM25Activity.class));
    }
    public void gotosunlight(View view){
        startActivity(new Intent(this,SunlightActivity.class));
    }
    public void gotoroadway(View view){
        startActivity(new Intent(this,RoadwayActivity.class));
    }


    //CountDownTimer计时器 通过onCreate()的cdt.start()启动
    CountDownTimer cdt = new CountDownTimer(300000, 3000) {
        @Override
        public void onTick(long millisUntilFinished) {
            TextView temperature = (TextView)findViewById(R.id.temperature);
            temperature.setText("温度:"+randomDatas(10,40));
            TextView humidity = (TextView)findViewById(R.id.humidity);
            humidity.setText("湿度:"+randomDatas(50,150));
            TextView PM25 = (TextView)findViewById(R.id.PM25);
            PM25.setText("PM2.5:"+randomDatas(500,5000));
            TextView CO2 = (TextView)findViewById(R.id.CO2);
            CO2.setText("CO2:"+randomDatas(100,600));
            TextView sunlight = (TextView)findViewById(R.id.sunlight);
            sunlight.setText("光照:"+randomDatas(0,100));
            TextView roadway = (TextView)findViewById(R.id.roadway);
            roadway.setText("道路状态:"+randomDatas(1,5));
        }
        @Override
        public void onFinish() {

        }
    };




}
