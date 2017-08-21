package m2166.com.testmvpdemo.page.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/21.
 * email: weidadajie@163.com
 */

public class AlertDialogActivity extends MVPBaseActivity<AlertDialogActivity, AlertDialogPresenterImp> implements AlertDialogView {
    @BindView(R.id.bt_easy)
    Button btEasy;
    @BindView(R.id.bt_easy_list)
    Button btEasyList;
    @BindView(R.id.bt_one_check_box)
    Button btOneCheckBox;
    @BindView(R.id.bt_much_check_box)
    Button btMuchCheckBox;

    Activity mActivity;

    @Override
    protected AlertDialogPresenterImp createPresenter() {
        return new AlertDialogPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        mActivity = this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_easy, R.id.bt_easy_list, R.id.bt_one_check_box, R.id.bt_much_check_box})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_easy:
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(mActivity)
                        .setTitle("我是一只大大鸟")
                        .setMessage("你是大鸟还是小鸟");
                alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mActivity, "确定了", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mActivity, "quxiao了", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.create().show();
                break;
            case R.id.bt_easy_list:
                String[] lists = new String[]{"男孩","女孩"};
                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity)
                        .setTitle("生男生女都一样");
                builder.setItems(lists, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mActivity, "quxiao了"+which, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                break;
            case R.id.bt_one_check_box:
                final String[] language = {"Java语言", "PHP语言", "Android语言", "IOS语言", "C++语言", "C#语言"};
                final String[] select = {""};
                AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                builder1.setTitle("选择你喜欢的语言，只能选一项");
                builder1.setSingleChoiceItems(language, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        select[0] = language[i];
                    }
                });
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(mActivity, "你选了：" + select[0],Toast.LENGTH_SHORT).show();
                    }
                });
                builder1.create().show();
                break;
            case R.id.bt_much_check_box:
                final String[] menu = {"丝瓜面筋", "糖醋鲤鱼", "糖醋排骨", "剁椒鱼头", "清蒸咸鱼", "鱼香肉丝", "清炒上海青", "麻婆豆腐"};
                final boolean[] isCheck = {false, false, false, false, false, false, false, false};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                builder2.setTitle("请选择你的想要的菜");
                builder2.setMultiChoiceItems(menu, isCheck, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        isCheck[i] = b;
                    }
                });
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String select = "";
                        for (int j = 0; j < isCheck.length; j++) {
                            if (isCheck[j]) {
                                select += menu[j];
                            }
                        }
                        Toast.makeText(mActivity,  "你选择的菜有：" + select,Toast.LENGTH_SHORT).show();
                    }
                });
                builder2.create();
                builder2.show();
                break;
        }
    }
}
