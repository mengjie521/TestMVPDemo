package m2166.com.testmvpdemo.page.movie;

import java.util.List;

import m2166.com.testmvpdemo.callback.ICall;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public interface MoviePresenter {
    List<SubjectsBean> getMovieData(ICall<List<SubjectsBean>> call);
}
