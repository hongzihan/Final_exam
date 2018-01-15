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
import com.example.hu.finalexam.domain.User;
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
        TextView main_balance = (TextView)findViewById(R.id.main_balance);
        main_balance.setText(udao.findBalance(User.getAccount()) + "元");









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

    public void set_btn(View view){
        startActivity(new Intent(this,MinMax.class));
    }



    //CountDownTimer计时器 通过onCreate()的cdt.start()启动
    CountDownTimer cdt = new CountDownTimer(100000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            TextView main_carSpeed = (TextView)findViewById(R.id.main_carSpeed);
            main_carSpeed.setText(randomDatas(User.getMinSpeed(),User.getMaxSpeed()) + "km/h" + "最高车速为120km/h");


        }
        @Override
        public void onFinish() {

        }
    };

}
