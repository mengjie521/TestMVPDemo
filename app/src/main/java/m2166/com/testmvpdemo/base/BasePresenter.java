package m2166.com.testmvpdemo.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public class BasePresenter<V> {
    protected Reference<V> mReference;
    protected V mView;

    public void attachView(V view) {
        //WeakReference 弱引用
        mReference = new WeakReference<V>(view);
        mView =  mReference.get();
    }

    public V getView() {
        if (mReference == null) {
            return null;
        }
        return mReference.get();
    }

    public void detachView(){
        if (mReference != null) {
            mReference.clear();
            mReference = null;
        }
    }

}
