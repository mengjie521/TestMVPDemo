package m2166.com.testmvpdemo.page.welfare;

import android.util.Log;

import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.page.welfare.net.ResultsBean;
import m2166.com.testmvpdemo.page.welfare.net.WelfareLoad;
import rx.Observer;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class WelfarePresenterImp extends BasePresenter<WelfareActivity> implements WelfarePresenter{
   WelfareActivity welfareActivity;
    @Override
    public void getList() {
        welfareActivity = getView();
        new WelfareLoad().getWelfareList().subscribe(new Observer<List<ResultsBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e("=====", "onError: "+e.getMessage() );
                welfareActivity.onGetDataFail(e.getMessage());
            }

            @Override
            public void onNext(List<ResultsBean> resultsBeen) {
                for (int i = 0; i < resultsBeen.size(); i++) {
                    Log.e("=====", "onNext: "+resultsBeen.get(i)._id );
                }
                welfareActivity.onGetDataSuccess(resultsBeen);
            }
        });
    }

//    @Override
//    public void getList(final ICall<List<ResultsBean>> call) {
//        new WelfareLoad().getWelfareList().subscribe(new Observer<List<ResultsBean>>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                call.onFail(e.getMessage());
//            }
//
//            @Override
//            public void onNext(List<ResultsBean> resultsBeen) {
//                for (int i = 0; i < resultsBeen.size(); i++) {
//                    Log.e("=====", "onNext: "+resultsBeen.get(i)._id );
//                }
//                call.onSuccess(resultsBeen);
//            }
//        });
//    }
}
