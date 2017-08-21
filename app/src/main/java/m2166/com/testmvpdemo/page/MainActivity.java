package m2166.com.testmvpdemo.page;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.net.BannerBean;
import m2166.com.testmvpdemo.net.BannerLoad;
import m2166.com.testmvpdemo.net.ContentBean;
import m2166.com.testmvpdemo.net.DataServer;
import m2166.com.testmvpdemo.page.InnerView.InnerViewPagerActivity;
import m2166.com.testmvpdemo.page.butterknife.ButterknifeActivity;
import m2166.com.testmvpdemo.page.dao.DaoActivity;
import m2166.com.testmvpdemo.page.eventbus.EventFirstActivity;
import m2166.com.testmvpdemo.page.login.MvpActivity;
import m2166.com.testmvpdemo.page.movie.MovieActivity;
import m2166.com.testmvpdemo.page.pay.PayActivity;
import m2166.com.testmvpdemo.page.welfare.WelfareActivity;
import m2166.com.testmvpdemo.test.ServerDemo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.functions.Action1;

import static m2166.com.testmvpdemo.R.id.bt_testserver;

public class MainActivity extends AppCompatActivity {

    private Button bu;
    private Button bu_test;
    private Button bu_test1;
    private Button bu_net;
    private Button bt_http;
    private TextView tv_est;
    private Button bt_dao;
    private Button bt_event_bus;
    private Button bt_movie;
    private Button bt_welfare;
    private Button test;
    private Button bt_banner;
    private Button bt_notifiication;

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
        test = (Button) findViewById(bt_testserver);
        test.setOnClickListener(mClicklisteber);
        bt_event_bus = (Button) findViewById(R.id.bt_event_bus);
        bt_event_bus.setOnClickListener(mClicklisteber);

        bt_movie = (Button) findViewById(R.id.bt_movie);
        bt_movie.setOnClickListener(mClicklisteber);
        bt_welfare = (Button) findViewById(R.id.bt_welfare);
        bt_welfare.setOnClickListener(mClicklisteber);
        bt_banner = (Button) findViewById(R.id.bt_viewpager);
        bt_banner.setOnClickListener(mClicklisteber);

        bt_notifiication = (Button) findViewById(R.id.bt_notification);
        bt_notifiication.setOnClickListener(mClicklisteber);
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
//                    InnerService bannerService = NetFactory.getInstance().create(InnerService.class);
////                    Subscriber<InnerService> mySubscriber = new Subscriber<InnerService>().
//                    bannerService.getData()
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(new Subscriber<InnerSubject>() {
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
//                                public void onNext(InnerSubject bannerSubject) {
//                                    Log.e("==", "onNext: "+bannerSubject.toString() );
//                                }
//                            });
                    break;
                case R.id.bt_dao:
                    startActivity(new Intent(MainActivity.this, DaoActivity.class));
                    break;

                case R.id.bt_event_bus:
                    startActivity(new Intent(MainActivity.this,EventFirstActivity.class));
                    break;

                case R.id.bt_movie:
                    startActivity(new Intent(MainActivity.this,MovieActivity.class));
                    break;
                case R.id.bt_welfare:
                    startActivity(new Intent(MainActivity.this,WelfareActivity.class));
                    break;

                case bt_testserver:
                    Map<String, String> map = new HashMap<>();
                    /**
                     * 这个是把数组中的参数拼接成字符串并把数组中的值（value）进行urlencode直接和appsecret拼接之后的字符串
                     $strquery = channel_id=2&channel_order_number=PF_20170814120146p8fe
                     &cp_order_id=1502682753091735233&currency=1
                     &extension=350004%7C%3A%7C15002%7C%3A%7C%E9%A9%AC%E6%96%AF%E5%8D%A1%C2%B7%E4%BD%A9%E7%89%B9%7C%3A%7C236142
                     &game_id=2&pay_amount=6&pay_status=2&pay_time=1502683407
                     &product_name=1200%E9%92%BB%E7%9F%B3&server_id=15002
                     &user_account=2132902333.2166
                     &user_id=33261b2801a636df54f4b4d99b6313f02b

                     */
                    map.put("channel_id", "2");
                    map.put("channel_order_number", "PF_20170814120146p8fe");
                    map.put("cp_order_id", "1502682753091735233");
                    map.put("currency", "1");
                    map.put("extension", "350004%7C%3A%7C15002%7C%3A%7C%E9%A9%AC%E6%96%AF%E5%8D%A1%C2%B7%E4%BD%A9%E7%89%B9%7C%3A%7C236142");
                    map.put("game_id", "2");
                    map.put("pay_amount", "6");
                    map.put("pay_status", "2");
                    map.put("pay_time", "1502683407");
                    map.put("product_name", "1200%E9%92%BB%E7%9F%B3");
                    map.put("server_id", "15002");
                    map.put("user_account", "2132902333.2166");
                    map.put("user_id", "33261b2801a636df54f4b4d99b6313f02b");
                    String sign = new ServerDemo().getSign(map, "261b2801a636df54f4b4d99b6313f02b");
                    Log.e("=====sign", "onClick: "+sign );
                    break;

                case R.id.bt_viewpager:
                    startActivity(new Intent(MainActivity.this, InnerViewPagerActivity.class));
                    break;

                case R.id.bt_notification:
                    Intent intent = new Intent(MainActivity.this,PayActivity.class);
                    PendingIntent p = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);
                    NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(NOTIFICATION_SERVICE);
                    Notification.Builder notification = new Notification.Builder(MainActivity.this);
                    notification.setSmallIcon(R.mipmap.navigation_back_white,1000);
                    notification.setContentTitle("我是消息");
                    notification.setContentText("我是很多很多很多很多很多内容啊........");
                    notification.setWhen(System.currentTimeMillis());
                    notification.setTicker("接受一条xiaoxi");
                    notification.setAutoCancel(true);
                    notification.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE);
                    notification.setContentIntent(p);
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        Notification build = notification.build();

                        notificationManager.notify(0,build);
                    }
                    break;

            }
        }
    };
}