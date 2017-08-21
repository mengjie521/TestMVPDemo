package m2166.com.testmvpdemo.page.auto;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;

/**
 * author： mengjie on 2017/8/21.
 * email: weidadajie@163.com
 */

public class TextViewActivity extends MVPBaseActivity<TextViewActivity, TextViewPresenterImp> {
    @BindView(R.id.tv_ac)
    AutoCompleteTextView tvAc;
    @BindView(R.id.tv_mac)
    MultiAutoCompleteTextView tvMac;
    private String[] content = {"a", "aA", "abc", "abcd", "abcde", "acdE", "acdef"};
    @Override
    protected TextViewPresenterImp createPresenter() {
        return new TextViewPresenterImp();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        setContentView(R.layout.activity_textview);
        ButterKnife.bind(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(TextViewActivity.this,android.R.layout.simple_list_item_1,content);
        tvAc.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(TextViewActivity.this,android.R.layout.simple_dropdown_item_1line,content);
        tvMac.setAdapter(arrayAdapter1);
    }
}
