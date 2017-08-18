package m2166.com.testmvpdemo.page.welfare;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;
import m2166.com.testmvpdemo.page.welfare.adapter.WelfareAdapter;
import m2166.com.testmvpdemo.page.welfare.net.ResultsBean;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class WelfareActivity extends MVPBaseActivity<WelfareActivity, WelfarePresenterImp> implements WelfareView{
    @BindView(R.id.tb_welfare)
    Toolbar tbWelfare;
    @BindView(R.id.rv_welfare)
    RecyclerView rvWelfare;

    Activity mActivity;
    private WelfareAdapter welfareAdapter;

    @Override
    protected WelfarePresenterImp createPresenter() {
        return new WelfarePresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare);
        mActivity = this;
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        tbWelfare.setTitle("福利列表");
        tbWelfare.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rvWelfare.setLayoutManager(staggeredGridLayoutManager);
        rvWelfare.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0,0,20,20);
            }
        });
        welfareAdapter = new WelfareAdapter(this);
        rvWelfare.setAdapter(welfareAdapter);
        mPresenter.getList();
    }

    @Override
    public void onGetDataSuccess(List<ResultsBean> list) {
        welfareAdapter.setListData(list);
    }

    @Override
    public void onGetDataFail(String msg) {

    }
}
