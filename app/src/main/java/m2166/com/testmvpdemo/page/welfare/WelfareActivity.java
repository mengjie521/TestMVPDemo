package m2166.com.testmvpdemo.page.welfare;

import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class WelfareActivity extends MVPBaseActivity<WelfareActivity,WelfarePresenterImp> implements WelfareView{
    @Override
    protected WelfarePresenterImp createPresenter() {
        return new WelfarePresenterImp();
    }
}
