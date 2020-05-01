package com.example.mappicture.SqliteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * 主要是对数据库操作的工具类
 * Created by Tnno Wu on 2017/1/29.
 */

public class DbManger {

    /**
     * 构建一个帮助类对象
     */
    private static MySQLiteHelper helper;

    /**
     * 定义一个相应的获取方式
     */
    public static MySQLiteHelper getInstance(Context context) {
        if (helper == null) {
            helper = new MySQLiteHelper(context);
        }
        return helper;
    }

    /**
     * 根据SQL语句在数据库中执行语句
     *
     * @param db  数据库对象
     * @param sql SQL语句
     */
    public static void execSQL(SQLiteDatabase db, String sql) {
        if (db != null) {
            if (sql != null && !"".equals(sql)) {
                db.execSQL(sql);
            }
        }
    }
}
