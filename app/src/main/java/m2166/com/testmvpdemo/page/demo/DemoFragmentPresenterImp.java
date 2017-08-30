package m2166.com.testmvpdemo.page.demo;

import android.util.Log;

import m2166.com.testmvpdemo.base.BasePresenter;

/**
 * author： mengjie on 2017/8/28.
 * email: weidadajie@163.com
 */

class DemoFragmentPresenterImp extends BasePresenter<FragmentDemo> implements DemoFragmentPresenter{
    FragmentDemo mFragmentDemo;

    public DemoFragmentPresenterImp(FragmentDemo mFragmentDemo) {
        this.mFragmentDemo = mFragmentDemo;
    }

    @Override
    public void setData() {
//        mFragmentDemo = getView();
        Log.e("====", "setData: "+ mFragmentDemo );
        mFragmentDemo.getData("qqqqqqqq");
    }
}
