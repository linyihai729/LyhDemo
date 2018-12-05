package calorierecorder.com.fragmentdemo.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import calorierecorder.com.fragmentdemo.R;

public class PersonActivity extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private RelativeLayout rl_head;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
        setTitleToCollapsingToolbarLayout();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        appBarLayout = findViewById(R.id.app_bar);
        rl_head = findViewById(R.id.rl_head);
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout);
    }

    /**
     * 使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，
     * 设置到Toolbar上则不会显示
     */
    private void setTitleToCollapsingToolbarLayout() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <= -rl_head.getHeight() / 2) {
                    collapsingToolbarLayout.setTitle("黄晓果");
                    //使用下面两个CollapsingToolbarLayout的方法设置展开透明->折叠时你想要的颜色
                    collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorAccent));
                } else {
                    collapsingToolbarLayout.setTitle("");
                }
            }
        });
    }

}
