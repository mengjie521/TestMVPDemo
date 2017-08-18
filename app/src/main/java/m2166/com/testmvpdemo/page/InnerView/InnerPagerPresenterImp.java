package m2166.com.testmvpdemo.page.InnerView;

import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import rx.Observer;

/**
 * author： mengjie on 2017/8/17.
 * email: weidadajie@163.com
 */

class InnerPagerPresenterImp extends BasePresenter<InnerViewPagerActivity> implements InnerPagerPresenter{
    InnerViewPagerActivity innerViewPagerActivity;
    @Override
    public void getBannerData() {
        innerViewPagerActivity = getView();
        new InnerLoad().getBannerList().subscribe(new Observer<List<ContentBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                innerViewPagerActivity.onFail(e.getMessage());
            }

            @Override
            public void onNext(List<ContentBean> contentBeen) {
                innerViewPagerActivity.onSuccess(contentBeen);
            }
        });
    }
}
