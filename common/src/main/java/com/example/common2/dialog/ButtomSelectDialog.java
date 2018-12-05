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

import com.example.common2.R;


public class ButtomSelectDialog extends Dialog {
    private Context context;
    private Button btn_first;
    private Button btn_second;
    private Button btn_buttom;
    private String btnFirstText;//从外界设置的title文本
    private String btnSecondText;
    private String btnButtomText;
    private View.OnClickListener btnFirstListenner;
    private View.OnClickListener btnSecondListenner;
    private View.OnClickListener btnButtomListenner;

    private ButtomSelectDialog(Builder builder) {
        super(builder.context, R.style.common_dialog);
        this.context = builder.context;
        this.btnButtomListenner = builder.buttomClick;
        this.btnFirstListenner = builder.firstClick;
        this.btnSecondListenner = builder.secondClick;
        this.btnFirstText = builder.btnFirstText;
        this.btnSecondText = builder.btnSecondText;
        this.btnButtomText = builder.btnButtomText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hx_dialog_select_video);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        // 设置宽度为屏宽、靠近屏幕底部。
        wlp.gravity = Gravity.BOTTOM;
        wlp.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setWindowAnimations(R.style.dialog_select_anim);
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
        if (btnFirstListenner != null) {
            btn_first.setOnClickListener(btnFirstListenner);
        }
        if (btnButtomListenner != null) {
            btn_buttom.setOnClickListener(btnButtomListenner);
        }
        if (btnSecondListenner != null) {
            btn_second.setOnClickListener(btnSecondListenner);
        }
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        if (!TextUtils.isEmpty(btnButtomText)) {
            btn_buttom.setText(btnButtomText);
        }
        if (!TextUtils.isEmpty(btnFirstText)) {
            btn_first.setText(btnFirstText);
        }
        if (!TextUtils.isEmpty(btnSecondText)) {
            btn_second.setText(btnSecondText);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        btn_first = findViewById(R.id.btn_first);
        btn_second = findViewById(R.id.btn_second);
        btn_buttom = findViewById(R.id.btn_buttom);
    }


    public static final class Builder {
        private Context context;
        private View.OnClickListener firstClick;
        private View.OnClickListener secondClick;
        private View.OnClickListener buttomClick;
        private String btnFirstText;
        private String btnSecondText;
        private String btnButtomText;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setFirstClick(String btnFirstText, View.OnClickListener listener) {
            this.firstClick = listener;
            this.btnFirstText = btnFirstText;
            return this;
        }

        public Builder setSecondClick(String btnSecondText, View.OnClickListener listener) {
            this.secondClick = listener;
            this.btnSecondText = btnSecondText;
            return this;
        }

        public Builder setButtomClick(String btnButtomText, View.OnClickListener listener) {
            this.buttomClick = listener;
            this.btnButtomText = btnButtomText;
            return this;
        }

        public ButtomSelectDialog build() {
            return new ButtomSelectDialog(this);
        }
    }
}
