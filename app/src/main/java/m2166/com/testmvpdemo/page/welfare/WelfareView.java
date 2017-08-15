package m2166.com.testmvpdemo.page.welfare;

import java.util.List;

import m2166.com.testmvpdemo.page.welfare.net.ResultsBean;

/**
 * author： mengjie on 2017/8/15.
 * email: weidadajie@163.com
 */

public interface WelfareView {
    void onGetDataSuccess(List<ResultsBean> list);
    void onGetDataFail(String msg);
}
