package com.example.hu.dazuoye;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hu.dazuoye.db.UserSqliteOpenHelper;
import com.example.hu.dazuoye.db.dao.UserDao;

public class MainActivity extends TitleActivity {

    private long exit_time;//用于实现按两次back退出

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


    }




    //主界面返回键重置为回到桌面
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);

    }
}
