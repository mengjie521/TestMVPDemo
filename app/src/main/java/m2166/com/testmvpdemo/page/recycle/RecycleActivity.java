package m2166.com.testmvpdemo.page.recycle;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;
import m2166.com.testmvpdemo.page.recycle.adapter.RecycleAdapter;
import m2166.com.testmvpdemo.page.recycle.data.Falls;
import m2166.com.testmvpdemo.page.recycle.data.Number;
import m2166.com.testmvpdemo.utils.GridLayoutDividerGridItemDecoration;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

public class RecycleActivity extends MVPBaseActivity<RecycleActivity, RecyclePresenterImp> implements RecycleViewView {
    @BindView(R.id.recycle)
    RecyclerView recycle;
    Activity mActivity;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.remove)
    Button remove;
    private RecycleAdapter recycleAdapter;

    @Override
    protected RecyclePresenterImp createPresenter() {
        return new RecyclePresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);
//        recycle.setLayoutManager(new LinearLayoutManager(mActivity));
//        recycle.addItemDecoration(new LinearLayoutDividerItemDecoration(mActivity, LinearLayoutDividerItemDecoration.VERTICAL_LIST));
//        recycle.setLayoutManager(new GridLayoutManager(mActivity, 4));
//        recycle.addItemDecoration(new GridLayoutDividerGridItemDecoration(mActivity));
        recycle.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        recycle.addItemDecoration(new GridLayoutDividerGridItemDecoration(mActivity));
        recycle.setItemAnimator(new DefaultItemAnimator());
        recycleAdapter = new RecycleAdapter(mActivity);
        recycle.setAdapter(recycleAdapter);
        mPresenter.getData();
        mPresenter.getFallsData();
    }

    @Override
    public void getLinearLayoutData(List<Number> list) {
        recycleAdapter.setDate(list);
    }

    @Override
    public void getFallsData(List<Falls> list) {
        for (int i = 0; i < list.size(); i++) {
            Log.e("=====", "getFallsData: "+list.get(i).getData()+"+++"+list.get(i).getHeight() );
        }
//        recycleAdapter.setFallsData(list);
    }

    @OnClick({R.id.add, R.id.remove})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                recycleAdapter.addDate(20);
                break;
            case R.id.remove:
                recycleAdapter.removeDate(20);
                break;
        }
    }
}
