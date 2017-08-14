package m2166.com.testmvpdemo.page.dao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import m2166.com.testmvpdemo.R;

/**
 * author： mengjie on 2017/8/10.
 * email: weidadajie@163.com
 */

public class RecodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Users> list = new ArrayList<>();

    public void setList(List<Users> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public RecodeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recode, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).tv_userName.setText(list.get(position).getUserName());
            ((MyViewHolder) holder).tv_password.setText(list.get(position).getPassword());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_userName;
        private final TextView tv_password;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_userName = (TextView) itemView.findViewById(R.id.tv_userName);
            tv_password = (TextView) itemView.findViewById(R.id.tv_password);
        }
    }
}
