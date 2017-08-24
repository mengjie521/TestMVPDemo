package m2166.com.testmvpdemo.page.asd.coordinator_layout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/23.
 * email: weidadajie@163.com
 */

public class CoordinatorLayoutActivity extends MVPBaseActivity<CoordinatorLayoutActivity, CoordinatorLayoutPresenterImp> implements CoordinatorLayoutView {
    Activity mActivity;

    @Override
    protected CoordinatorLayoutPresenterImp createPresenter() {
        return new CoordinatorLayoutPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_coordintaor_layout);

    }

}
