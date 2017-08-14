package m2166.com.testmvpdemo.page.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class EventSecondActivity extends MVPBaseActivity<EventSecondActivity, EventSecondPersenterImp> {
    @BindView(R.id.bt_second)
    Button btSecond;

    @Override
    protected EventSecondPersenterImp createPresenter() {
        return new EventSecondPersenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_evevt);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_second)
    public void onViewClicked() {
        EventBus.getDefault().post(new FirstEvent("这可是哥哥的第一个eventBus额"));

        Log.e("====第二个activity点击了", "onViewClicked: " );
    }
}
