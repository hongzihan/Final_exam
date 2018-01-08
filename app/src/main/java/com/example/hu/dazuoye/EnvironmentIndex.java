package com.example.hu.dazuoye;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;


/**
 * Created by a1398 on 2018/1/9.
 */

public class EnvironmentIndex extends TitleActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.environment_index);
        setTitle("环境指标");
        showBackwardView(R.string.text_back,true);
        showEndView(true);



        //指标调用随机函数显示
        //made by ken 2018/1/9
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
    //随机函数
    public Integer randomDatas(Integer minnum, Integer maxnum){
        return (int)(minnum+Math.random()*(maxnum-minnum+1));
    }
//    public Integer randomTemperature(){
//        Integer minnum = 10;
//        Integer maxnum = 40;
//        return (int)(minnum+Math.random()*(maxnum-minnum+1));
//    }
//
//    public Integer randomHumidity(){
//        Integer minnum = 50;
//        Integer maxnum = 150;
//        return (int)(minnum+Math.random()*(maxnum-minnum+1));
//    }
//
//    public Integer randomPM25(){
//        Integer minnum = 500;
//        Integer maxnum = 5000;
//        return (int)(minnum+Math.random()*(maxnum-minnum+1));
//    }
//
//    public Integer randomCO2(){
//        Integer minnum = 100;
//        Integer maxnum = 600;
//        return (int)(minnum+Math.random()*(maxnum-minnum+1));
//    }
//
//    public Integer randomSunLight(){
//        Integer minnum = 0;
//        Integer maxnum = 100;
//        return (int)(minnum+Math.random()*(maxnum-minnum+1));
//    }
//
//    public Integer randomRoadway(){
//        Integer minnum = 1;
//        Integer maxnum = 5;
//        return (int)(minnum+Math.random()*(maxnum-minnum+1));
//    }
}
