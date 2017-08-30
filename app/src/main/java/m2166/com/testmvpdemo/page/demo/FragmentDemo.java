package m2166.com.testmvpdemo.page.demo;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseFragment;
import m2166.com.testmvpdemo.page.pay.PayActivity;

/**
 * author： mengjie on 2017/8/28.
 * email: weidadajie@163.com
 */

public class FragmentDemo extends MVPBaseFragment<FragmentDemo,DemoFragmentPresenterImp> implements DemoView{
    @BindView(R.id.iv_demo)
    ImageView ivDemo;
    Unbinder unbinder;
    @BindView(R.id.tv_demo)
    TextView tvDemo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected DemoFragmentPresenterImp createPresenter() {
        return new DemoFragmentPresenterImp(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.setData();
        tvDemo.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvDemo.getPaint().setAntiAlias(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_demo)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), PayActivity.class));
    }

    @Override
    public void getData(String msg) {
        Log.e("======", "getData: "+msg );
    }
}
