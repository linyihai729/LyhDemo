package com.example.common2.okgo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.view.Window;

import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.model.Response;
import com.lzy.okgo.request.base.Request;

public class DialogCallBack extends BitmapCallback {

    private ProgressDialog dialog;

    public DialogCallBack(Activity activity) {
        super();
        initDialog(activity);
    }

    private void initDialog(Activity activity) {
        dialog = new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("网络加载中...");
    }

    @Override
    public void onStart(Request<Bitmap, ? extends Request> request) {
        super.onStart(request);
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void onFinish() {
        super.onFinish();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onSuccess(Response<Bitmap> response) {

    }
}
