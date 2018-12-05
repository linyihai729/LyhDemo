package calorierecorder.com.fragmentdemo.base;

import android.support.v4.app.Fragment;

import calorierecorder.com.fragmentdemo.api.ApiCallBack;

public class IMPFragment extends Fragment implements ApiCallBack {
    @Override
    public void stringCallBack(String json) {

    }

    @Override
    public void error(String errorString) {

    }
}
