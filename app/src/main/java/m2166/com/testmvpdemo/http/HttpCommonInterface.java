package m2166.com.testmvpdemo.http;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author： mengjie on 2017/8/9.
 * email: weidadajie@163.com
 */

public class HttpCommonInterface implements Interceptor {
    private Map<String, String> mHeadParams = new HashMap<>();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.e("==添加公共参数", "intercept: ");
        Request oldRequest = chain.request();
        Request.Builder requestBuilder = oldRequest.newBuilder();
        requestBuilder.method(oldRequest.method(), oldRequest.body());
        if (mHeadParams.size() > 0) {
            for (Map.Entry<String, String> enter : mHeadParams.entrySet()) {
                requestBuilder.header(enter.getKey(), enter.getValue());
            }
        }

        Request newBuild = requestBuilder.build();
        return chain.proceed(newBuild);
    }

    public static class Builder {
        HttpCommonInterface mHttpCommonInterface;

        public Builder() {
            mHttpCommonInterface = new HttpCommonInterface();
        }

        public Builder addParams(String key, String value) {
            mHttpCommonInterface.mHeadParams.put(key, value);
            return this;
        }

        public Builder addParams(String key, int value) {
            return addParams(key, String.valueOf(value));
        }

        public Builder addParams(String key, double value) {
            return addParams(key, String.valueOf(value));
        }

        public Builder addParams(String key, float value) {
            return addParams(key, String.valueOf(value));
        }

        public HttpCommonInterface builder() {
            return mHttpCommonInterface;
        }
    }
}
