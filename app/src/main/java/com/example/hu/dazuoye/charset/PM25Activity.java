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

public class PM25Activity extends TitleActivity{
    private LinearLayout mPM25CurveLayout;

    private GraphicalView mPM25View;

    private ChartService mPM25Service;

    private Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pm25);
        setTitle("PM25曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);
        mPM25CurveLayout = (LinearLayout) findViewById(R.id.chart_pm25);

        mPM25Service = new ChartService(this);
        mPM25Service.setXYMultipleSeriesDataset("PM25曲线");
        mPM25Service.setXYMultipleSeriesRenderer(100, 5000, "PM25曲线", "时间", "PM2.5",
                Color.RED, Color.RED, Color.RED, Color.BLACK);
        mPM25View = mPM25Service.getGraphicalView();

        mPM25CurveLayout.addView(mPM25View, new ViewGroup.LayoutParams(
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
            mPM25Service.updateChart(t, randomDatas(500,5000));
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
