package m2166.com.testmvpdemo.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public abstract class MVPBaseFragment<V,T extends BasePresenter<V>> extends Fragment {
    public T mPresenter;
    protected Activity attachActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        attachActivity = (Activity) context;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
//        mPresenter.detachView();
        super.onDestroy();
    }
    protected boolean isVisible;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible(){
        lazyLoad();
    }
    protected void lazyLoad(){}
    protected void onInvisible(){}
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
    protected abstract T createPresenter();

}
