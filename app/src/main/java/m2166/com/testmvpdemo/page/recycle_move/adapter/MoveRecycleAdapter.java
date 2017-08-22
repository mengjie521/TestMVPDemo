package m2166.com.testmvpdemo.page.recycle_move.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.page.recycle_move.ItemTouchHelperAdapter;
import m2166.com.testmvpdemo.page.recycle_move.data.DataBean;

/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

public class MoveRecycleAdapter extends RecyclerView.Adapter<MoveRecycleAdapter.MoveHolder> implements ItemTouchHelperAdapter {
    private Activity mActivity;
    private List<DataBean> listData;

    public MoveRecycleAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public void setDataList(List<DataBean> listData) {
        this.listData = listData;
        notifyDataSetChanged();
    }

    @Override
    public MoveHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, null);
        return new MoveHolder(view);
    }

    @Override
    public void onBindViewHolder(MoveHolder holder, int position) {
        holder.text.setText(listData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return listData.isEmpty() || listData == null ? 0 : listData.size();
    }

    @Override
    public void itemMove(RecyclerView.ViewHolder holder, RecyclerView.ViewHolder target) {
        int fromPosition = holder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        if (fromPosition < listData.size() && toPosition < listData.size()) {
            Collections.swap(listData, fromPosition, toPosition);
        }
        notifyItemMoved(fromPosition, toPosition);
        itemClear(holder);
    }

    @Override
    public void itemRemove(RecyclerView.ViewHolder holder) {
        int adapterPosition = holder.getAdapterPosition();
        listData.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    @Override
    public void itemSelect(RecyclerView.ViewHolder holder) {
        //当拖拽选中时放大选中的view
        holder.itemView.setScaleX(1.2f);
        holder.itemView.setScaleY(1.2f);
    }

    @Override
    public void itemClear(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleX(1.0f);
        holder.itemView.setScaleY(1.0f);
    }


    class MoveHolder extends RecyclerView.ViewHolder {
        TextView text;

        public MoveHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.id_num);
        }
    }
}
