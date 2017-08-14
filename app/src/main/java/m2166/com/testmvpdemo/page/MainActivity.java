package m2166.com.testmvpdemo.page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.net.BannerBean;
import m2166.com.testmvpdemo.net.BannerLoad;
import m2166.com.testmvpdemo.net.ContentBean;
import m2166.com.testmvpdemo.net.DataServer;
import m2166.com.testmvpdemo.page.butterknife.ButterknifeActivity;
import m2166.com.testmvpdemo.page.dao.DaoActivity;
import m2166.com.testmvpdemo.page.login.MvpActivity;
import m2166.com.testmvpdemo.page.pay.PayActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private Button bu;
    private Button bu_test;
    private Button bu_test1;
    private Button bu_net;
    private Button bt_http;
    private TextView tv_est;
    private Button bt_dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bu = (Button) findViewById(R.id.button);
        tv_est = (TextView) findViewById(R.id.tv_test);
        bu_test = (Button) findViewById(R.id.bt_test);
        bu_test1 = (Button) findViewById(R.id.bt_test1);
        bu_net = (Button) findViewById(R.id.bt_net);
        bu_net.setOnClickListener(mClicklisteber);
        bu_test.setOnClickListener(mClicklisteber);
        bu.setOnClickListener(mClicklisteber);
        bu_test1.setOnClickListener(mClicklisteber);
        bt_http = (Button) findViewById(R.id.bt_http);
        bt_http.setOnClickListener(mClicklisteber);
        bt_dao = (Button) findViewById(R.id.bt_dao);
        bt_dao.setOnClickListener(mClicklisteber);
    }

    private View.OnClickListener mClicklisteber = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.button:
                    startActivity(new Intent(MainActivity.this, MvpActivity.class));
                    break;
                case R.id.bt_test:
                    startActivity(new Intent(MainActivity.this, PayActivity.class));
                    break;
                case R.id.bt_test1:
                    startActivity(new Intent(MainActivity.this, ButterknifeActivity.class));
                    break;
                case R.id.bt_net:
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://www.2166.com")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

                    DataServer dataServer = retrofit.create(DataServer.class);
                    Call<BannerBean> call = dataServer.call();
                    call.enqueue(new Callback<BannerBean>() {
                        @Override
                        public void onResponse(Call<BannerBean> call, Response<BannerBean> response) {

                            String msg = response.body().getMsg();
                            tv_est.setText(msg);
                            Log.e("++++++++++", "onResponse: " + msg);
                        }

                        @Override
                        public void onFailure(Call<BannerBean> call, Throwable t) {

                        }
                    });
                    break;
                case R.id.bt_http:
                    new BannerLoad().getBannerList().subscribe(new Action1<List<ContentBean>>() {
                        @Override
                        public void call(List<ContentBean> contentBeen) {
                            String game_name = contentBeen.get(1).game_name;
                            Log.e("==", "call: " + game_name);
                            tv_est.setText(game_name);
                        }
                    });
//                    new CompositeSubscription().add(subscribe);
//                    BannerService bannerService = NetFactory.getInstance().create(BannerService.class);
////                    Subscriber<BannerService> mySubscriber = new Subscriber<BannerService>().
//                    bannerService.getData()
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Subscriber<BannerSubject>() {
//                                @Override
//                                public void onCompleted() {
//
//                                }
//
//                                @Override
//                                public void onError(Throwable e) {
//
//                                }
//
//                                @Override
//                                public void onNext(BannerSubject bannerSubject) {
//                                    Log.e("==", "onNext: "+bannerSubject.toString() );
//                                }
//                            });
                    break;
                case R.id.bt_dao:
                    startActivity(new Intent(MainActivity.this, DaoActivity.class));
                    break;
            }
        }
    };
}