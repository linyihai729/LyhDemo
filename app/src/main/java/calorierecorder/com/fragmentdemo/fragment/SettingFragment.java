package calorierecorder.com.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import calorierecorder.com.fragmentdemo.R;
import calorierecorder.com.fragmentdemo.base.BaseFragment;

public class SettingFragment extends BaseFragment {

    private String content;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("live", "settingFragment++++++onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            content = bundle.getString("content", null);
        }
        Log.e("live", "settingFragment++++++onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_home, container, false);
        Log.e("live", "settingFragment++++++onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initView(view);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.e("live", "settingFragment++++++onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("live", "settingFragment++++++onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("live", "settingFragment++++++onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("live", "settingFragment++++++onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("live", "settingFragment++++++onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("live", "settingFragment++++++onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("live", "settingFragment++++++onDestroyView");
    }

    @Override
    protected int getLayoutResId() {
        return  R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
    private int curren=1;
    @Override
    protected void loadData() {
        Toast.makeText(getActivity(), "setting"+"第" + curren++ + "请求", Toast.LENGTH_SHORT).show();
    }
}
