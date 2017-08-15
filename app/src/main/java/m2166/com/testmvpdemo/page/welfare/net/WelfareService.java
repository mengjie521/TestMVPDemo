package m2166.com.testmvpdemo.page.welfare.net;


import retrofit2.http.GET;
import rx.Observable;

/**
 * author： mengjie on 2017/8/15.
 * email: weidadajie@163.com
 */

public interface WelfareService {
    @GET("福利/50/1")
    Observable<WelfareSubject> getWelfareData();
}
