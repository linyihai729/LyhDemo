package calorierecorder.com.fragmentdemo.api;

import android.util.Log;

import com.example.common2.utils.GsonUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

import calorierecorder.com.fragmentdemo.bean.GirlBean;

public class SimpleRequest {
    private static SimpleRequest instance = null;
    private static ApiCallBack callBack;

    public static synchronized SimpleRequest getInstance(ApiCallBack apiCallBack) {
        if (instance == null) {
            instance = new SimpleRequest();
        }
        callBack = apiCallBack;
        return instance;
    }

    private SimpleRequest() {

    }

    public void getHomeGirl(String url) {
        Log.e("url",url);
        OkGo.<String>get(url).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String body = response.body();
                GirlBean bean = GsonUtil.parse(body, GirlBean.class);
                if (bean != null && !bean.isError()) {
                    if (callBack != null) {
                        callBack.stringCallBack(body);
                    }
                }
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                if (callBack != null) {
                    callBack.error(response.body());
                }
            }
        });
    }
}
