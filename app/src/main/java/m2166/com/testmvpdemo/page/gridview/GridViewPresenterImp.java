package m2166.com.testmvpdemo.page.gridview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.BasePresenter;

/**
 * author： mengjie on 2017/8/21.
 * email: weidadajie@163.com
 */

class GridViewPresenterImp extends BasePresenter<GridViewActivity> implements GridViewPresenter{
    GridViewActivity gridViewActivity;
    int[] icons = new int[]{R.mipmap.a111,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6};
    String[] iconNames = new String[]{"日历","浏览器","相册","相机","计算器","闹钟"};
    @Override
    public void getData() {
        gridViewActivity = getView();
        List<Map<String, Object>> datas = new ArrayList<>();
        for (int i = 0; i < icons.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("icons", icons[i]);
            map.put("names", iconNames[i]);
            datas.add(map);
            gridViewActivity.datas(datas);
        }
    }
}
