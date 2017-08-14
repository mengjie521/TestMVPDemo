package m2166.com.testmvpdemo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * author： mengjie on 2017/8/10.
 * email: weidadajie@163.com
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public MySQLiteHelper(Context context) {
        super(context, "test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table users(id integer primary key ,user text ,pwd text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
