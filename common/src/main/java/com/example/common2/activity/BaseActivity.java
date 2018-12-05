
package com.example.common2.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.common2.R;
import com.example.common2.application.AppManager;
import com.example.common2.dialog.NetProgressDialog;
import com.example.common2.utils.StackAct;
import com.example.common2.utils.StatusBarCompat;

public abstract class BaseActivity extends AppCompatActivity {

    private NetProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setWindow();
        setContentView(getLayoutId());
    }

    public abstract int getLayoutId();

    private void setWindow() {
        //AppManager.getAppManager().addActivity(this);
        StackAct.instance().addActivity(this);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //取消状态栏
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SetStatusBarColor();
    }

    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor() {
        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.hx_selected_color));
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar() {
        StatusBarCompat.translucentStatusBar(this);
    }

    public void openProgressDialog(Activity mContext, String msg) {
        progressDialog = new NetProgressDialog.Builder(mContext).setContent(msg).build();
        progressDialog.show();
    }

    public void dismissPorgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackAct.instance().finishActivity(this);
    }
}
