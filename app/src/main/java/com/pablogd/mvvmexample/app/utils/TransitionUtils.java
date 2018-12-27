package com.pablogd.mvvmexample.app.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * TransitionUtils
 * Created by pablogutierrez on 06/09/18.
 */
public class TransitionUtils {

    /**
     * From activity for intent
     */
    private Activity fromActivity;
    /**
     * To class for intent
     */
    private Class aClass;
    /**
     * Int for flags intent
     */
    private int flags;
    /**
     * Bundle params
     */
    private Bundle bundle;

    /**
     * Method to build transition
     *
     * @param fromActivity from activity instance
     * @param aClass       class to go
     * @return this
     */
    public TransitionUtils build(final Activity fromActivity, final Class aClass) {
        this.fromActivity = fromActivity;
        this.aClass = aClass;
        return this;
    }

    /**
     * Method to set intent flags
     *
     * @param flags flags
     * @return this
     */
    public TransitionUtils setFlags(final int flags) {
        this.flags = flags;
        return this;
    }

    /**
     * Method to set bundle params
     *
     * @param bundle bundle
     * @return this
     */
    public TransitionUtils setBundle(final Bundle bundle) {
        this.bundle = bundle;
        return this;
    }

    /**
     * Method to start transition
     */
    public void start() {
        final Intent intent = new Intent();
        intent.setClass(fromActivity, aClass);
        if (flags > 0) {
            intent.setFlags(flags);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        fromActivity.startActivity(intent);
    }

    /**
     * Method to clean Bundle data
     *
     * @param fromActivity from activity
     */
    public static void cleanBundle(final Activity fromActivity) {
        final Bundle bundle = fromActivity.getIntent().getExtras();
        if (bundle != null) {
            for (final String item : bundle.keySet()) {
                fromActivity.getIntent().removeExtra(item);
            }
        }
    }

}
