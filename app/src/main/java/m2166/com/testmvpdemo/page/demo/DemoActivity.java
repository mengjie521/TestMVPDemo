package m2166.com.testmvpdemo.page.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/28.
 * email: weidadajie@163.com
 */

public class DemoActivity extends MVPBaseActivity<DemoActivity, DemoPresenterImp> implements DemoView {


    @Override
    protected DemoPresenterImp createPresenter() {
        return new DemoPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        if (null != savedInstanceState) {
            int IntTest = savedInstanceState.getInt("IntTest");
            String StrTest = savedInstanceState.getString("StrTest");
            Log.e("======", "onCreate get the savedInstanceState+IntTest=" + IntTest + "+StrTest=" + StrTest);
        }
        ButterKnife.bind(this);
        addFragment(R.id.fl_demo, new FragmentDemo());
        Log.e("========", "onCreate: " + savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save away the original text, so we still have it if the activity
        // needs to be killed while paused.
        savedInstanceState.putInt("IntTest", 0);
        savedInstanceState.putString("StrTest", "savedInstanceState test");
        super.onSaveInstanceState(savedInstanceState);
        Log.e("======", "onSaveInstanceState");
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int IntTest = savedInstanceState.getInt("IntTest");
        String StrTest = savedInstanceState.getString("StrTest");
        Log.e("=======", "onRestoreInstanceState+IntTest=" + IntTest + "+StrTest=" + StrTest);
    }

    @Override
    public void getData(String msg) {

    }
}
