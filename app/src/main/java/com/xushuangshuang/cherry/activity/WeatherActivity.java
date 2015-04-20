package com.xushuangshuang.cherry.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xushuangshuang.cherry.R;
import com.xushuangshuang.cherry.adapter.FutureWeatherViewPagerAdapter;
import com.xushuangshuang.cherry.adapter.WeatherUserPageAdapter;
import com.xushuangshuang.cherry.model.Weather;
import com.xushuangshuang.cherry.model.WeatherModel;
import com.xushuangshuang.cherry.util.AssistUtil;
import com.xushuangshuang.cherry.util.StringManipulation;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherActivity extends Activity {

    private ImageView backGroundImageView;
    private ViewPager userViewPager;
    private LayoutInflater viewPageLayoutInflater;
    private ArrayList<View> views;
    private WeatherUserPageAdapter weatherUserPageAdapter;
    private FutureWeatherViewPagerAdapter futureWeatherViewPagerAdapter;
    private ImageView imageView_user_imgOne;
    private TextView textView_user_city;
    private TextView textView_user_date;
    private TextView textView_user_temp;
    private TextView textView_user_index_d;
    private TextView textView_user_index_uv;
    private TextView textView_user_index_xc;
    private TextView textView_user_index_tr;
    private TextView textView_user_index_co;
    private TextView textView_user_index_cl;
    private TextView textView_user_index_ls;
    private TextView textView_user_weather;
    private ViewPager futureOneWeekViewPager;

    private RequestQueue mQueue;
    private String uri = " https://api.thinkpage.cn/v2/weather/all.json?city=北京&language=zh-chs&unit=c&aqi=city&key=ERBQFQ3STU";
    private Gson gson;
    private WeatherModel weather;
    private ArrayList<View> viewArrayList;
    private ImageView futureImageView;
    private TextView futureDateTextView;
    private TextView futureWeatherTextView;
    private TextView futureTempTextView;
    private TextView futureWindTextView;
    private ImageView futureImageViewTwo;
    private TextView futureDateTextViewTwo;
    private TextView futureWeatherTextViewTwo;
    private TextView futureTempTextViewTwo;
    private TextView futureWindTextViewTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        initView();
        initDate();
    }

    private void addDate() {
        if (weather != null && weather.getWeather().get(0) != null && weather.getWeather().get(0).getNow().getCode() != null) {
            imageView_user_imgOne.setImageResource(StringManipulation.getRecIDFormWeather(weather.getWeather().get(0).getNow().getCode()));
            textView_user_city.setText(weather.getWeather().get(0).getCity_name());
            textView_user_temp.setText(weather.getWeather().get(0).getNow().getTemperature() + "℃");
            textView_user_weather.setText(weather.getWeather().get(0).getNow().getText());
            textView_user_date.setText(AssistUtil.getDate() + "  " + AssistUtil.getWeek());
            textView_user_index_d.setText(weather.getWeather().get(0).getToday().getSuggestion().getDressing().getDetails());
            textView_user_index_uv.setText(weather.getWeather().get(0).getToday().getSuggestion().getUv().getDetails());
            textView_user_index_xc.setText(weather.getWeather().get(0).getToday().getSuggestion().getCar_washing().getDetails());
            textView_user_index_tr.setText(weather.getWeather().get(0).getToday().getSuggestion().getTravel().getDetails().replace(";", ""));
            textView_user_index_co.setText("舒适度 " + weather.getWeather().get(0).getNow().getAir_quality().getCity().getCo());
            textView_user_index_cl.setText(weather.getWeather().get(0).getToday().getSuggestion().getFlu().getDetails().replace(";", ""));
            textView_user_index_ls.setText(weather.getWeather().get(0).getNow().getWind_direction() + "风  " + weather.getWeather().get(0).getNow().getWind_speed() + " m/s");
        }
    }

    private void initDate() {
        JsonObjectRequest weatherModel = new JsonObjectRequest(uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        weather = gson.fromJson(response.toString(), WeatherModel.class);
                        if ("OK".equals(weather.getStatus()) && weather != null) {
                            addDate();
                            for (int viewNum = 0; viewNum < viewArrayList.size(); viewNum++) {
                                initFutureViewPage(viewArrayList.get(viewNum));
                                initDateFuture(viewNum);
                            }

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        mQueue.add(weatherModel);
    }

    private void initView() {
        gson = new Gson();
        mQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.weather_layout);
        viewPageLayoutInflater = LayoutInflater.from(this);
        backGroundImageView = (ImageView) findViewById(R.id.imageView_user_bg);
        userViewPager = (ViewPager) findViewById(R.id.viewPager_user);
        views = new ArrayList<View>();
        views.add(viewPageLayoutInflater.inflate(R.layout.weather_user_page, null));
        weatherUserPageAdapter = new WeatherUserPageAdapter(views);
        userViewPager.setAdapter(weatherUserPageAdapter);
        initLayout();
        initViewPage();
    }

    private void initLayout() {
        View firstView = views.get(0);
        imageView_user_imgOne = (ImageView) firstView
                .findViewById(R.id.imageView_user_imgOne);
        textView_user_city = (TextView) firstView
                .findViewById(R.id.textView_user_city);
        textView_user_date = (TextView) firstView
                .findViewById(R.id.textView_user_date);
        textView_user_temp = (TextView) firstView
                .findViewById(R.id.textView_user_temp);
        textView_user_index_d = (TextView) firstView
                .findViewById(R.id.textView_user_index_d);
        textView_user_index_uv = (TextView) firstView
                .findViewById(R.id.textView_user_index_uv);
        textView_user_index_xc = (TextView) firstView
                .findViewById(R.id.textView_user_index_xc);
        textView_user_index_tr = (TextView) firstView
                .findViewById(R.id.textView_user_index_tr);
        textView_user_index_co = (TextView) firstView
                .findViewById(R.id.textView_user_index_co);
        textView_user_index_cl = (TextView) firstView
                .findViewById(R.id.textView_user_index_cl);
        textView_user_index_ls = (TextView) firstView
                .findViewById(R.id.textView_user_index_ls);
        textView_user_weather = (TextView) firstView
                .findViewById(R.id.textView_user_weather);
        futureOneWeekViewPager = (ViewPager) firstView
                .findViewById(R.id.one_week_view_pager);
    }

    private void initFutureViewPage(View futureView) {
        futureImageView = (ImageView) futureView.findViewById(R.id.future_image_view);
        futureImageViewTwo = (ImageView) futureView.findViewById(R.id.future_image_two_view);
        futureDateTextView = (TextView) futureView.findViewById(R.id.future_date);
        futureDateTextViewTwo = (TextView) futureView.findViewById(R.id.future_two_date);
        futureWeatherTextView = (TextView) futureView.findViewById(R.id.future_weather);
        futureWeatherTextViewTwo = (TextView) futureView.findViewById(R.id.future_two_weather);
        futureTempTextView = (TextView) futureView.findViewById(R.id.future_temp);
        futureTempTextViewTwo = (TextView) futureView.findViewById(R.id.future_two_temp);
        futureWindTextView = (TextView) futureView.findViewById(R.id.future_wind);
        futureWindTextViewTwo = (TextView) futureView.findViewById(R.id.future_two_wind);
    }

    private void initDateFuture(int num) {
        if (weather != null && weather.getWeather().get(0) != null && weather.getWeather().get(0).getNow().getCode() != null) {
            futureImageView.setImageResource(StringManipulation.getRecIDFormWeather(weather.getWeather().get(0).getFuture().get(num).getCode1()));
            futureImageViewTwo.setImageResource(StringManipulation.getRecIDFormWeather(weather.getWeather().get(0).getFuture().get(num + 1).getCode1()));
            futureDateTextView.setText(weather.getWeather().get(0).getFuture().get(num).getDate());
            futureDateTextViewTwo.setText(weather.getWeather().get(0).getFuture().get(num + 1).getDate());
            futureWeatherTextView.setText(weather.getWeather().get(0).getFuture().get(num).getText());
            futureWeatherTextViewTwo.setText(weather.getWeather().get(0).getFuture().get(num + 1).getText());
            futureTempTextView.setText("最高：" + weather.getWeather().get(0).getFuture().get(num).getHigh() + "最低：" + weather.getWeather().get(0).getFuture().get(num).getLow());
            futureTempTextViewTwo.setText("最高：" + weather.getWeather().get(0).getFuture().get(num + 1).getHigh() + "最低：" + weather.getWeather().get(0).getFuture().get(num + 1).getLow());
            futureWindTextView.setText(weather.getWeather().get(0).getFuture().get(num).getWind());
            futureWindTextViewTwo.setText(weather.getWeather().get(0).getFuture().get(num + 1).getWind());
        }
    }


    public void initViewPage() {
        viewArrayList = new ArrayList<View>();
        int num = 0;
        while (num < 7) {
            View futureView = viewPageLayoutInflater.inflate(R.layout.future_weather, null);
            viewArrayList.add(futureView);
            num++;
        }
        futureWeatherViewPagerAdapter = new FutureWeatherViewPagerAdapter(viewArrayList);
        futureOneWeekViewPager.setAdapter(futureWeatherViewPagerAdapter);
    }

}
