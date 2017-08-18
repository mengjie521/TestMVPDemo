package m2166.com.testmvpdemo.page.InnerView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;
import m2166.com.testmvpdemo.utils.Bitmap2DrawableUtils;
import m2166.com.testmvpdemo.utils.BlurBitmapUtil;
import m2166.com.testmvpdemo.utils.GlideImageLoader;
import m2166.com.testmvpdemo.view.ObserverScrollView;

/**
 * author： mengjie on 2017/8/17.
 * email: weidadajie@163.com
 */

public class InnerViewPagerActivity extends MVPBaseActivity<InnerViewPagerActivity, InnerPagerPresenterImp> implements BannerView, ViewTreeObserver.OnGlobalLayoutListener {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.sv)
    ObserverScrollView sv;

    private List<String> bannerPath;
    Activity mActivity;
    private ViewTreeObserver viewTreeObserver;
    private int height;
    private Bitmap[] bannerBitmap;
    Bitmap blurBitmap;
    private BitmapDrawable titleImg;

    @Override
    protected InnerPagerPresenterImp createPresenter() {
        return new InnerPagerPresenterImp();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_viewpager);
        ButterKnife.bind(this);
        mActivity = this;
        viewTreeObserver = sv.getViewTreeObserver();
        viewTreeObserver.addOnGlobalLayoutListener(this);
        mPresenter.getBannerData();
        banner.setImageLoader(new GlideImageLoader());
        bannerPath = new ArrayList<>();

    }

    @Override
    public void onSuccess(final List<ContentBean> contentBeen) {
        for (int i = 0; i < contentBeen.size(); i++) {
            bannerPath.add("http://www1.2166.com" + contentBeen.get(i).path);
        }
        banner.setImages(bannerPath);
        banner.start();
        banner.onPageSelected(1);
        bannerBitmap = new Bitmap[10];

        banner.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(final int position) {
                super.onPageSelected(position);
                Log.e("======", "onPageSelected: " + position);
//                Glide.with(mActivity).load()
                Glide.with(mActivity).load("http://www1.2166.com" + contentBeen.get(Math.abs(position - 1) % 4).path)
                        .thumbnail(0.1f)
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(final Drawable resource, Transition<? super Drawable> transition) {
                                if (!changeToolbarFlag) {
                                    new Thread(new Runnable() {
                                        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
                                        @Override
                                        public void run() {
                                            blurBitmap = bannerBitmap[position];
                                            if (blurBitmap == null) {
                                                blurBitmap = BlurBitmapUtil.blurBitmap(mActivity, Bitmap2DrawableUtils.drawableToBitmap(resource), 25f);
                                                bannerBitmap[position] = blurBitmap;
                                            }
                                            titleImg = new BitmapDrawable(blurBitmap);
                                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Log.e("===", "run: " + resource);
                                                    fl.setBackground(titleImg);
                                                }
                                            });
                                        }
                                    }).start();
                                }

                            }
                        });
            }
        });
    }

    @Override
    public void onFail(String errorMag) {
        Toast.makeText(mActivity, "网络异常:" + errorMag, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        banner.startAutoPlay();
    }

    private boolean changeToolbarFlag = false;

    @Override
    public void onGlobalLayout() {
        height = banner.getHeight();
        sv.setScrollViewListener(new ObserverScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObserverScrollView observerScrollView, int l, int t, int oldl, int oldt) {
                if (t < height / 3) {
                    changeToolbarFlag = false;
                } else if (t > 0 && t < height) {
                    changeToolbarFlag = true;
                    float present = (float) t / height;
                    float apsch = (present * 100);
                    fl.setBackgroundColor(Color.argb((int) apsch, 253, 150, 72));
                    Log.e("======", "onScrollChanged: " + apsch + "==" + t + "++" + oldl + "++" + oldt);
                } else {
                    changeToolbarFlag = true;
                    fl.setBackgroundColor(Color.argb(255, 253, 150, 72));
                }
//
            }
        });
    }
}
