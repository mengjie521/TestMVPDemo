package m2166.com.testmvpdemo.page.movie;

/**
 * author： mengjie on 2017/8/14.
 * email: weidadajie@163.com
 */

public class SubjectsBean {
    public Rate rating;
    public String title;
    public String collect_count;
    public String original_title;
    public String subtype;
    public String year;
    public MovieImage images;

    public static class Rate{
        public int max;
        public float average;
        public String stars;
        public int min;
    }

    public static class MovieImage{
        public String small;
        public String large;
        public String medium;
    }
}
