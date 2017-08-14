package m2166.com.testmvpdemo.net;

import retrofit2.http.GET;
import rx.Observable;

/**
 * author： mengjie on 2017/8/9.
 * email: weidadajie@163.com
 */

public interface BannerService {
    @GET("/app.php?s=Index/Banner")
    Observable<BannerSubject> getData();

}
