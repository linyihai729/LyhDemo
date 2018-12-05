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

public class MoreFragment extends BaseFragment {

    private String content;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("live", "MoreFragment++++++onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle= getArguments();
        if (bundle!=null){
            content = bundle.getString("content", null);
        }
        Log.e("live", "MoreFragment++++++onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view=inflater.inflate(R.layout.fragment_home,container,false);
        Log.e("live", "MoreFragment++++++onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initView(view);
    }


    private int curren=1;
    @Override
    protected void loadData() {
        Toast.makeText(getActivity(), "More"+"第" + curren++ + "请求", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("live", "MoreFragment++++++onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("live", "MoreFragment++++++onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("live", "MoreFragment++++++onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("live", "MoreFragment++++++onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("live", "MoreFragment++++++onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("live", "MoreFragment++++++onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("live", "MoreFragment++++++onDestroyView");
    }

    @Override
    protected int getLayoutResId() {
        return  R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

    }
}
