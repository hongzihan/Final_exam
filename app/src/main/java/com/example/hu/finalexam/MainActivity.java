package com.example.hu.finalexam;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hu.finalexam.db.UserSqliteOpenHelper;
import com.example.hu.finalexam.db.dao.UserDao;
import com.example.hu.finalexam.domain.IndexLimit;
import com.example.hu.finalexam.domain.SpeedLimit;
import com.example.hu.finalexam.domain.User;
import com.example.hu.finalexam.ui.Login;
import com.example.hu.finalexam.ui.TitleActivity;

public class MainActivity extends TitleActivity {

    private long exit_time;//用于实现按两次back退出



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

        UserDao udao = new UserDao(this);
        //启动定时器
        cdt.start();
        //设置用户数据
        TextView main_username = (TextView)findViewById(R.id.main_username);
        main_username.setText(User.getUsername());
        TextView main_account = (TextView)findViewById(R.id.main_account);
        main_account.setText(User.getAccount());



        //ETC余额
        TextView main_balance1 = (TextView)findViewById(R.id.balanceOne);
        main_balance1.setText(udao.findBalance("1") + "");
        TextView main_balance2 = (TextView)findViewById(R.id.balanceTwo);
        main_balance2.setText(udao.findBalance("2") + "");
        TextView main_balance3 = (TextView)findViewById(R.id.balanceThree);
        main_balance3.setText(udao.findBalance("3") + "");
        TextView main_balance4 = (TextView)findViewById(R.id.balanceFour);
        main_balance4.setText(udao.findBalance("4") + "");

        //最大速度
        TextView maxSpeedOne = (TextView)findViewById(R.id.maxSpeedOne);
        maxSpeedOne.setText(SpeedLimit.getMaxSpeedLimitCarOne() + "");
        TextView maxSpeedTwo = (TextView)findViewById(R.id.maxSpeedTwo);
        maxSpeedTwo.setText(SpeedLimit.getMaxSpeedLimitCarTwo() + "");
        TextView maxSpeedThree = (TextView)findViewById(R.id.maxSpeedThree);
        maxSpeedThree.setText(SpeedLimit.getMaxSpeedLimitCarThree() + "");
        TextView maxSpeedFour = (TextView)findViewById(R.id.maxSpeedFour);
        maxSpeedFour.setText(SpeedLimit.getMaxSpeedLimitCarFour() + "");
        //最小速度
        TextView minSpeedOne = (TextView)findViewById(R.id.minSpeedOne);
        minSpeedOne.setText(SpeedLimit.getMinSpeedLimitCarOne() + "");
        TextView minSpeedTwo = (TextView)findViewById(R.id.minSpeedTwo);
        minSpeedTwo.setText(SpeedLimit.getMinSpeedLimitCarTwo() + "");
        TextView minSpeedThree = (TextView)findViewById(R.id.minSpeedThree);
        minSpeedThree.setText(SpeedLimit.getMinSpeedLimitCarThree() + "");
        TextView minSpeedFour = (TextView)findViewById(R.id.minSpeedFour);
        minSpeedFour.setText(SpeedLimit.getMinSpeedLimitCarFour() + "");




    }

    //随机函数
    public Integer randomDatas(Integer minnum, Integer maxnum){
        return (int)(minnum+Math.random()*(maxnum-minnum+1));
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

    public void setSpeedLimit(View view){
        startActivity(new Intent(this,SpeedMinMax.class));
    }


    public void changeUser(View view){
        startActivity(new Intent(this,Login.class));
    }

    //CountDownTimer计时器 通过onCreate()的cdt.start()启动
    CountDownTimer cdt = new CountDownTimer(100000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            int car1,car2,car3,car4;
            int Car1,Car2,Car3,Car4;

            TextView over1 = (TextView)findViewById(R.id.overSpeedOne);
            TextView over2 = (TextView)findViewById(R.id.overSpeedTwo);
            TextView over3 = (TextView)findViewById(R.id.overSpeedThree);
            TextView over4 = (TextView)findViewById(R.id.overSpeedFour);
            car1 = (int) Math.ceil(SpeedLimit.getMaxSpeedLimitCarOne()*1.2);
            car2 = (int) Math.ceil(SpeedLimit.getMaxSpeedLimitCarOne()*1.2);
            car3 = (int) Math.ceil(SpeedLimit.getMaxSpeedLimitCarOne()*1.2);
            car4 = (int) Math.ceil(SpeedLimit.getMaxSpeedLimitCarOne()*1.2);

            Car1 = (int) Math.ceil(SpeedLimit.getMinSpeedLimitCarOne()*0.8);
            Car2 = (int) Math.ceil(SpeedLimit.getMinSpeedLimitCarOne()*0.8);
            Car3 = (int) Math.ceil(SpeedLimit.getMinSpeedLimitCarOne()*0.8);
            Car4 = (int) Math.ceil(SpeedLimit.getMinSpeedLimitCarOne()*0.8);

            int speedcar1 = randomDatas(Car1,car1);
            int speedcar2 = randomDatas(Car2,car2);
            int speedcar3 = randomDatas(Car3,car3);
            int speedcar4 = randomDatas(Car4,car4);

            TextView main_carSpeed1 = (TextView)findViewById(R.id.speedOne);
            main_carSpeed1.setText( speedcar1 + "");
            TextView main_carSpeed2 = (TextView)findViewById(R.id.speedTwo);
            main_carSpeed2.setText( speedcar2 + "");
            TextView main_carSpeed3 = (TextView)findViewById(R.id.speedThree);
            main_carSpeed3.setText( speedcar3 + "");
            TextView main_carSpeed4 = (TextView)findViewById(R.id.speedFour);
            main_carSpeed4.setText( speedcar4 + "");

            if(speedcar1>SpeedLimit.getMaxSpeedLimitCarOne()){
                over1.setText("是");
            }else if(speedcar1<SpeedLimit.getMinSpeedLimitCarOne()){
                main_carSpeed1.setText( "!stop");
            }else{
                over1.setText("否");
            }

            if(speedcar2>SpeedLimit.getMaxSpeedLimitCarTwo()){
                over2.setText("是");
            }else if(speedcar2<SpeedLimit.getMinSpeedLimitCarTwo()){
                main_carSpeed2.setText( "!stop");
            }else{
                over2.setText("否");
            }

            if(speedcar3>SpeedLimit.getMaxSpeedLimitCarThree()){
                over3.setText("是");
            }else if(speedcar3<SpeedLimit.getMinSpeedLimitCarThree()){
                main_carSpeed3.setText( "!stop");
            }else{
                over3.setText("否");
            }

            if(speedcar4>SpeedLimit.getMaxSpeedLimitCarFour()){
                over4.setText("是");
            }else if(speedcar4<SpeedLimit.getMinSpeedLimitCarFour()){
                main_carSpeed4.setText( "!stop");
            }else{
                over4.setText("否");
            }
        }
        @Override
        public void onFinish() {

        }
    };

}
