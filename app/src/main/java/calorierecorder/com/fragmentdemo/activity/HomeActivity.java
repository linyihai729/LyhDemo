package calorierecorder.com.fragmentdemo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common2.activity.BaseActivity;
import com.example.common2.dialog.CommonDialog;
import com.example.common2.dialog.HxPayErrorDialog;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.Random;

import calorierecorder.com.fragmentdemo.R;
import calorierecorder.com.fragmentdemo.TabEntity;
import calorierecorder.com.fragmentdemo.fragment.HomeFragment;
import calorierecorder.com.fragmentdemo.fragment.MessageFragment;
import calorierecorder.com.fragmentdemo.fragment.MoreFragment;
import calorierecorder.com.fragmentdemo.fragment.SettingFragment;

public class HomeActivity extends BaseActivity {

    private CommonTabLayout mTabLayout_2;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private TextView title_center;
    private HxPayErrorDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        mTabLayout_2 = findViewById(R.id.tl_2);
        mViewPager = findViewById(R.id.vp_2);
        title_center = findViewById(R.id.title_center);
        title_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent(HomeActivity.this,PersonActivity.class);
//                startActivity(intent);
                CommonDialog dialog = new CommonDialog.Builder(HomeActivity.this)
                        .textContent("验证")
                        .leftText("左边")
                        .rightText("右边")
                        .setClickListener(new CommonDialog.ClickListenerCallBack() {
                            @Override
                            public void leftCallBack() {
                                Toast.makeText(HomeActivity.this, "dasd", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void rightCallBack() {
                                Toast.makeText(HomeActivity.this, "ewerwerwe", Toast.LENGTH_SHORT).show();

                            }
                        }).build();
                dialog.show();
            }
        });
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        mFragments.add(new HomeFragment());
        mFragments.add(new MessageFragment());
        mFragments.add(new MoreFragment());
        mFragments.add(new SettingFragment());
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tl_2();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    Random mRandom = new Random();

    private void tl_2() {
        mTabLayout_2.setTabData(mTabEntities);
        mTabLayout_2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
                title_center.setText(mTitles[position]);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
                    mTabLayout_2.showMsg(0, mRandom.nextInt(100) + 1);
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout_2.setCurrentTab(position);
                title_center.setText(mTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setCurrentItem(0);
        title_center.setText(mTitles[0]);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
