package m2166.com.testmvpdemo.http;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * author： mengjie on 2017/8/9.
 * email: weidadajie@163.com
 */

public class ObjectLoad {
    protected <T> Observable<T> observe(Observable<T> observable ){
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
