package m2166.com.testmvpdemo.page.asd.TextInputLayout;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
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

public class TextInputLayoutActivity extends MVPBaseActivity<TextInputLayoutActivity, TextInputLayoutPresenterImp> implements TextInputLayoutView {
    Activity mActivity;
    @BindView(R.id.et_user_til)
    EditText etUserTil;
    @BindView(R.id.bu_text_input)
    Button buTextInput;
    @BindView(R.id.textLayout)
    TextInputLayout textLayout;


    @Override
    protected TextInputLayoutPresenterImp createPresenter() {
        return new TextInputLayoutPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.actvity_text_input_layout);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.bu_text_input)
    public void onViewClicked() {
        String trim = etUserTil.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            textLayout.setError("不能为空");
        }else{
            Toast.makeText(mActivity,"成功了嘎嘎嘎嘎!!!",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
