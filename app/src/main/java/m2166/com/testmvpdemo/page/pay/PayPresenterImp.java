package m2166.com.testmvpdemo.page.pay;

import android.os.Handler;
import android.os.Looper;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.constant;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

class PayPresenterImp extends BasePresenter<PayActivity> implements PayPresenter {
    private  PayActivity mPayActivity;

    public PayPresenterImp(PayActivity mPayActivity) {
        this.mPayActivity = mPayActivity;
    }

    @Override
    public void aliPay(int money, String produceName) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPayActivity.paySuccess(constant.PAY_ALIPAY,"sussess,sussess,sussess,sussess");
            }
        },100);
    }

    @Override
    public void wechatPay(int money, String produceName) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPayActivity.paySuccess(constant.PAY_WEICHAT,"sussess,sussess,sussess,sussess");
            }
        },100);
    }

    @Override
    public void hxPtb(int money, String produceName) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPayActivity.paySuccess(constant.PAY_HXPTB,"sussess,sussess,sussess,sussess");
            }
        },100);
    }

    @Override
    public void hxHB(int money, String produceName) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                mPayActivity.payFail(constant.PAY_HXHB,"payFail,payFail,payFail,payFail");
            }
        },100);
    }

}
