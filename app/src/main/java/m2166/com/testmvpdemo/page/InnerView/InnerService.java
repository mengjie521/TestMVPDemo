package m2166.com.testmvpdemo.page.InnerView;

import retrofit2.http.GET;
import rx.Observable;

/**
 * author： mengjie on 2017/8/17.
 * email: weidadajie@163.com
 */

public interface InnerService {
    @GET ("/app.php?s=Index/Banner")
    Observable<InnerSubject> getData();
}
