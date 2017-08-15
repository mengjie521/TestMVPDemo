package m2166.com.testmvpdemo.page.welfare;

import java.util.List;

import m2166.com.testmvpdemo.callback.ICall;
import m2166.com.testmvpdemo.page.welfare.net.ResultsBean;

/**
 * author： mengjie on 2017/8/15.
 * email: weidadajie@163.com
 */

public interface WelfarePresenter {
    void getList(ICall<List<ResultsBean>> call);
}
