package m2166.com.testmvpdemo.page.movie;


import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public interface MovieService {
    @GET ("/v2/movie/top250")
    Observable<MovieSubject> getMovieData(@Query("start") int start, @Query("count")int count);
}
