package com.example.mvp_mvp.present;

import android.util.Log;

import com.example.mvp_mvp.bean.WeatherBean;
import com.example.mvp_mvp.view.WeatherView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by teresa on 2017/7/21.
 */
public class WeatherPresent {
    private static final String TAG = WeatherPresent.class.getSimpleName();
    private WeatherView view;
    private WeatherBean weatherBean;

    public WeatherPresent(WeatherView view) {
        this.view = view;
    }


    public void getWeather(String url) throws IOException {
//        Okhttp
        OkHttpClient client = new OkHttpClient();
        client= client.newBuilder().connectTimeout(60, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String body = response.body().string();
                Log.i(TAG,body);
                weatherBean = new Gson().fromJson(body, WeatherBean.class);
                Log.i(TAG,""+weatherBean);
                view.showName(weatherBean.weatherinfo.city);
                view.showWeather(weatherBean.weatherinfo.temp);
            }
        });
        //  todo:retrofit

    }

}
