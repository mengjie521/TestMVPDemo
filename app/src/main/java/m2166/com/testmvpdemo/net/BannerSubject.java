package m2166.com.testmvpdemo.net;

import java.util.List;

/**
 * author： mengjie on 2017/8/9.
 * email: weidadajie@163.com
 */

public class BannerSubject {
    public int status;
    public String code;
    public String msg;
    public int total_page;
    public List<ContentBean> content;

    @Override
    public String toString() {
        return "BannerSubject{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", total_page=" + total_page +
                ", content=" + content +
                '}';
    }
}
