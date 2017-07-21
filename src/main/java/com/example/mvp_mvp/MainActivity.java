package com.example.mvp_mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvp_mvp.present.WeatherPresent;
import com.example.mvp_mvp.view.WeatherView;

import java.io.IOException;

/**
 * mvp架构，点击按钮，访问北京天气，并显示。
 * http://weather.51wnl.com/weatherinfo/GetMoreWeather?cityCode=101010100&weatherType=1
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener,WeatherView {

    public Button getWeather;
    public WeatherPresent present;
    public TextView city;
    public String url;
    public TextView weather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeather = (Button) findViewById(R.id.getWeather);
        getWeather.setOnClickListener(this);
        weather = (TextView) findViewById(R.id.weather);
        city = (TextView) findViewById(R.id.city);
        present = new WeatherPresent(this);
        url = "http://weather.51wnl.com/weatherinfo/GetMoreWeather?cityCode=101010100&weatherType=1";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getWeather:
                try {
                    present.getWeather(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    /**
     *
     * @param _weather 温度
     * @return 返回温度
     */
    @Override
    public void showWeather(final String _weather) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                weather.setText(_weather);
            }
        });

    }

    /**
     *
     * @param name 城市名字
     * @return  返回城市名字
     */
    @Override
    public void showName(final String name) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                city.setText(name);
            }
        });
    }


}
