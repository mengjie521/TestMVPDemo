package m2166.com.testmvpdemo.page.movie;

import java.util.List;

import m2166.com.testmvpdemo.base.BasePresenter;
import m2166.com.testmvpdemo.callback.ICall;
import rx.Observable;
import rx.Observer;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class MoviePresenterImp extends BasePresenter<MovieActivity> implements MoviePresenter {
    MovieActivity movieActivity;
    List<SubjectsBean> movieList;

    @Override
    public List<SubjectsBean> getMovieData(final ICall<List<SubjectsBean>> call) {
        movieActivity = getView();
        Observable<List<SubjectsBean>> moveData = new MovieLoad().getMoveData(0, 30);
        moveData.subscribe(new Observer<List<SubjectsBean>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                call.onFail(e.getLocalizedMessage());
            }

            @Override
            public void onNext(List<SubjectsBean> subjectsBeen) {
                call.onSuccess(subjectsBeen);
            }
        });
//        moveData.subscribe(new Action1<List<SubjectsBean>>() {
//            @Override
//            public void call(List<SubjectsBean> movies) {
//                movieList = movies;
//                Log.e("=======", "call: ");
//                if (movies != null && movies.size() > 0) {
//                    for (int i = 0; i < movies.size(); i++) {
//                        String title = movies.get(i).title;
//                        Log.e("=====", "call: " + title);
//                    }
//                }else {
//                    Log.e("======size", "call: " + 0 );
//                }
//
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                Log.e("======", "error message:" + throwable.getMessage());
//
//
//            }
//        });
        return movieList;
    }
}
