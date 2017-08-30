package m2166.com.testmvpdemo.page.asd.toolbar_and_actionbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/23.
 * email: weidadajie@163.com
 */

public class ToolbarAndActionbarActivity extends MVPBaseActivity<ToolbarAndActionbarActivity, ToolbarAndActionbarPresenterImp> implements ToolbarAndActionbarView {
    Activity mActivity;
    @BindView(R.id.tb_demo)
    Toolbar tbDemo;

    @Override
    protected ToolbarAndActionbarPresenterImp createPresenter() {
        return new ToolbarAndActionbarPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_toolbar_actionbar);
        ButterKnife.bind(this);
        setSupportActionBar(tbDemo);
        tbDemo.setTitle(R.string.doudou);
        tbDemo.setTitleTextColor(Color.BLACK);
        tbDemo.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_menu:
                        Toast.makeText(mActivity,"菜单",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_reserch:
                        Toast.makeText(mActivity,"搜索",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
