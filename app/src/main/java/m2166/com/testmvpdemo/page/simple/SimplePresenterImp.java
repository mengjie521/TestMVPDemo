package m2166.com.testmvpdemo.page.simple;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import m2166.com.testmvpdemo.base.BasePresenter;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public class SimplePresenterImp extends BasePresenter<SimpleActivity>{
    SimpleActivity mvpActivity;

    public SimplePresenterImp(SimpleActivity mvpActivity) {
        this.mvpActivity = mvpActivity;
    }

    public void login(final String userName, final String password) {
        //模拟登陆
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (TextUtils.equals(userName, "111111") && TextUtils.equals(password, "123123")) {
                    mvpActivity.loginSuccess("hahahahah");
                } else {
                    mvpActivity.loginFail(0,"dedededed");
                }

            }
        }, 500);
    }
}
