package calorierecorder.com.fragmentdemo.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.common2.utils.SPUtils;

import java.util.Random;

import calorierecorder.com.fragmentdemo.R;

public class MainActivity extends AppCompatActivity {
    private ImageView iv_anim;
    private Animation fade_in;
    private Animation fade_in_scale;
    private Animation fade_out;
    public static boolean isFirst = true;
    public static String ISFIRST_KEY = "enterApp";
    //  private EditText et_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  et_input = findViewById(R.id.et_input);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                intent.putExtra("content", et_input.getText().toString().trim());
                startActivity(intent);
            }
        });*/
        isFirst = SPUtils.getSharedBooleanData(this, ISFIRST_KEY);
        iv_anim = findViewById(R.id.iv_anim);
        //initAnim();
        int i = new Random().nextInt(2);
        if (i == 1) {
            iv_anim.setImageResource(R.mipmap.entrance1);
        } else {
            iv_anim.setImageResource(R.mipmap.entrance2);
        }
        anim();
    }

    private void anim() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(iv_anim, "scaleX", 1.0f, 1.1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(iv_anim, "scaleY", 1.0f, 1.1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(iv_anim, "alpha", 0.0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.play(scaleX).with(scaleY).with(alpha);
        set.setDuration(2000);
        set.start();
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (isFirst) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(MainActivity.this, SplashActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    private void initAnim() {
        fade_in = AnimationUtils.loadAnimation(this, R.anim.application_fade_in);
        fade_in.setDuration(500);
        fade_in_scale = AnimationUtils.loadAnimation(this, R.anim.application_fade_in_scale);
        fade_in_scale.setDuration(2000);
        fade_out = AnimationUtils.loadAnimation(this, R.anim.application_fade_out);
        fade_out.setDuration(500);
        iv_anim.setAnimation(fade_in);
        setAnimListener();
    }

    private void setAnimListener() {
        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_anim.setAnimation(fade_in_scale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fade_in_scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_anim.setAnimation(fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fade_out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
