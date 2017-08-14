package m2166.com.testmvpdemo.net;

import java.util.List;

import m2166.com.testmvpdemo.http.NetFactory;
import m2166.com.testmvpdemo.http.ObjectLoad;
import rx.Observable;
import rx.functions.Func1;

/**
 * author： mengjie on 2017/8/9.
 * email: weidadajie@163.com
 */

public class BannerLoad extends ObjectLoad{
    private BannerService bannerService;
    public BannerLoad() {
        bannerService = NetFactory.getInstance().create(BannerService.class);
    }

    /**
     * 获取图片列表BannerSubject
     */
    public Observable<List<ContentBean>> getBannerList(){
        return observe(bannerService.getData()).map(new Func1<BannerSubject, List<ContentBean>>() {
            @Override
            public List<ContentBean> call(BannerSubject bannerSubject) {
                return bannerSubject.content;
            }
        });
    }
}
