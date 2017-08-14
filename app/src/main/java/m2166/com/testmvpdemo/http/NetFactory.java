package m2166.com.testmvpdemo.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author： mengjie on 2017/8/9.
 * email: weidadajie@163.com
 */

public class NetFactory {
    private static final int DEFAULT_TIME_OUT = 5;
    private static final int DEFAULT_READ_OUT = 10;
    private static final int DEFAULT_WRITE_OUT = 10;
    private static volatile NetFactory netFactory;
    private  Retrofit mRetrofit;

    public static NetFactory getInstance(){
        if (netFactory == null) {
            synchronized (NetFactory.class) {
                if (netFactory == null) {
                    netFactory = new NetFactory();
                }
            }
        }
        return netFactory;
    }

    public NetFactory() {
        OkHttpClient.Builder builder= new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_READ_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_WRITE_OUT, TimeUnit.SECONDS);

        //设置必传参数,每个接口都有的必传参数
        HttpCommonInterface httpCommonInterface = new HttpCommonInterface.Builder()
                .addParams("account", 123456)
                .addParams("pws",1111111)
                .builder();

        builder.addInterceptor(httpCommonInterface);

        //创建retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("http://www.2166.com")
                .build();
    }

    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
