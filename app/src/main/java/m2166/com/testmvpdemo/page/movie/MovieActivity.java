package m2166.com.testmvpdemo.page.movie;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;
import m2166.com.testmvpdemo.callback.ICall;
import m2166.com.testmvpdemo.page.movie.adapter.MovieAdapter;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class MovieActivity extends MVPBaseActivity<MovieActivity, MoviePresenterImp> {
    Activity mActivity;
    @BindView(R.id.tb_movie)
    Toolbar tbMovie;
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;
    private MovieAdapter movieAdapter;

    @Override
    protected MoviePresenterImp createPresenter() {
        return new MoviePresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initData() {
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        rvMovie.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0,0,0,20);
            }
        });
        movieAdapter = new MovieAdapter(this);
        rvMovie.setAdapter(movieAdapter);
//        rvMovie.addOnItemTouchListener(new );
        List<SubjectsBean> subjectsBeen = mPresenter.getMovieData(new ICall<List<SubjectsBean>>() {
            @Override
            public void onSuccess(List<SubjectsBean> subjectsBeen) {


                movieAdapter.setList(subjectsBeen);
            }

            @Override
            public void onFail(String failMsg) {
            }
        });

    }

    private void initView() {
        tbMovie.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tbMovie.setTitle("电影列表");

    }
}
