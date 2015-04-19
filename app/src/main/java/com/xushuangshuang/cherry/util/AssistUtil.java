package com.xushuangshuang.cherry.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xuss on 2015/4/19.
 */
public class AssistUtil {
    public static String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    public static String getWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        String[] weekString = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return weekString[dayOfWeek - 1];
    }
}
