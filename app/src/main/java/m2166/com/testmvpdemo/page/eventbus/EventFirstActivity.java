package m2166.com.testmvpdemo.page.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class EventFirstActivity extends MVPBaseActivity<EventFirstActivity, EventFirstPresenterImp> {
    @BindView(R.id.bt_button)
    Button btButton;
    @BindView(R.id.tv_text)
    TextView tvText;
    Activity mActivity;

    @Override
    protected EventFirstPresenterImp createPresenter() {
        return new EventFirstPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_first_event);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_button)
    public void onViewClicked() {
        startActivity(new Intent(mActivity,EventSecondActivity.class));
    }

    @Subscribe
    public void onEventMainThread(FirstEvent firstEvent){
        String msg = firstEvent.getMsg();
        tvText.setText("得到数据了吗::::"+msg);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
