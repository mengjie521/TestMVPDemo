package m2166.com.testmvpdemo.page.recycle;

import java.util.List;

import m2166.com.testmvpdemo.page.recycle.data.Falls;
import m2166.com.testmvpdemo.page.recycle.data.Number;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

interface RecycleViewView {
    void getLinearLayoutData(List<Number> list);
    void getFallsData(List<Falls> list);
}
