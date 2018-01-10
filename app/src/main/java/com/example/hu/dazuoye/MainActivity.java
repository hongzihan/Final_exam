package com.example.hu.dazuoye;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hu.dazuoye.charset.CO2Activity;
import com.example.hu.dazuoye.charset.HumidityActivity;
import com.example.hu.dazuoye.charset.PM25Activity;
import com.example.hu.dazuoye.charset.RoadwayActivity;
import com.example.hu.dazuoye.charset.SunlightActivity;
import com.example.hu.dazuoye.charset.TemperatureActivity;
import com.example.hu.dazuoye.db.UserSqliteOpenHelper;
import com.example.hu.dazuoye.db.dao.UserDao;

import org.achartengine.GraphicalView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends TitleActivity {

    private long exit_time;//用于实现按两次back退出

    //六图表
//    private LinearLayout mTemperatureCurveLayout;
//    private LinearLayout mHumidityCurveLayout;
//    private LinearLayout mPM25CurveLayout;
//    private LinearLayout mCO2CurveLayout;
//    private LinearLayout mSunlightCurveLayout;
//    private LinearLayout mRoadwayCurveLayout;
//
//    private GraphicalView mTemperatureView, mCO2View, mHumidityView, mPM25View, mRoadwayView, mSunlightView;//


    //六个服务的定义
//    private ChartService mTemperatureService;
//    private ChartService mCO2Service;
//    private ChartService mHumidityService;
//    private ChartService mPM25Service;
//    private ChartService mSunlightService;
//    private ChartService mRoadwayService;

//    private Timer timer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * @ken
         * --2018/1/6
         * 2 lines were added
         */
        UserSqliteOpenHelper helper = new UserSqliteOpenHelper(this);//用于第一次数据库的创建
        SQLiteDatabase db = helper.getWritableDatabase();//调用此方法后才会完成创建数据库


        setTitle("交通管理系统");
        showBackwardView(R.string.text_back,false);
        setBottomImg("home");
    //初始化控件


        //设置用户信息
        Intent intent = getIntent();
        String account = intent.getStringExtra("account");
        UserDao udao = new UserDao(this);
        TextView main_username = (TextView)findViewById(R.id.main_username);
        main_username.setText(udao.findUsername(account));
        TextView main_account = (TextView)findViewById(R.id.main_account);
        main_account.setText(account);
        TextView main_balance = (TextView)findViewById(R.id.main_balance);
        String balance=Integer.toString(udao.findBalance(account));
        main_balance.setText(balance);





//        //六个图表--------
//        mTemperatureCurveLayout = (LinearLayout) findViewById(R.id.chart_temperature);
//        mCO2CurveLayout = (LinearLayout) findViewById(R.id.chart_co2);
//
//        mTemperatureService = new ChartService(this);
//        mTemperatureService.setXYMultipleSeriesDataset("温度曲线");
//        mTemperatureService.setXYMultipleSeriesRenderer(100, 100, "温度曲线", "时间", "温度",
//                Color.RED, Color.RED, Color.RED, Color.BLACK);
//        mTemperatureView = mTemperatureService.getGraphicalView();
//
//        mCO2Service = new ChartService(this);
//        mCO2Service.setXYMultipleSeriesDataset("CO2曲线");
//        mCO2Service.setXYMultipleSeriesRenderer(100, 100, "CO2曲线", "时间", "CO2",
//                Color.RED, Color.RED, Color.RED, Color.BLACK);
//        mCO2View = mCO2Service.getGraphicalView();
//
//        //将左右图表添加到布局容器中
//        mTemperatureCurveLayout.addView(mTemperatureView, new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        mCO2CurveLayout.addView(mCO2View, new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//
//        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.sendMessage(handler.obtainMessage());
//            }
//        }, 10, 5000);



    }




    //主界面返回键重置为回到桌面
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //获取按键并比较两次按back的时间大于2s不退出，否则退出
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exit_time > 2000) {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                exit_time = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }





//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    private int t = 0;
//    private Handler handler = new Handler() {
//        @Override
//        //定时更新图表
//        public void handleMessage(Message msg) {
//            mTemperatureService.updateChart(t, Math.random() * 100);
//            mCO2Service.updateChart(t, Math.random() * 100);
//            t+=5;
//        }
//    };
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (timer != null) {
//            timer.cancel();
//        }
//    }
}
