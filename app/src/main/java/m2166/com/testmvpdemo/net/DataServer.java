package m2166.com.testmvpdemo.net;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public interface DataServer {
    ///http://www.2166.com/app.php?s=Index/Banner
    @GET("/app.php?s=Index/Banner")
    Call<BannerBean> call();
}
