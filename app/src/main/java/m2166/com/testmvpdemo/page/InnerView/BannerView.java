package m2166.com.testmvpdemo.page.InnerView;

import java.util.List;

/**
 * author： mengjie on 2017/8/17.
 * email: weidadajie@163.com
 */

public interface BannerView {
    void onSuccess(List<ContentBean> contentBeen);
    void onFail(String errorMag);
}
