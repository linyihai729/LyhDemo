package calorierecorder.com.fragmentdemo.api;

public class BaseAPI {
    public static final String GANK_URL = "http://gank.io/api/data/福利";

    public static String makeUrl(int count, int current) {
        return GANK_URL + "/" + count + "/" + current;
    }
}
