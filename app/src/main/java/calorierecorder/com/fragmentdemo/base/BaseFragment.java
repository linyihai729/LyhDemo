package calorierecorder.com.fragmentdemo.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.common2.dialog.NetProgressDialog;

public abstract class BaseFragment extends IMPFragment {
    private boolean isLoaded = false;
    private boolean isCreated = false;
    private NetProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        initView(view);
        isCreated = true;
//        if (getUserVisibleHint() && !isLoaded) {
//            loadData();
//            isLoaded = true;
//        }
        if (getUserVisibleHint()) {
            loadData();
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isLoaded = false;
        isCreated = false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser && isCreated && !isLoaded) {
//            loadData();
//            isLoaded = true;
//        }
        if (isVisibleToUser && isCreated) {
            loadData();
        }
    }

    /**
     * @return 布局资源id
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化View
     */
    protected abstract void initView(View view);

    /**
     * 加载数据
     */
    protected abstract void loadData();
    public void openProgressDialog(Activity mContext, String msg) {
        progressDialog = new NetProgressDialog.Builder(mContext).setContent(msg).build();
        progressDialog.show();
    }

    public void dismissPorgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
