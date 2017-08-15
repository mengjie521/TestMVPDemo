package m2166.com.testmvpdemo.page.welfare;

import android.util.Log;

import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.callback.ICall;
import m2166.com.testmvpdemo.page.welfare.net.ResultsBean;
import m2166.com.testmvpdemo.page.welfare.net.WelfareLoad;
import rx.Observer;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class WelfarePresenterImp extends BasePresenter<WelfareActivity> implements WelfarePresenter{

    @Override
    public void getList(final ICall<List<ResultsBean>> call) {
        new WelfareLoad().getWelfareList().subscribe(new Observer<List<ResultsBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                call.onFail(e.getMessage());
            }

            @Override
            public void onNext(List<ResultsBean> resultsBeen) {
                call.onSuccess(resultsBeen);
            }
        });
    }
}
