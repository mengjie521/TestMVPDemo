package m2166.com.testmvpdemo.page.welfare.net;

import java.util.List;

import m2166.com.testmvpdemo.http.NetFactory;
import m2166.com.testmvpdemo.http.ObjectLoad;
import rx.Observable;
import rx.functions.Func1;

/**
 * author： mengjie on 2017/8/15.
 * email: weidadajie@163.com
 */

public class WelfareLoad extends ObjectLoad{
    WelfareService welfareService;
    public WelfareLoad() {
        welfareService = NetFactory.getInstance().create(WelfareService.class);
    }

    public Observable<List<ResultsBean>> getWelfareList(){
        return observe(welfareService.getWelfareData()).map(new Func1<WelfareSubject, List<ResultsBean>>() {
            @Override
            public List<ResultsBean> call(WelfareSubject welfareSubject) {
                return welfareSubject.results;
            }
        });
    }
}
