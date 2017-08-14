package m2166.com.testmvpdemo.page.dao;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/10.
 * email: weidadajie@163.com
 */

public class DaoActivity extends MVPBaseActivity<DaoActivity, DaoPresenterImp> implements DaoView {
    Activity mActivity;

    @BindView(R.id.bt_add)
    Button btAdd;
    @BindView(R.id.bt_delete)
    Button btDelete;
    @BindView(R.id.bt_modify)
    Button btModify;
    @BindView(R.id.bt_seek)
    Button btSeek;
    @BindView(R.id.et_user)
    EditText etUser;
    @BindView(R.id.et_pws)
    EditText etPws;
    @BindView(R.id.bt_clear_all)
    Button btClearAll;
    @BindView(R.id.bt_select_all)
    Button btSelectAll;
    @BindView(R.id.rv_recode)
    RecyclerView rvRecode;
    private RecodeAdapter recodeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao);
        mActivity = this;
        ButterKnife.bind(this);
        rvRecode.setLayoutManager(new LinearLayoutManager(mActivity));
        rvRecode.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.set(0,0,20,20);
            }
        });
        recodeAdapter = new RecodeAdapter(mActivity);
        rvRecode.setAdapter(recodeAdapter);
    }

    @Override
    protected DaoPresenterImp createPresenter() {
        return new DaoPresenterImp();
    }

    @OnClick({R.id.bt_add, R.id.bt_delete, R.id.bt_modify, R.id.bt_seek, R.id.bt_clear_all, R.id.bt_select_all})
    public void onViewClick(View view) {
        String user = etUser.getText().toString().trim();
//        Log.e("==userName_onViewClick", "onViewClick: "+user );
        String pws = etPws.getText().toString().trim();
        switch (view.getId()) {
            case R.id.bt_add:
                if (TextUtils.isEmpty(user)) {
                    return;
                }
                if (!TextUtils.isEmpty(pws)) {
                    mPresenter.addMsg(user, pws);
                }
                break;
            case R.id.bt_delete:
                if (TextUtils.isEmpty(user)) {
                    return;
                }
                mPresenter.deleteMsg(user);
                break;
            case R.id.bt_modify:
                if (TextUtils.isEmpty(user)) {
                    return;
                }
                if (TextUtils.isEmpty(pws))
                    Log.e("修改点击", "onViewClick: ");
                mPresenter.notifyMsg(user, pws);
                break;
            case R.id.bt_seek:
                if (TextUtils.isEmpty(user)) {
                    return;
                }
                mPresenter.seekMsg(user);
                break;

            case R.id.bt_clear_all:
                Log.e("====清空点击", "onViewClick: ");
                mPresenter.clearAllMsg();
                break;
            case R.id.bt_select_all:
                List<Users> list = mPresenter.seekAllMsg();
                recodeAdapter.setList(list);
                break;
        }
    }

}
