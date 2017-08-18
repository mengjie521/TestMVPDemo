package m2166.com.testmvpdemo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * author： mengjie on 2017/8/17.
 * email: weidadajie@163.com
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context.getApplicationContext())
                .load(path)
                .thumbnail(0.1f)
                .into(imageView);
    }
}
