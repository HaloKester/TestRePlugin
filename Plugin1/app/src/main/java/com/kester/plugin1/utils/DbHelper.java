package com.kester.plugin1.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kester on 2017/7/11.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_FILE = "test_rp.db";

    public static final String PS1_TABLE_NAME = "plugin_table1";
    public static final String PS1_COL_PRIMARY_KEY = "primary_id";
    public static final String PS1_COL_VALUE1 = "value1";
    public static final String PS1_COL_VALUE2 = "value2";

    private Context mContext;
    public DbHelper(Context context) {
        super(context, DB_FILE, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.beginTransaction();
            createTable1(db);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    private void createTable1(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append("IF NOT EXISTS ").append(PS1_TABLE_NAME).append("(");
        sb.append(PS1_COL_PRIMARY_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT,");
        sb.append(PS1_COL_VALUE1 + " TEXT,");
        sb.append(PS1_COL_VALUE2 + " TEXT");
        sb.append(")");
        try {
            db.execSQL(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
