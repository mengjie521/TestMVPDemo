package m2166.com.testmvpdemo.page.pay;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public class PayActivity extends MVPBaseActivity<PayActivity,PayPresenterImp> implements PayView {
    private static final String TAG = PayActivity.class.getSimpleName();
    private Button payAliPay;
    private Button payWechat;
    private Button payHxPtb;
    private Button payHxHb;
    private Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_pay);
        payAliPay = (Button) findViewById(R.id.bt_alipay);
        payWechat = (Button) findViewById(R.id.bt_wechatpay);
        payHxPtb = (Button) findViewById(R.id.bt_hxptb);
        payHxHb = (Button) findViewById(R.id.bt_hxhb);

        payAliPay.setOnClickListener(mClickListener);
        payWechat.setOnClickListener(mClickListener);
        payHxPtb.setOnClickListener(mClickListener);
        payHxHb.setOnClickListener(mClickListener);
    }

    @Override
    protected PayPresenterImp createPresenter() {
        return new PayPresenterImp(this);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.bt_alipay:
                    mPresenter.aliPay(100,"支付宝");
                    break;
                case R.id.bt_wechatpay:
                    Log.e(TAG, "onClick:微信 ");
                    mPresenter.wechatPay(200,"微信");
                    break;
                case R.id.bt_hxptb:
                    Log.e(TAG, "onClick:平台币 ");
                    mPresenter.hxPtb(300,"平台币");
                    break;
                case R.id.bt_hxhb:
                    Log.e(TAG, "onClick:红包 ");
                    mPresenter.hxHB(400,"红包");
                    break;

            }
        }
    };

    @Override
    public void paySuccess(int type,String successMsg) {
        Toast toast = Toast.makeText(mActivity, type + "+++" + successMsg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER,0,0);
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        ImageView imageView = new ImageView(mActivity);
        imageView.setImageResource(R.mipmap.happy);
        linearLayout.addView(imageView);
        toast.show();
    }

    @Override
    public void payFail(int code, String errorMsg) {
        Toast toast = Toast.makeText(mActivity, code + "+++" + errorMsg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER,0,0);
        LinearLayout linearLayout = (LinearLayout) toast.getView();
        ImageView imageView = new ImageView(mActivity);
        imageView.setImageResource(R.mipmap.no_happy);
        linearLayout.addView(imageView);
        toast.show();
    }
}
