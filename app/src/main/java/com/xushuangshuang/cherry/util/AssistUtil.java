package com.xushuangshuang.cherry.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuss on 2015/4/19.
 */
public class AssistUtil {
    public static String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
}
