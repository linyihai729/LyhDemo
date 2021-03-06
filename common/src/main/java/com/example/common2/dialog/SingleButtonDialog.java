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


public class SingleButtonDialog extends Dialog {
    private Context context;
    private Button yes;
    private String titleStr;//从外界设置的title文本
    private String btnText;
    private TextView titleTv;
    private View.OnClickListener yesListenner;

    private SingleButtonDialog(Builder builder) {
        super(builder.context, R.style.common_dialog);
        this.titleStr = builder.contentText;
        this.context = builder.context;
        this.yesListenner = builder.okClick;
        this.btnText=builder.btnText;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hx_dialog_info_video);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        // 设置宽度为屏宽、靠近屏幕底部。
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
        if (yesListenner != null) {
            yes.setOnClickListener(yesListenner);
        }
    }

    /**
     * 初始化界面控件的显示数据
     */
    private void initData() {
        if (!TextUtils.isEmpty(titleStr)) {
            titleTv.setText(titleStr);
        }
        if (!TextUtils.isEmpty(btnText)){
            yes.setText(btnText);
        }
    }

    /**
     * 初始化界面控件
     */
    private void initView() {
        yes = (Button) findViewById(R.id.yes);
        titleTv = (TextView) findViewById(R.id.title);
    }


    public static final class Builder {
        private Context context;
        private String contentText;
        private View.OnClickListener okClick;
        private String btnText;
        public Builder(Context context) {
            this.context = context;
        }

        public Builder textContent(String str) {
            this.contentText = str;
            return this;
        }
        public Builder btnText(String str){
            this.btnText=str;
            return this;
        }

        public Builder setOk(View.OnClickListener listener) {
            this.okClick = listener;
            return this;
        }


        public SingleButtonDialog build() {
            return new SingleButtonDialog(this);
        }
    }
}
