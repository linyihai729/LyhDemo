package calorierecorder.com.fragmentdemo.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.common2.activity.BaseActivity;
import com.example.common2.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import calorierecorder.com.fragmentdemo.R;

public class SplashActivity extends BaseActivity {

    private ViewPager vp_splash;
    private int[] viewId = {
            R.layout.splash_img1,
            R.layout.splash_img2,
            R.layout.splash_img3,
            R.layout.splash_img4
    };
    private List<View> listViews = new ArrayList<View>();
    private LayoutInflater inflater;
    private Button btn_join;
    private int[] imgRs = {
            R.mipmap.splash1, R.mipmap.splash2, R.mipmap.splash3, R.mipmap.splash4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        SPUtils.setSharedBooleanData(this,MainActivity.ISFIRST_KEY,true);
    }

    private void initView() {
        vp_splash = findViewById(R.id.vp_splash);
        inflater = LayoutInflater.from(this);
//        for (int i = 0; i < viewId.length; i++) {
//            View view = inflater.inflate(viewId[i], null);
//            listViews.add(view);
//        }
        for (int i=0;i<imgRs.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(imgRs[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            listViews.add(imageView);
        }
        btn_join = findViewById(R.id.btn_join);
        vp_splash.setAdapter(new SplashAdapter());
        vp_splash.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == listViews.size() - 1) {
                    btn_join.setVisibility(View.VISIBLE);
                } else {
                    btn_join.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    class SplashAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return listViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(listViews.get(position));
            return listViews.get(position);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            //super.destroyItem(container, position, object);
            container.removeView(listViews.get(position));
        }
    }
}
