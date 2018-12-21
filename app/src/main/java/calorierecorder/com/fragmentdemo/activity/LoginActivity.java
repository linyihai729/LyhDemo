package calorierecorder.com.fragmentdemo.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.common2.activity.BaseActivity;
import com.example.common2.utils.ImageUtils;

import calorierecorder.com.fragmentdemo.R;


public class LoginActivity extends BaseActivity {

    private ImageView ivShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login)
        ivShow = findViewById(R.id.iv_show);
        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AppManager.getAppManager().finishActivity(LoginActivity.this);
                //Toast.makeText(LoginActivity.this,ScreenHeight(LoginActivity.this)+"!!!",0).show();
                Bitmap bitmap = ImageUtils.ResourceToBitmap(LoginActivity.this, R.mipmap.ic_launcher);
                Bitmap bitmap1 = ImageUtils.createReflectionImageWithOrigin(bitmap);
                ivShow.setImageBitmap(bitmap1);
                ImageUtils.getOutputMediaFile();
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }
}
