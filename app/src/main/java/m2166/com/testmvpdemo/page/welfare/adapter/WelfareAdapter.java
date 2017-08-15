package m2166.com.testmvpdemo.page.welfare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.page.welfare.net.ResultsBean;

/**
 * author： mengjie on 2017/8/15.
 * email: weidadajie@163.com
 */

public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.WelfareViewHolder> {

    private Context context;
    List<ResultsBean> listData = new ArrayList<>();


    public WelfareAdapter(Context context) {
        this.context = context;
    }

    public void setListData(List<ResultsBean> listData) {
        this.listData.clear();
        this.listData.addAll(listData);
        notifyDataSetChanged();
    }

    @Override
    public WelfareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_welfare, null);
        return new WelfareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WelfareViewHolder holder, int position) {
        Glide.with(context).load(listData.get(position).url).into(holder.gankIamge);
        holder.author.setText(listData.get(position).who);
        holder.desc.setText(listData.get(position).desc);
    }

    @Override
    public int getItemCount() {
        return listData == null ? 0 : listData.size();
    }

    class WelfareViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.gank_iamge)
        ImageView gankIamge;
        @BindView(R.id.desc)
        TextView desc;
        @BindView(R.id.author)
        TextView author;

        public WelfareViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
