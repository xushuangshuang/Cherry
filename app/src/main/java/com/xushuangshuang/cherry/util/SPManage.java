package com.xushuangshuang.cherry.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuss on 2015/4/19.
 */
public class SPManage {

    private Context spContext;
    private String spName;
    private Map<String, SharedPreferences> sharedPreferencesMap = new HashMap<String, SharedPreferences>();
    private SharedPreferences currentSharedPreferences;
    private SharedPreferences.Editor  spEditor;

    public static SharedPreferences getSharedPreferences(Context context, String name) {
        return new SPManage(context, name).getSharedPreferences();
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return new SPManage(context, StringManipulation.getUniqueString()).getSharedPreferences();
    }

    private SPManage(Context context, String name) {
        this.spContext = context;
        this.spName = name;
        spEditor = currentSharedPreferences.edit();
    }

    private SharedPreferences getSharedPreferences() {
        if (judgeExist()) {
            currentSharedPreferences = sharedPreferencesMap.get(spName);
        } else {
            currentSharedPreferences = spContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
            sharedPreferencesMap.put(spName, currentSharedPreferences);
        }
        return currentSharedPreferences;
    }

    private boolean judgeExist() {
        return sharedPreferencesMap.containsKey(spName);
    }


    public void set(String key, String value){
        spEditor.putString(key, value).commit();
    }

    public String get(String key, String defaultValue){
        return currentSharedPreferences.getString(key,defaultValue);
    }

    public void set(String key, int value){
        spEditor.putInt(key, value).commit();
    }

    public int get(String key, int defaultValue){
        return currentSharedPreferences.getInt(key, defaultValue);
    }

    public boolean contains(String key){
        return currentSharedPreferences.contains(key);
    }

    public void remove(String key){
        spEditor.remove(key).commit();
    }

    public void clear(){
        spEditor.clear().commit();
    }

}
