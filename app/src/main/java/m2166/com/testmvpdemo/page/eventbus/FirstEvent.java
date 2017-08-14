package m2166.com.testmvpdemo.page.eventbus;

import android.util.Log;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

class FirstEvent {
    private String msg;
    public FirstEvent(String msg) {
        Log.e("==", "FirstEvent: "+ msg );
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
