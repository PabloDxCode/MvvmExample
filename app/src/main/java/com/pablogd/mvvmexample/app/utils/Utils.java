package com.pablogd.mvvmexample.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Utils
 * Created by pablogutierrez on 18/12/18.
 */
public class Utils {

    /**
     * Method to validate if application has permissions
     *
     * @param context     context instance
     * @param permissions permissions list
     * @return boolean
     */
    public static boolean hasPermissions(final Context context, final String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (final String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method to validate if permissions alert should show
     *
     * @param activity    activity instance
     * @param permissions permissions list
     * @return boolean
     */
    public static boolean shouldShowPermissionsAlert(final Activity activity, final String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && activity != null && permissions != null) {
            for (final String permission : permissions) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    return true;
                }
            }
        }
        return false;
    }

}
