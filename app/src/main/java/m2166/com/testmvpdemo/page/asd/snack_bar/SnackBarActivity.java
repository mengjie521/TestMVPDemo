package m2166.com.testmvpdemo.page.asd.snack_bar;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
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

public class SnackBarActivity extends MVPBaseActivity<SnackBarActivity, SnackBarPresenterImp> implements SnackBarView {
    Activity mActivity;
    @BindView(R.id.bt_snack_bar)
    Button btSnackBar;
    @BindView(R.id.fab_snack_01)
    FloatingActionButton fabSnack01;
    @BindView(R.id.fab_snack_02)
    FloatingActionButton fabSnack02;

    @Override
    protected SnackBarPresenterImp createPresenter() {
        return new SnackBarPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.actvity_snack_bar);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_snack_bar, R.id.fab_snack_01, R.id.fab_snack_02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_snack_bar:
                Snackbar.make(view,"要显示的snackBar",Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
                    @Override
                   public void onClick(View v) {
                        Toast.makeText(mActivity,"点击了snackBar的确认",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.fab_snack_01:
                Snackbar.make(view,"要显示的snackBar",Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mActivity,"点击了snackBar的确认2",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.fab_snack_02:
                Snackbar.make(view,"要显示的snackBar",Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mActivity,"点击了snackBar的确认3",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
        }
    }
}
