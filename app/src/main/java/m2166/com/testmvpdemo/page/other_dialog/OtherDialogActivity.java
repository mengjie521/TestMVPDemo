package m2166.com.testmvpdemo.page.other_dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/21.
 * email: weidadajie@163.com
 */

public class OtherDialogActivity extends MVPBaseActivity<OtherDialogActivity, OtherDialogPresenterImp> {
    @BindView(R.id.bt_progress_circle)
    Button btProgressCircle;
    @BindView(R.id.bt_progress_rectangle)
    Button btProgressRectangle;
    @BindView(R.id.bt_data_reminder)
    Button btDataReminder;
    @BindView(R.id.bt_time_choose)
    Button btTimeChoose;
    Activity mActivity;
    private ProgressDialog progressDialog1;

    @Override
    protected OtherDialogPresenterImp createPresenter() {
        return new OtherDialogPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_dialog);
        mActivity = this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_progress_circle, R.id.bt_progress_rectangle, R.id.bt_data_reminder, R.id.bt_time_choose})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_progress_circle:
//                ProgressDialog.show(mActivity, "变帅", "正在变帅中....", true, true);
                final ProgressDialog progressDialog = new ProgressDialog(mActivity);
                progressDialog.setMax(100);
                progressDialog.setMessage("孟杰帅哥变的更帅中...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setIcon(R.mipmap.happy);
                progressDialog.setTitle("变帅");
                progressDialog.setCancelable(true);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setIndeterminate(true);
                progressDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mActivity, "变帅成功", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }, 3000);
                break;
            case R.id.bt_progress_rectangle:
                progressDialog1 = new ProgressDialog(mActivity);
                progressDialog1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                progressDialog1.setIndeterminate(true);
                progressDialog1.setMax(100);
                progressDialog1.setMessage("吉刚变丑中...");
                progressDialog1.setTitle("变丑");
                progressDialog1.setIcon(R.mipmap.no_happy);
                progressDialog1.setCancelable(true);
                progressDialog1.setCanceledOnTouchOutside(false);
                progressDialog1.show();
                handler.sendEmptyMessage(100);
                break;
            case R.id.bt_data_reminder:
                Calendar calendar = Calendar.getInstance();
                new DatePickerDialog(mActivity, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String result = "你选择的是：" + year + "年" + (month + 1) + "月" + dayOfMonth + "日";
                        Toast.makeText(mActivity,result,Toast.LENGTH_LONG).show();
                    }
                },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE)).show();
                break;
            case R.id.bt_time_choose:
                Calendar c = Calendar.getInstance();
                new TimePickerDialog(mActivity, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String result = "你选择的是：" + hourOfDay + "时" + minute + "分" ;
                        Toast.makeText(mActivity,result,Toast.LENGTH_LONG).show();
                    }
                }, c.get(Calendar.HOUR), c.get(Calendar.SECOND),true).show();
                break;
        }
    }

    int progressMax = 100;
    int progressInit = 1;
    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            progressDialog1.setProgress(progressInit);
            progressInit ++;
            if (progressInit > 100) {
                progressDialog1.dismiss();
            } else {
                handler.sendEmptyMessageDelayed(100, 50);
            }

        }
    };
}
