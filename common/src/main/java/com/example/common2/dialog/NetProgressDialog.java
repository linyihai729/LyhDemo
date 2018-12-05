package com.example.common2.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.common2.R;

public class NetProgressDialog extends Dialog {
    private String content;
    private int color;
    private ProgressBar progressBar;
    private TextView text;

    private NetProgressDialog(@NonNull Context context, Builder builder) {
        super(context, R.style.progress_common_dialog);
        this.content = builder.content;
        this.color = builder.color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_net_progress);
        //按空白处不能取消动画
        setCanceledOnTouchOutside(false);
        progressBar = findViewById(R.id.loading_pb);
        text = findViewById(R.id.loading_tv);
        if (!TextUtils.isEmpty(content)) {
            text.setText(content);
        }
    }

    public static class Builder {
        private Activity activity;
        private String content;
        private int color;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        public NetProgressDialog build() {
            return new NetProgressDialog(activity, this);
        }
    }
}
