package m2166.com.testmvpdemo.net;

import java.util.List;

/**
 * author： mengjie on 2017/8/8.
 * email: weidadajie@163.com
 */

public class BannerBean {

    /**
     * status : 1
     * code : success
     * msg : 首页轮播图调取成功
     * content : [{"url":"http://m.2166.com/mobile.php?s=/game/detail/id/200.html","path":"/Uploads/Picture/2017-07-04/595b1817a9876.jpg","id":"200","game_name":"王者传奇(安卓版)"},{"url":"http://m.2166.com/mobile.php?s=/game/detail/id/150.html","path":"/Uploads/Picture/2017-05-18/591cf79bbebf7.jpg","id":"150","game_name":"攻城三国经典版(安卓版)"},{"url":"http://m.2166.com/move.php?s=/Game/detail/id/248.html","path":"/Uploads/Picture/2017-08-04/5983cbe6ec6e0.jpg","id":"248","game_name":"绝世武魂(安卓版)"},{"url":"http://m.2166.com/move.php?s=/Game/detail/id/247.html","path":"/Uploads/Picture/2017-08-04/5983cc1609a88.jpg","id":"247","game_name":"一剑封天(安卓版)"}]
     * total_page : 0
     */

    private int status;
    private String code;
    private String msg;
    private int total_page;
    private List<ContentBean> content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal_page() {
        return total_page;
    }

    public void setTotal_page(int total_page) {
        this.total_page = total_page;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class ContentBean {
        /**
         * url : http://m.2166.com/mobile.php?s=/game/detail/id/200.html
         * path : /Uploads/Picture/2017-07-04/595b1817a9876.jpg
         * id : 200
         * game_name : 王者传奇(安卓版)
         */

        private String url;
        private String path;
        private String id;
        private String game_name;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }
    }
}
