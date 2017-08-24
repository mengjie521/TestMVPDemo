package m2166.com.testmvpdemo.page.asd.collapsing_toolbar_layout;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/23.
 * email: weidadajie@163.com
 * 可折叠的toolbar
 */

public class CollapsingToolBarActivity extends MVPBaseActivity<CollapsingToolBarActivity, CollapsingToolBarLayoutPresenterImp> implements CollapsingToolBarLayoutView {
    Activity mActivity;
    @BindView(R.id.iv_collapsing)
    ImageView ivCollapsing;
    @BindView(R.id.tb_collapsing)
    Toolbar tbCollapsing;
    @BindView(R.id.ctp_collapsing)
    CollapsingToolbarLayout ctpCollapsing;
    @BindView(R.id.abl_collapsing)
    AppBarLayout ablCollapsing;
    @BindView(R.id.fab_collapsing)
    FloatingActionButton fabCollapsing;

    @Override
    protected CollapsingToolBarLayoutPresenterImp createPresenter() {
        return new CollapsingToolBarLayoutPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_collapsing_toolbar);
        ButterKnife.bind(this);
        setSupportActionBar(tbCollapsing);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tbCollapsing.setNavigationIcon(R.mipmap.back_write);
        tbCollapsing.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ctpCollapsing.setTitle(getResources().getString(R.string.app_name));
        //设置展开的时候标题显示字体颜色
        ctpCollapsing.setExpandedTitleColor(Color.WHITE);
        //设置折叠的时候标题显示字体颜色
        ctpCollapsing.setCollapsedTitleTextColor(Color.WHITE);
        //设置折叠时候标题对齐位置
        ctpCollapsing.setCollapsedTitleGravity(Gravity.LEFT);

        fabCollapsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"你手贱啊,老是点我",Snackbar.LENGTH_LONG).setAction("我就贱", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mActivity,"来打我啊!!!",Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
    }

}
