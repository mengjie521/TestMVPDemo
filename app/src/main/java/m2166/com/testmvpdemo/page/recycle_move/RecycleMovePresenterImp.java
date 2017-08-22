package m2166.com.testmvpdemo.page.recycle_move;

import java.util.ArrayList;
import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.page.recycle_move.data.DataBean;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

public class RecycleMovePresenterImp extends BasePresenter<RecycleMoveActivity> implements RecycleMovePresenter{
    RecycleMoveActivity mRecycleMoveActivity;
    @Override
    public void getNetData() {
        mRecycleMoveActivity = getView();
        List<DataBean> list = new ArrayList<>();
        for (int i = 0; i < 33 ; i++) {
            list.add(new DataBean(i + ""));
        }
        mRecycleMoveActivity.success(list);
    }
}
