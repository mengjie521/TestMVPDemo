package m2166.com.testmvpdemo.page.butterknife;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public class ButterknifeActivity extends Activity {

    @BindView(R.id.bt_test)
    Button btTest;
    @BindView(R.id.et_test)
    EditText etTest;
    @BindView(R.id.tv_test)
    TextView tvTest;
    @BindView(R.id.iv_test)
    ImageView ivTest;
    Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        btTest.setText("hahahahaha");
        etTest.setText("hehehehehhe");
        tvTest.setText("heiheiheiheiehi");

    }

    @OnClick(R.id.iv_test)
    public void onViewClicked() {
        Toast.makeText(mActivity,"GGGGGGGGGG",Toast.LENGTH_SHORT).show();
    }
}
