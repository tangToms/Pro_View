package com.example.pro_view;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    //context:上下文对象，name：数据库名；factory:Cursor 工厂
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory){
        super(context,name,factory,1);
    }
    //创建数据库文件时调用，可以在这里创建数据库表
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE person(name VARCHAR(20) PRIMARY KEY,sex VARCHAR(4),info VARCHAR(40))");
    }
    //数据库版本变化
    //修改、删除、添加数据库表
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
