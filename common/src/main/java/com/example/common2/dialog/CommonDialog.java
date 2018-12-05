package com.example.common2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.common2.R;


public class CommonDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private Button btn_right;//确定按钮
    private Button btn_left;//取消按钮
    private String titleStr;//从外界设置的title文本
    private TextView titleTv;
    private String leftText, rightText;
    private View.OnClickListener rightListenner, leftListenner;
    private ClickListenerCallBack callBack;

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.no) {
            if (callBack != null) {
                callBack.leftCallBack();
                dismiss();
            }
        }
        if (v.getId() == R.id.yes) {
            if (callBack != null) {
                callBack.rightCallBack();
                dismiss();
            }
        }
    }

    public interface ClickListenerCallBack {
        void leftCallBack();

        void rightCallBack();
    }

    private CommonDialog(Builder builder) {
        super(builder.context, R.style.common_dialog);
        this.titleStr = builder.contentText;
        this.context = builder.context;
        this.rightListenner = builder.okClick;
        this.leftListenner = builder.cacel;
        this.leftText = builder.leftText;
        this.rightText = builder.rightText;
        this.callBack = builder.callBack;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hx_dialog_common_video);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);
        // 设置宽度为屏宽、靠近屏幕底部。
        Window window = getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        wlp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setWindowAnimations(R.style.dialog_common_anim);
        window.setAttributes(wlp);
        //初始化界面控件
        initView();
        //初始化界面数据
        initData();
        //初始化界面控件的事件
        initEvent();

    }

    /**
     * 初始化界面的确定和取消监听器
     */
    private void initEvent() {
        if (rightListenner != null) {
            btn_right.setOnClickListener(rightListenner);
        }
        if (leftListenner != null) {
            btn_left.setOnClickListener(leftListenner);
        }
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        //如果用户自定了title和message
        if (!TextUtils.isEmpty(titleStr)) {
            titleTv.setText(titleStr);
        }
        if (!TextUtils.isEmpty(leftText)) {
            btn_left.setText(leftText);
        }
        if (!TextUtils.isEmpty(rightText)) {
            btn_right.setText(rightText);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        btn_right = (Button) findViewById(R.id.yes);
        btn_left = (Button) findViewById(R.id.no);
        titleTv = (TextView) findViewById(R.id.title);
        btn_right.setOnClickListener(this);
        btn_left.setOnClickListener(this);
    }


    public static final class Builder {
        private Context context;
        private String contentText;
        private View.OnClickListener okClick;
        private View.OnClickListener cacel;
        private String leftText, rightText;
        private ClickListenerCallBack callBack;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder textContent(String str) {
            this.contentText = str;
            return this;
        }

        public Builder leftText(String s) {
            this.leftText = s;
            return this;
        }

        public Builder rightText(String s) {
            this.rightText = s;
            return this;
        }

        public Builder setOk(String rightText, View.OnClickListener listener) {
            this.okClick = listener;
            this.rightText = rightText;
            return this;
        }

        public Builder setCacel(String leftText, View.OnClickListener listener) {
            this.cacel = listener;

            this.leftText = leftText;
            return this;
        }

        public Builder setClickListener(ClickListenerCallBack callBack) {
            this.callBack = callBack;
            return this;
        }

        public CommonDialog build() {
            return new CommonDialog(this);
        }
    }
}
