package m2166.com.testmvpdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends Activity {
    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
