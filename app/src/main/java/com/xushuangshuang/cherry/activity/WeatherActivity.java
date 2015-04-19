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
import com.xushuangshuang.cherry.adapter.WeatherUserPageAdapter;
import com.xushuangshuang.cherry.model.Weather;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by xuss on 2015/4/19.
 */
public class WeatherActivity extends Activity {

    private ImageView backGroundImageView;
    private ViewPager userViewPager;
    private LayoutInflater viewPageLayoutInflater;
    private ArrayList<View> views;
    private WeatherUserPageAdapter weatherUserPageAdapter;
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
    private TextView textView_user_index_ag;
    private TextView textView_user_weather;
    private LinearLayout linear_user_first_other;

    private RequestQueue mQueue;
    private String uri = "https://api.thinkpage.cn/v2/weather/all.json?city=%E5%8C%97%E4%BA%AC&language=zh-chs&unit=c&aqi=city&key=JXEOKCLHRU";
    private Gson gson;
    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        initView();
        initLayout();
        initDate();
    }

    private void initDate() {
        JsonObjectRequest weatherModel = new JsonObjectRequest(uri, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("test", response.toString());
                        weather = gson.fromJson(response.toString(), Weather.class);
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
        textView_user_index_ag = (TextView) firstView
                .findViewById(R.id.textView_user_index_ag);

        textView_user_weather = (TextView) firstView
                .findViewById(R.id.textView_user_weather);
        linear_user_first_other = (LinearLayout) firstView
                .findViewById(R.id.linear_user_first_other);
    }


}
