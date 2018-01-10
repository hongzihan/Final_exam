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

public class SunlightActivity extends TitleActivity {
    private LinearLayout mSunlightCurveLayout;

    private GraphicalView mSunlightView;

    private ChartService mSunlightService;

    private Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sunlight);
        setTitle("Sunlight曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);
        mSunlightCurveLayout = (LinearLayout) findViewById(R.id.chart_sunlight);

        mSunlightService = new ChartService(this);
        mSunlightService.setXYMultipleSeriesDataset("Sunlight曲线");
        mSunlightService.setXYMultipleSeriesRenderer(100, 100, "Sunlight曲线", "时间", "光照",
                Color.RED, Color.RED, Color.RED, Color.BLACK);
        mSunlightView = mSunlightService.getGraphicalView();

        mSunlightCurveLayout.addView(mSunlightView, new ViewGroup.LayoutParams(
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
            mSunlightService.updateChart(t, Math.random() * 100);
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



}
