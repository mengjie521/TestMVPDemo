package m2166.com.testmvpdemo.page.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public class MvpActivity extends MVPBaseActivity<MvpActivity,MvpPresenterImp> implements MvpView {
    private static final String TAG = MvpActivity.class.getSimpleName();
    private Activity mActivity;
    private EditText userName;
    private EditText pwd;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_login);
        userName = (EditText) findViewById(R.id.et_username);
        pwd = (EditText) findViewById(R.id.et_pwd);
        login = (Button) findViewById(R.id.bt_login);
        login.setOnClickListener(mOnclickListener);
    }

    @Override
    protected MvpPresenterImp createPresenter() {
        return new MvpPresenterImp();
    }

    @Override
    public void loginSuccess(String msg) {
        Toast.makeText(mActivity,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail(int code,String errorMsg) {
        Toast.makeText(mActivity,errorMsg,Toast.LENGTH_SHORT).show();
    }

    private  View.OnClickListener mOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.bt_login:
                    mPresenter.login(userName.getText().toString(), pwd.getText().toString());
                    break;
            }
        }
    };
}
