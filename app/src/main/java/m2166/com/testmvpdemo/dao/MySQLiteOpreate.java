package m2166.com.testmvpdemo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import m2166.com.testmvpdemo.page.dao.Users;

/**
 * author： mengjie on 2017/8/10.
 * email: weidadajie@163.com
 */

public class MySQLiteOpreate {
    Context context;

    public MySQLiteOpreate(Context context) {
        this.context = context;
    }

    public void insert(String userName,String pwd){
        MySQLiteHelper helper = new MySQLiteHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);

        boolean isExist = false;
        while (cursor.moveToNext()) {
            String user = cursor.getString(1);
            if (TextUtils.equals(user, userName)) {
                //存在,不插入
                Log.e("====", "old: "+ user +"new:"+userName);
                isExist = true;
                Toast.makeText(context,"用户名存在",Toast.LENGTH_SHORT).show();
                return;
            }
            Log.e("==", "insert: "+isExist );
        }

        if (!isExist) { //没有记录,执行插入的逻辑
            ContentValues contentValues = new ContentValues();
            contentValues.put("user",userName);
            contentValues.put("pwd",pwd);
            long users = db.insert("users", null, contentValues);
            Log.e("===users", "insert: "+users );
        }
        cursor.close();
        db.close();
    }

    public String select(String userName){
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from  users", null);
        while (cursor.moveToNext()) {
            String user = cursor.getString(1);
            String password = cursor.getString(2);
            if(TextUtils.equals(user,userName)){
                Log.e("=====根据用户名找密码", "select: "+password);
                return password;
            }
        }
        cursor.close();
        db.close();
        return null;
    }

    public void modification(String userName,String password){
        MySQLiteHelper mySQLLiteHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = mySQLLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String user = cursor.getString(1);
            Log.e("===xiugai", "modification: "+id +"user"+user );
            if(TextUtils.equals(userName,user)){
                ContentValues contentValues = new ContentValues();
                contentValues.put("user",userName);
                contentValues.put("pwd",password);
                int users = db.update("users", contentValues, "id=?", new String[]{String.valueOf(id)});
                Log.e("=====xiugaiwan", "modification: "+users );
            }
        }
        cursor.close();
        db.close();
    }

    public void delete(String userName){
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String user = cursor.getString(1);
            if(TextUtils.equals(userName,user)){
                int users = db.delete("users", "id=?", new String[]{String.valueOf(id)});
                Log.e("====删除", "delete: "+users );
            }

        }
        cursor.close();
        db.close();
    }

    public void clearAll() {
        MySQLiteHelper mySQLiteHelper = new MySQLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);
        while (cursor.moveToNext()) {
            int anInt = cursor.getInt(0);
            int user = db.delete("users", "id=?", new String[]{String.valueOf(anInt)});
            Log.e("===清空所有", "clearAll: "+user);
        }
        cursor.close();
        db.close();
    }

    public List<Users> getAllData(){
        MySQLiteHelper m = new MySQLiteHelper(context);
        SQLiteDatabase db = m.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users", null);
        List<Users> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            Users users = new Users();
            String userName = cursor.getString(cursor.getColumnIndex("user"));
            String pwd = cursor.getString(cursor.getColumnIndex("pwd"));
            users.setUserName(userName);
            users.setPassword(pwd);
            list.add(users);
        }
        cursor.close();
        db.close();
        return list;
    }
}
