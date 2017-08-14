package m2166.com.testmvpdemo.page.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import m2166.com.testmvpdemo.page.movie.SubjectsBean;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {
    private Context context;
    private List<SubjectsBean> list = new ArrayList<>();

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<SubjectsBean> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, null);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        for (int i = 0; i < list.size(); i++) {
            Log.e("===", "onSuccess: "+list.get(i).images );
        }
        holder.movieTitle.setText(list.get(position).title);
        holder.movieSubTitle.setText(list.get(position).original_title);
        holder.movieTime.setText(list.get(position).year);
        Glide.with(context).load(list.get(position).images.small).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() && list == null ? 0 : list.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_image)
        ImageView movieImage;
        @BindView(R.id.movie_title)
        TextView movieTitle;
        @BindView(R.id.movie_sub_title)
        TextView movieSubTitle;
        @BindView(R.id.movie_time)
        TextView movieTime;

        public MovieHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
