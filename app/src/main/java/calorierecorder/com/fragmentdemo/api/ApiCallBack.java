package calorierecorder.com.fragmentdemo.api;

public interface ApiCallBack {
    void stringCallBack(String json);
    void error(String errorString);
}
