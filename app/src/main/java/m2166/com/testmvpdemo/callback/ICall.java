package m2166.com.testmvpdemo.callback;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public interface ICall<T> {
    void onSuccess(T t);
    void onFail(String failMsg);
}
