package m2166.com.testmvpdemo.page.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/21.
 * email: weidadajie@163.com
 */

public class GridViewActivity extends MVPBaseActivity<GridViewActivity, GridViewPresenterImp> implements GridViewView{
    @BindView(R.id.gv)
    GridView gv;
    Activity mActivity;
    private ListAdapter listAdapter;

    @Override
    protected GridViewPresenterImp createPresenter() {
        return new GridViewPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_grid_view);
        ButterKnife.bind(this);
        mPresenter.getData();
    }


    @Override
    public void datas( List<Map<String, Object> > datas) {
        listAdapter = new SimpleAdapter(mActivity, datas, R.layout.item_gridview,
                new String[]{"icons", "iconNames"}, new int[]{R.id.iv_icon, R.id.tv_name});
        gv.setAdapter(listAdapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(mActivity, "点击了" + position, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }
}
