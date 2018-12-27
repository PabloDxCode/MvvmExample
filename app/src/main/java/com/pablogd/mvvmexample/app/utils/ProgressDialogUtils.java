package com.pablogd.mvvmexample.app.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * ProgressDialogUtil
 * Created by pablogutierrez on 09/09/18.
 */
public class ProgressDialogUtils {

    /**
     * Progress dialog object
     */
    private static ProgressDialog mProgressDialog;

    /**
     * Constructor
     *
     * @param context context instance
     */
    public ProgressDialogUtils(final Context context) {
        ProgressDialogUtils.mProgressDialog = new ProgressDialog(context);
        ProgressDialogUtils.mProgressDialog.setCancelable(false);
    }

    /**
     * Method to show progress dialog
     *
     * @param message message
     */
    public static void showProgressDialog(final String message) {
        if(mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.setMessage(message);
            mProgressDialog.show();
        }
    }

    /**
     * Method to hide progress dialog
     */
    public static void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

}
