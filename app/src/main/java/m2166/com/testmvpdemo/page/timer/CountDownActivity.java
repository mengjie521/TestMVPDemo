package m2166.com.testmvpdemo.page.timer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/28.
 * email: weidadajie@163.com
 */

public class CountDownActivity extends MVPBaseActivity<CountDownActivity, CountDownPresenterImp> implements CountDownView {
    @BindView(R.id.bt_count_down)
    Button btCountDown;

    @Override
    protected CountDownPresenterImp createPresenter() {
        return new CountDownPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_count_down)
    public void onViewClicked() {
        MyCountDown myCountDown = new MyCountDown(10000, 1000);
        myCountDown.start();
    }

    private class MyCountDown extends CountDownTimer{
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        /**
         * Callback fired on regular interval.
         *
         * @param millisUntilFinished The amount of time until finished.
         */
        @Override
        public void onTick(long millisUntilFinished) {
            btCountDown.setText("倒计时 " + (millisUntilFinished / 1000) + "");
        }

        /**
         * Callback fired when the time is up.
         */
        @Override
        public void onFinish() {
            finish();
        }
    }
}
