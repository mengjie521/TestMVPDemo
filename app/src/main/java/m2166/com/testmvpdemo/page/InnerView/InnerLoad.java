package m2166.com.testmvpdemo.page.InnerView;

import java.util.List;

import m2166.com.testmvpdemo.http.NetFactory;
import m2166.com.testmvpdemo.http.ObjectLoad;
import rx.Observable;
import rx.functions.Func1;

/**
 * author： mengjie on 2017/8/17.
 * email: weidadajie@163.com
 */

public class InnerLoad extends ObjectLoad {
    InnerService innerService;
    public InnerLoad() {
        innerService = NetFactory.getInstance().create(InnerService.class);
    }
    public Observable<List<ContentBean>> getBannerList(){
        return observe(innerService.getData()).map(new Func1<InnerSubject, List<ContentBean>>() {
            @Override
            public List<ContentBean> call(InnerSubject innerSubject) {
                return innerSubject.content;
            }
        });
    }
}
