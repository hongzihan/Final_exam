package com.example.hu.dazuoye.charset;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import com.example.hu.dazuoye.ChartService;
import com.example.hu.dazuoye.R;
import com.example.hu.dazuoye.TitleActivity;

import org.achartengine.GraphicalView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by ken on 2018/1/10.
 */

public class TemperatureActivity extends TitleActivity {

    private LinearLayout mTemperatureCurveLayout;

    private GraphicalView mTemperatureView;

    private ChartService mTemperatureService;

    private Timer timer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temperature);
        setTitle("Temperature曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);




        mTemperatureCurveLayout = (LinearLayout) findViewById(R.id.chart_temperature);

        mTemperatureService = new ChartService(this);
        mTemperatureService.setXYMultipleSeriesDataset("温度曲线");
        mTemperatureService.setXYMultipleSeriesRenderer(100, 40, "温度曲线", "时间", "温度",
                Color.RED, Color.RED, Color.RED, Color.BLACK);
        mTemperatureView = mTemperatureService.getGraphicalView();

        mTemperatureCurveLayout.addView(mTemperatureView, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendMessage(handler.obtainMessage());
            }
        }, 10, 3000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private int t = 0;
    private Handler handler = new Handler() {
        @Override
        //定时更新图表
        public void handleMessage(Message msg) {
            mTemperatureService.updateChart(t, randomDatas(10,40));
            t+=5;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    //随机函数
    public Integer randomDatas(Integer minnum, Integer maxnum){
        return (int)(minnum+Math.random()*(maxnum-minnum+1));
    }
}
