package com.xushuangshuang.cherry.util;

import com.xushuangshuang.cherry.R;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;

/**
 * Created by xuss on 2015/4/19.
 */
public class StringManipulation {

    public static String getUniqueString() {
        long nanoTime = System.nanoTime();
        String preFix = "";
        if (nanoTime < 0) {
            preFix = "A";
            nanoTime = nanoTime + Long.MAX_VALUE + 1;
        } else {
            preFix = "Z";
        }
        String nanoTimeStr = String.valueOf(nanoTime);

        int difBit = String.valueOf(Long.MAX_VALUE).length() - nanoTimeStr.length();
        for (int i = 0; i < difBit; i++) {
            preFix = preFix + "0";
        }
        nanoTimeStr = preFix + nanoTimeStr;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeMillisSequence = sdf.format(System.currentTimeMillis()) + "-" + nanoTimeStr;

        return timeMillisSequence;
    }

    public static String assembleURI(String schemeSpecificPart, Map<String, Object> parameterMap) {
        StringBuffer url = new StringBuffer(schemeSpecificPart);
        url.append("?");
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            url.append(key).append("=").append(parameterMap.get(key));
        }

        return url.toString();
    }

    public static int getRecIDFormWeather(String codeStr) {
        int code = Integer.parseInt(codeStr);
        int[] drawableWeatherId = {R.drawable.sunny_0, R.drawable.clear_1, R.drawable.fair_2, R.drawable.n_fair_3,
                R.drawable.cloudy_4, R.drawable.partly_cloudy_5, R.drawable.n_partly_cloudy_6, R.drawable.mostly_cloudy_7,
                R.drawable.n_mostly_cloudy_8, R.drawable.overcast_9, R.drawable.shower_10, R.drawable.thunder_shower_11,
                R.drawable.thunder_shower_with_hail_12, R.drawable.light_rain_13, R.drawable.moderate_rain_14, R.drawable.heavy_rain_15,
                R.drawable.storm_16, R.drawable.heavy_storm_17, R.drawable.severe_storm_18, R.drawable.ice_rain_19, R.drawable.sleet_20,
                R.drawable.snow_flurry_21, R.drawable.light_snow_22, R.drawable.moderate_snow_23, R.drawable.heavy_snow_24,
                R.drawable.snow_storm_25, R.drawable.dust_26, R.drawable.sand_27, R.drawable.duststorm_28, R.drawable.sandstorm_29,
                R.drawable.foggy_30, R.drawable.haze_31, R.drawable.windy_32, R.drawable.blustery_33, R.drawable.hurricane_34,
                R.drawable.tropical_storm_35, R.drawable.tornado_36, R.drawable.cold_37, R.drawable.hot_38, R.drawable.unknown_99};
        return drawableWeatherId[code];
    }


}