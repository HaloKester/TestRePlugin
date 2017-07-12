package com.kester.plugin1.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.kester.plugin1.utils.DbHelper;

/**
 * Created by kester on 2017/7/11.
 */
public class PluginProviderS1 extends ContentProvider {

    private DbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new DbHelper(getContext());
        return true;
    }

    private String splitTableName(Uri uri) {
        return uri.getLastPathSegment();
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String table = splitTableName(uri);
        return db.query(table, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String table = splitTableName(uri);
        db.insertWithOnConflict(table, null, values, SQLiteDatabase.CONFLICT_REPLACE);
        return uri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String table = splitTableName(uri);
        return db.delete(table, selection, selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String table = splitTableName(uri);
        return db.update(table, values, selection, selectionArgs);
    }
}
