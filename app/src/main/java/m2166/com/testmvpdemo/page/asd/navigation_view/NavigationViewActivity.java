package m2166.com.testmvpdemo.page.asd.navigation_view;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
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

public class NavigationViewActivity extends MVPBaseActivity<NavigationViewActivity, NavigationViewPresenterImp> implements NavigationViewView, NavigationView.OnNavigationItemSelectedListener {
    Activity mActivity;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigation)
    NavigationView navigation;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;

    @Override
    protected NavigationViewPresenterImp createPresenter() {
        return new NavigationViewPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.actvity_navigation);
        ButterKnife.bind(this);
        navigation.setNavigationItemSelectedListener(this);
        toolbar.setTitle("我是主界面");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(mActivity, drawerlayout, R.string.navigation_open,R.string.navigation_close);
        drawerlayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_a1:
                Toast.makeText(mActivity, "a1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a2:
                Toast.makeText(mActivity, "a2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a3:
                Toast.makeText(mActivity, "a3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a4:
                Toast.makeText(mActivity, "a4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a41:
                Toast.makeText(mActivity, "a41", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a21:
                Toast.makeText(mActivity, "a21", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a31:
                Toast.makeText(mActivity, "a31", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_a11:
                Toast.makeText(mActivity, "a11", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
