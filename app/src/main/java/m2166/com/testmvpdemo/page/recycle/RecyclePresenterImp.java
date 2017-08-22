package m2166.com.testmvpdemo.page.recycle;

import java.util.ArrayList;
import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.page.recycle.data.Falls;
import m2166.com.testmvpdemo.page.recycle.data.Number;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

class RecyclePresenterImp extends BasePresenter<RecycleActivity> implements RecyclePresenter{
    RecycleActivity mRecycleActivity;
    @Override
    public void getData() {
        mRecycleActivity = getView();
        List<Number> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Number(i + ""));
        }
        mRecycleActivity.getLinearLayoutData(list);
    }

    @Override
    public void getFallsData() {
        mRecycleActivity = getView();
        List<Falls> list1 = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list1.add(new Falls(i+"",(int) (100 + Math.random() * 300)));
        }
        mRecycleActivity.getFallsData(list1);
    }
}
