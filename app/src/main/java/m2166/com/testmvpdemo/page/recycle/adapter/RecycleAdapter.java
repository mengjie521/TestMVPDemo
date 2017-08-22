package m2166.com.testmvpdemo.page.recycle.adapter;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.page.recycle.data.Falls;
import m2166.com.testmvpdemo.page.recycle.data.Number;
/**
 * author： mengjie on 2017/8/22.
 * email: weidadajie@163.com
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    List<Number> list = new ArrayList<>();
    List<Falls> listFalls = new ArrayList<>();
    Activity mActivity;
    public RecycleAdapter() {
    }
    public RecycleAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, null);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle, null);
        return new MyViewHolder(view);
    }

    public void setDate(List<Number> list){
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void addDate(int position){
        this.list.add(position,new Number("addData"));
        notifyItemInserted(position);
    }
    public void removeDate(int position){
        this.list.remove(position);
        notifyItemRemoved(position);
    }

    public void setFallsData(List<Falls> list){
        this.listFalls.clear();
        this.listFalls.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.e("=======", "onBindViewHolder: "+position );
        if(list.size() != 0) {
            holder.text.setText(list.get(position).getNum());
        }
        if(listFalls.size() != 0) {
            LayoutParams lp = holder.text.getLayoutParams();
            lp.height = listFalls.get(position).getHeight();

            holder.text.setLayoutParams(lp);
            holder.text.setText(listFalls.get(position).getData());
        }

    }

    @Override
    public int getItemCount() {
        return  list.size() == 0 ? listFalls.size() : list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MyViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.id_num);
            text.setBackgroundColor(ActivityCompat.getColor(mActivity, R.color.colorPrimary));
        }
    }
}
