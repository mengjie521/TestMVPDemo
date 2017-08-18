package m2166.com.testmvpdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * author： mengjie on 2017/8/18.
 * email: weidadajie@163.com
 */

public class ObserverScrollView extends ScrollView {
    public ObserverScrollView(Context context) {
        super(context);
    }


    public ObserverScrollView(Context context, AttributeSet attrs,
                             int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObserverScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    ScrollViewListener scrollViewListener = null;

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(scrollViewListener != null){
            scrollViewListener.onScrollChanged(this,l, t, oldl, oldt);
        }

    }


    public void setScrollViewListener(ScrollViewListener scrollViewListener) {
        this.scrollViewListener = scrollViewListener;
    }

    public interface ScrollViewListener {
        void onScrollChanged(ObserverScrollView observerScrollView, int l, int t, int oldl, int oldt);
    }
}
