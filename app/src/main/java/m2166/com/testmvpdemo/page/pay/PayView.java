package m2166.com.testmvpdemo.page.pay;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public interface PayView {
    void paySuccess(int type,String successMsg);
    void payFail(int code,String errorMsg);
}
