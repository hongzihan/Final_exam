package com.example.hu.finalexam.charset;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hu.finalexam.service.ChartService;
import com.example.hu.finalexam.R;
import com.example.hu.finalexam.ui.TitleActivity;

import org.achartengine.GraphicalView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by ken on 2018/1/10.
 */

public class CO2Activity extends TitleActivity {

    private LinearLayout mCO2CurveLayout;

    private GraphicalView mCO2View;

    private ChartService mCO2Service;

    private Timer timer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.co2);
        setTitle("CO2曲线图");
        showBackwardView(R.string.text_back,true);
        showEndView(true);





        mCO2CurveLayout = (LinearLayout) findViewById(R.id.chart_co2);

        mCO2Service = new ChartService(this);
        mCO2Service.setXYMultipleSeriesDataset("CO2曲线");
        mCO2Service.setXYMultipleSeriesRenderer(100, 600, "CO2曲线", "时间", "CO2",
                Color.RED, Color.RED, Color.RED, Color.BLACK);
        mCO2View = mCO2Service.getGraphicalView();

        mCO2CurveLayout.addView(mCO2View, new ViewGroup.LayoutParams(
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
            mCO2Service.updateChart(t, randomDatas(100,600));
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
