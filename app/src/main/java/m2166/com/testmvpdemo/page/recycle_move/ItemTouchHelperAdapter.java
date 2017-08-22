package m2166.com.testmvpdemo.page.recycle_move;

import android.support.v7.widget.RecyclerView;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

public interface ItemTouchHelperAdapter {
    void itemMove(RecyclerView.ViewHolder holder,RecyclerView.ViewHolder target);
    void itemRemove(RecyclerView.ViewHolder holder);
    void itemSelect(RecyclerView.ViewHolder holder);
    void itemClear(RecyclerView.ViewHolder holder);
}
