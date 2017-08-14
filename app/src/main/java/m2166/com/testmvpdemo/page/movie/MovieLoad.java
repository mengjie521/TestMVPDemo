package m2166.com.testmvpdemo.page.movie;


import java.util.List;

import m2166.com.testmvpdemo.http.NetFactory;
import m2166.com.testmvpdemo.http.ObjectLoad;
import rx.Observable;
import rx.functions.Func1;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class MovieLoad extends ObjectLoad {
    private MovieService movieService;
    public MovieLoad(){
        movieService = NetFactory.getInstance().create(MovieService.class);
    }

    /**
     * 获取电影列表
     */

    public Observable<List<SubjectsBean>> getMoveData(int start, int count){

        return observe(movieService.getMovieData(start,count)).map(new Func1<MovieSubject, List<SubjectsBean>>() {
            @Override
            public List<SubjectsBean> call(MovieSubject movieSubject) {
                return movieSubject.subjects;
            }
        });
    }
}
