package m2166.com.testmvpdemo.page.dao;

import android.util.Log;

import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.dao.MySQLiteOpreate;

/**
 * author： mengjie on 2017/8/10.
 * email: weidadajie@163.com
 */

public class DaoPresenterImp extends BasePresenter<DaoActivity> implements DaoPresenter{
    DaoActivity mDaoActivity;


    @Override
    public void clearAllMsg() {
        mDaoActivity = getView();
        MySQLiteOpreate mySQLiteOpreate = new MySQLiteOpreate(mDaoActivity);
        mySQLiteOpreate.clearAll();
    }

    @Override
    public void addMsg(String username, String pwd) {
        mDaoActivity = getView();
        MySQLiteOpreate mySQLiteOpreate = new MySQLiteOpreate(mDaoActivity);
        mySQLiteOpreate.insert(username,pwd);
    }

    @Override
    public void deleteMsg(String username) {
        mDaoActivity = getView();
        MySQLiteOpreate mySQLiteOpreate = new MySQLiteOpreate(mDaoActivity);
        mySQLiteOpreate.delete(username);
    }

    @Override
    public void notifyMsg(String username, String newPwd) {
        mDaoActivity = getView();
        MySQLiteOpreate mySQLiteOpreate = new MySQLiteOpreate(mDaoActivity);
        mySQLiteOpreate.modification(username,newPwd);
    }

    @Override
    public void seekMsg(String username) {
        mDaoActivity = getView();
        MySQLiteOpreate mySQLiteOpreate = new MySQLiteOpreate(mDaoActivity);
        String password = mySQLiteOpreate.select(username);
        Log.e("=====", "seekMsg: "+password);
    }

    @Override
    public List<Users> seekAllMsg() {
        mDaoActivity = getView();
        MySQLiteOpreate mySQLiteOpreate = new MySQLiteOpreate(mDaoActivity);
        List<Users> allData = mySQLiteOpreate.getAllData();
        return allData;
    }


}
