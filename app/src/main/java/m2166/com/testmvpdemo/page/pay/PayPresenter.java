package m2166.com.testmvpdemo.page.pay;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public interface PayPresenter {
    void aliPay(int money,String produceName);
    void wechatPay(int money,String produceName);
    void hxPtb(int money,String produceName);
    void hxHB(int money,String produceName);
}
