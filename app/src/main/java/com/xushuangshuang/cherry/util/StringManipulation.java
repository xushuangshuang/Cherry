package com.xushuangshuang.cherry.util;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
}