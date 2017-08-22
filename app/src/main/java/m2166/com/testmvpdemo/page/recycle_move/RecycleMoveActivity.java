package m2166.com.testmvpdemo.page.recycle_move;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;
import m2166.com.testmvpdemo.page.recycle_move.adapter.MoveRecycleAdapter;
import m2166.com.testmvpdemo.page.recycle_move.data.DataBean;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 * 实现长按recycleView item 实现条目变换的效果
 */

public class RecycleMoveActivity extends MVPBaseActivity<RecycleMoveActivity, RecycleMovePresenterImp> implements RecycleMoveView {
    @BindView(R.id.recycle_move)
    RecyclerView recycleMove;
    Activity mActivity;
    @BindView(R.id.bt_choose)
    Button btChoose;
    int position = -1;
    private MoveRecycleAdapter moveRecycleAdapter;

    @Override
    protected RecycleMovePresenterImp createPresenter() {
        return new RecycleMovePresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_move);
        mActivity = this;
        ButterKnife.bind(this);
        recycleMove.setLayoutManager(new LinearLayoutManager(mActivity));
        moveRecycleAdapter = new MoveRecycleAdapter(mActivity);
        recycleMove.setAdapter(moveRecycleAdapter);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(moveRecycleAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recycleMove);
        mPresenter.getNetData();
    }


    @OnClick(R.id.bt_choose)
    public void onViewClicked() {
        showDialog();
    }

    private void showDialog() {
        String[] types = new String[]{"Vertical", "Horizontal", "Grid", "Staggered"};
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("选择类型")
                .setSingleChoiceItems(types, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position = which;
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (position == 0) {
                            recycleMove.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false));
                        } else if (position == 1) {
                            recycleMove.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
                        } else if (position == 2) {
                            recycleMove.setLayoutManager(new GridLayoutManager(mActivity, 3));
                        } else if (position == 3) {
                            recycleMove.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
                        } else {
                            Toast toast = Toast.makeText(mActivity, "请选择类型", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER,0,0);
                            toast.show();
                        }
                    }
                })
                .show();

    }

    @Override
    public void success(List<DataBean> list) {
        moveRecycleAdapter.setDataList(list);
    }
}
