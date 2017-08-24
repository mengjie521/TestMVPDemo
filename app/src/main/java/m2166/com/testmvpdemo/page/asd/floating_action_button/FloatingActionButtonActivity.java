package m2166.com.testmvpdemo.page.asd.floating_action_button;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/23.
 * email: weidadajie@163.com
 */

public class FloatingActionButtonActivity extends MVPBaseActivity<FloatingActionButtonActivity, FloatingActionButtonPresenterImp> implements FloatingActionButtonView {
    Activity mActivity;
    @BindView(R.id.floating)
    FloatingActionButton floating;


    @Override
    protected FloatingActionButtonPresenterImp createPresenter() {
        return new FloatingActionButtonPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.actvity_floating_action_button);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.floating)
    public void onViewClicked() {
        Toast toast = Toast.makeText(mActivity, "点击了", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER ,0,0);
        toast.show();
    }
}
