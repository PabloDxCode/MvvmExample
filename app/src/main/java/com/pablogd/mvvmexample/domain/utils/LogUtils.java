package com.pablogd.mvvmexample.domain.utils;

import android.util.Log;

import com.pablogd.mvvmexample.app.utils.Constants;

/**
 * LogUtils
 * Created by pablogutierrez on 21/12/18.
 */
public class LogUtils {

    private String mTag;
    private String mValue;

    private LogUtils(final String tag, final String value) {
        this.mTag = tag;
        this.mValue = value;
    }

    public static LogUtils build(final String tag, final String values) {
        return new LogUtils(tag, values);
    }

    public void d() {
        if (!Constants.TEST) {
            Log.d(mTag, mValue);
        }
    }

    public void i() {
        if (!Constants.TEST) {
            Log.i(mTag, mValue);
        }
    }

    public void e() {
        if (!Constants.TEST) {
            Log.e(mTag, mValue);
        }
    }

    public void e(final Throwable throwable) {
        if (!Constants.TEST) {
            Log.e(mTag, mValue, throwable);
        }
    }

}
