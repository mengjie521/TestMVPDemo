package m2166.com.testmvpdemo.page.asd.app_bar_layout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/23.
 * email: weidadajie@163.com
 */

public class AppBarLayoutActivity extends MVPBaseActivity<AppBarLayoutActivity, AppBarLayoutPresenterImp> implements AppBarLayoutView {
    Activity mActivity;
    @BindView(R.id.tb_appbar)
    Toolbar tbAppbar;

    @Override
    protected AppBarLayoutPresenterImp createPresenter() {
        return new AppBarLayoutPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_app_bar_layout);
        ButterKnife.bind(this);
        tbAppbar.setTitle("哈哈哈哈哈哈");
        tbAppbar.setNavigationIcon(R.mipmap.happy);
        tbAppbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(tbAppbar);
    }

}
