package com.example.hu.finalexam.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ken on 2018/1/6.
 */

public class UserSqliteOpenHelper extends SQLiteOpenHelper{

    public UserSqliteOpenHelper(Context context) {
        //context对象 ：应用上下文对象
        //name:数据库的名称
        //factory:游标工厂 当设置为null时就为默认的游标工厂
        //version:版本，数据库的版本，第一次发行为1
        //初始版本必须大于0，并且只能升级不能降级
        super(context, "user.db", null, 1);
    }

    // 数据库文件第一次创建时会执行的方法onCreate
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate方法被调用了");
        //在数据库中去创建表，数据库最终存储都为字符串
        //username 用户名,account 账号,password 密码,balance 余额
        db.execSQL("create table user( _id integer primary key autoincrement, username varchar(30), " +
                "account varchar(40), password varchar(40), balance integer)");

    }

    //用于版本更新后调用的方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("onUpgrade方法被调用了");
        if(oldVersion==1){
            //若旧版本为1，则执行该语句
            db.execSQL("");
        }
        else if (oldVersion == 2){
            //同理
        }
        else{
            //若全不满足则执行该句，即当前版本最新版本更新，若有下一版本更新，则将此处加入新的else if(oldversion==当前版本){};
        }
    }
}
