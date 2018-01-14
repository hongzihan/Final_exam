package com.example.hu.finalexam.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hu.finalexam.R;
import com.example.hu.finalexam.charset.CO2Activity;
import com.example.hu.finalexam.charset.HumidityActivity;
import com.example.hu.finalexam.charset.PM25Activity;
import com.example.hu.finalexam.charset.RoadwayActivity;
import com.example.hu.finalexam.charset.SunlightActivity;
import com.example.hu.finalexam.charset.TemperatureActivity;
import com.example.hu.finalexam.domain.IndexLimit;


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
        setBottomImg("left");
        showBackwardView(R.string.text_back,true);
        showEndView(true);

        //启动定时器
        cdt.start();


        //指标调用随机函数显示
        //made by ken 2018/1/9



    }
    //随机函数
    public Integer randomDatas(int minnum, int maxnum){
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
    //跳转环境阈值设置页面
    public void gotoyuzhi(View view){ startActivity(new Intent(this,EnvironmentMinMax.class));}

    //CountDownTimer计时器 通过onCreate()的cdt.start()启动
    CountDownTimer cdt = new CountDownTimer(300000, 3000) {
        @Override
        public void onTick(long millisUntilFinished) {
            int co2,tem,hum,pm,sun,road;
            int co2Data,temData,humData,pmData,sunData,roadData;
            //设置随机数最大值为标准阈值的1.2倍并取整
            tem = (int) Math.ceil(IndexLimit.getMaxTemLimit()*1.2);
            hum = (int) Math.ceil(IndexLimit.getMaxHumLimit()*1.2);
            pm = (int) Math.ceil(IndexLimit.getMaxPmLimit()*1.2);
            co2 = (int) Math.ceil(IndexLimit.getMaxCoLimit()*1.2);
            sun = (int) Math.ceil(IndexLimit.getMaxSunLimit()*1.2);
            road = (int) Math.ceil(IndexLimit.getMaxRoadLimit()*1.2);
            //通过随机函数获得数据
            temData = randomDatas(IndexLimit.getMinTemLimit(),tem);
            humData = randomDatas(IndexLimit.getMinHumLimit(),hum);
            pmData = randomDatas(IndexLimit.getMinPmLimit(),pm);
            co2Data = randomDatas(IndexLimit.getMinCoLimit(),co2);
            sunData = randomDatas(IndexLimit.getMinSunLimit(),sun);
            roadData = randomDatas(IndexLimit.getMinRoadLimit(),road);

            //定义控件
            Button temperature = (Button)findViewById(R.id.temperature);
            Button humidity = (Button)findViewById(R.id.humidity);
            Button PM25 = (Button)findViewById(R.id.PM25);
            Button CO2 = (Button)findViewById(R.id.CO2);
            Button sunlight = (Button)findViewById(R.id.sunlight);
            Button roadway = (Button)findViewById(R.id.roadway);


            temperature.setText("温度:"+temData);
            humidity.setText("湿度:"+humData);
            PM25.setText("PM2.5:"+pmData);
            CO2.setText("CO2:"+co2Data);
            sunlight.setText("光照:"+sunData);
            roadway.setText("道路状态:"+roadData);



            //通过数据与最大阈值的对比来判断环境指标是否超标若超标则字体变红，若正常则为绿色
            if(temData>IndexLimit.getMaxTemLimit()){
                temperature.setTextColor(Color.parseColor("#FF0000"));
            }else{
                temperature.setTextColor(Color.parseColor("#7CFC00"));
            }
            if(humData>IndexLimit.getMaxHumLimit()){
                humidity.setTextColor(Color.parseColor("#FF0000"));
            }else{
                humidity.setTextColor(Color.parseColor("#7CFC00"));
            }
            if(pmData>IndexLimit.getMaxPmLimit()){
                PM25.setTextColor(Color.parseColor("#FF0000"));
            }else{
                PM25.setTextColor(Color.parseColor("#7CFC00"));
            }
            if(co2Data>IndexLimit.getMaxCoLimit()){
                CO2.setTextColor(Color.parseColor("#FF0000"));
            }else{
                CO2.setTextColor(Color.parseColor("#7CFC00"));
            }
            if(sunData>IndexLimit.getMaxSunLimit()){
                sunlight.setTextColor(Color.parseColor("#FF0000"));
            }else{
                sunlight.setTextColor(Color.parseColor("#7CFC00"));
            }
            if(roadData>IndexLimit.getMaxRoadLimit()){
                roadway.setTextColor(Color.parseColor("#FF0000"));
            }else{
                roadway.setTextColor(Color.parseColor("#7CFC00"));
            }


//            //若数据中一项超标背景色变为红色，若全未超标则为绿色
//            TableLayout env_layout = (TableLayout)findViewById(R.id.environment_layout);
//
//            if(temData>40 || humData>150 || pmData>5000 || co2Data>600 || sunData>100 || roadData>5){
//                //设置Table背景色为红色代表警告
//                env_layout.setBackgroundColor(Color.parseColor("#FF0000"));
//            }else{
//                env_layout.setBackgroundColor(Color.parseColor("#7CFC00"));
//            }
        }
        @Override
        public void onFinish() {

        }
    };




}
