
package com.example.hu.dazuoye.db.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hu.dazuoye.db.UserSqliteOpenHelper;

/**
 * Created by ken on 2018/1/6.
 * 一个专门用于操作数据库的类，用于提供增删改查的方法
 */

public class UserDao {

    //引用工具类UserSqliteOpenHelper
    UserSqliteOpenHelper helper;

    //
    public UserDao(Context context){
        helper = new UserSqliteOpenHelper(context);
    }


    //如果做增删改操作，就getWritableDatabase,表示获得一个可写的数据库
    public void insert(String username, String account, String password, int balance){

        SQLiteDatabase db = helper.getWritableDatabase();

        //插入数据
        db.execSQL("insert into user values(null,?,?,?,?)", new Object[]{username,account,password,balance});

        //插入结束后，关闭数据库，释放资源
        db.close();
    }
    public void delete(String account){
        SQLiteDatabase db = helper.getWritableDatabase();

        //delete
        db.execSQL("delete from user where account=?", new Object[]{account});

        //删除后，关闭数据库，释放资源
        db.close();
    }
    public void updatepassword(String account,String password){
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("update user set passwoad=? where account=?", new Object[]{password,account});
        //数组内应该按sql内顺序写
        db.close();
    }
    //充值
    public void reCharge(String account,int balance){
        SQLiteDatabase db = helper.getWritableDatabase();

        db.execSQL("update user set balance=balance+? where account=?",new Object[]{balance,account});

        db.close();
    }
    //找回密码
    public String findPassword(String account){

        //获得一个可读的数据库
        SQLiteDatabase db = helper.getReadableDatabase();

//        db.execSQL("select * from user where username=?", new Object[]{username});

        Cursor cursor = db.rawQuery("select password from user where account=?", new String[]{account});

        String password = null;
        if(cursor.moveToNext()){
            password = cursor.getString(0);
        }

        return password;
    }

    //检查是否存在该账号
    public String checkAccount(String account){

        //获得一个可读的数据库
        SQLiteDatabase db = helper.getReadableDatabase();

//        db.execSQL("select * from user where username=?", new Object[]{username});

        Cursor cursor = db.rawQuery("select account from user where account=?", new String[]{account});

        account=null;
        if(cursor.moveToNext()){
            account = cursor.getString(0);
        }

        return account;
    }

    //检查是否存在该用户名
    public String checkUsername(String username){

        //获得一个可读的数据库
        SQLiteDatabase db = helper.getReadableDatabase();

//        db.execSQL("select * from user where username=?", new Object[]{username});

        Cursor cursor = db.rawQuery("select username from user where username=?", new String[]{username});

        username = null;
        if(cursor.moveToNext()){
            username = cursor.getString(0);
        }

        return username;
    }
    //检查密码是否正确
    public String CheckPassword(String password){

        //获得一个可读的数据库
        SQLiteDatabase db = helper.getReadableDatabase();

//        db.execSQL("select * from user where username=?", new Object[]{username});

        Cursor cursor = db.rawQuery("select password from user where password=?", new String[]{password});

        password = null;
        if(cursor.moveToNext()){
            password = cursor.getString(0);
        }

        return password;
    }

    //查询余额
    public Integer findBalance(String account){

        //获得一个可读的数据库
        SQLiteDatabase db = helper.getReadableDatabase();

//        db.execSQL("select * from user where username=?", new Object[]{username});

        Cursor cursor = db.rawQuery("select balance from user where account=?", new String[]{account});

        Integer balance = null;
        if(cursor.moveToNext()){
            balance = cursor.getInt(0);
        }

        return balance;
    }

    //查找用户名
    public String findUsername(String account){

        //获得一个可读的数据库
        SQLiteDatabase db = helper.getReadableDatabase();

//        db.execSQL("select * from user where username=?", new Object[]{username});

        Cursor cursor = db.rawQuery("select username from user where account=?", new String[]{account});

        String username = null;
        if(cursor.moveToNext()){
            username = cursor.getString(0);
        }

        return username;
    }






}
