package com.example.common2.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.common2.R;
import com.example.common2.utils.GsonUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.lzy.okrx2.adapter.ObservableResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.operators.observable.ObserverResourceWrapper;
import io.reactivex.schedulers.Schedulers;

public class TestActivity extends AppCompatActivity {

    private ImageView iv_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        iv_icon = findViewById(R.id.iv_icon);
        OkGo.<String>get("https://www.baidu.com/?tn=93308895_hao_pg")
                .adapt(new ObservableResponse<String>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {
                        Log.e("xxx", stringResponse.body());
//                        byte[] bytes = stringResponse.body().getBytes();
//
//                        GirlBean bean = GsonUtil.parse(json, GirlBean.class);
//                        Glide.with(TestActivity.this).load(bean.getResults().get(0).getUrl()).into(iv_icon);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        // initImage();
    }

    private String baseUrl = "https://gank.io/api/data/福利/1/";

    private String makeUrl(String i) {
        return baseUrl + i;
    }

    private List<String> imgUrls = new ArrayList<>();

    private void initImage() {
        io.reactivex.Observable.interval(0, 10, TimeUnit.SECONDS).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {

            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Glide.with(TestActivity.this).load(imgUrls.get(0)).into(iv_icon);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
