package com.example.hu.dazuoye.charset;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hu.dazuoye.service.ChartService;
import com.example.hu.dazuoye.R;
import com.example.hu.dazuoye.ui.TitleActivity;

import org.achartengine.GraphicalView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ken on 2018/1/10.
 */

public class HumidityActivity extends TitleActivity{

    private LinearLayout mHumidityCurveLayout;

    private GraphicalView mHumidityView;

    private ChartService mHumidityService;

    private Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humidity);
        setTitle("Humidity曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);
        mHumidityCurveLayout = (LinearLayout) findViewById(R.id.chart_humidity);

        mHumidityService = new ChartService(this);
        mHumidityService.setXYMultipleSeriesDataset("Humidity曲线");
        mHumidityService.setXYMultipleSeriesRenderer(100, 150, "Humidity曲线", "时间", "湿度",
                Color.RED, Color.RED, Color.RED, Color.BLACK);
        mHumidityView = mHumidityService.getGraphicalView();

        mHumidityCurveLayout.addView(mHumidityView, new ViewGroup.LayoutParams(
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
            mHumidityService.updateChart(t, randomDatas(50,150));
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
