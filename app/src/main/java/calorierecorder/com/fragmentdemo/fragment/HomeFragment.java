package calorierecorder.com.fragmentdemo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common2.utils.GsonUtil;
import com.example.common2.utils.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import calorierecorder.com.fragmentdemo.R;
import calorierecorder.com.fragmentdemo.adapter.HomeGirlAdapter;
import calorierecorder.com.fragmentdemo.api.BaseAPI;
import calorierecorder.com.fragmentdemo.api.SimpleRequest;
import calorierecorder.com.fragmentdemo.base.BaseFragment;
import calorierecorder.com.fragmentdemo.bean.GirlBean;

public class HomeFragment extends BaseFragment {

    private String content;
    private RecyclerView rlv_home;
    private List<GirlBean.ResultsBean> mList = new ArrayList<>();
    private HomeGirlAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("live", "homeFragment++++++onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            content = bundle.getString("content", null);
        }
        Log.e("live", "homeFragment++++++onCreate");
        openProgressDialog(getActivity(),"正在加载中...");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("live", "homeFragment++++++onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("live", "homeFragment++++++onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("live", "homeFragment++++++onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("live", "homeFragment++++++onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("live", "homeFragment++++++onStop");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("live", "homeFragment++++++onDetach");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("live", "homeFragment++++++onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("live", "homeFragment++++++onDestroyView");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        rlv_home = view.findViewById(R.id.rlv_home);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rlv_home.setLayoutManager(manager);
        SpacesItemDecoration decoration = new SpacesItemDecoration(10);
        rlv_home.addItemDecoration(decoration);
        adapter = new HomeGirlAdapter(mList, getContext());
        rlv_home.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //initView(view);
    }



    @Override
    protected void loadData() {
        Toast.makeText(getActivity(), "第" + curren++ + "请求", Toast.LENGTH_SHORT).show();
        SimpleRequest.getInstance(this).getHomeGirl(BaseAPI.makeUrl(20, 2));

    }


    private int curren = 1;

    @Override
    public void stringCallBack(String json) {
        super.stringCallBack(json);
        mList.clear();
        Log.e("1111111", "1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        if (!TextUtils.isEmpty(json)) {
            GirlBean bean = GsonUtil.parse(json, GirlBean.class);
            List<GirlBean.ResultsBean> results = bean.getResults();
            mList.addAll(results);
            adapter.notifyDataSetChanged();
            dismissPorgressDialog();
        }
    }

    @Override
    public void error(String errorString) {
        super.error(errorString);
        Toast.makeText(getActivity(), "错误:"+errorString, Toast.LENGTH_SHORT).show();
        dismissPorgressDialog();
    }
}
