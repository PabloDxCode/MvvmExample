package com.pablogd.mvvmexample.app.ui.controllers;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.pablogd.mvvmexample.R;
import com.pablogd.mvvmexample.app.utils.Constants;
import com.pablogd.mvvmexample.app.utils.Utils;
import com.pablogd.mvvmexample.data.service.EnvironmentConfig;

public class SplashController extends BaseController {

    /**
     * Handler object
     */
    private Handler mHandler;
    /**
     * Runnable object
     */
    private Runnable mRunnable;
    /**
     * Boolean to know if init method was launched
     */
    private boolean mInitLaunched = Boolean.TRUE;

    /**
     * onCreate
     *
     * @param savedInstanceState bundle instance
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_controller);
        mHandler = new Handler();
    }

    /**
     * onResume
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (mInitLaunched) {
            if (Utils.hasPermissions(this, Constants.PERMISSIONS)) {
                initApp();
            } else {
                ActivityCompat.requestPermissions(this, Constants.PERMISSIONS, Constants.GENERAL_REQUEST_PERMISSION_CODE);
            }
        }
    }

    /**
     * Method to init app
     */
    private void initApp() {
        mInitLaunched = Boolean.FALSE;
        mRunnable = () -> {
            EnvironmentConfig.getInstance().initSimulation(this);
            MainController.newInstance(this);
            finish();
        };
        mHandler.postDelayed(mRunnable, Constants.SPLASH_DELAY);
    }

    /**
     * onPause
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (mRunnable != null) {
            mHandler.removeCallbacks(mRunnable);
            mInitLaunched = Boolean.TRUE;
        }
    }

    /**
     * onRequestPermissionsResult
     *
     * @param requestCode  request code
     * @param permissions  permissions array
     * @param grantResults grand results array
     */
    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String permissions[],
                                           @NonNull final int[] grantResults) {
        if (Constants.GENERAL_REQUEST_PERMISSION_CODE == requestCode) {
            if (Utils.hasPermissions(this, Constants.PERMISSIONS)) {
                initApp();
            } else {
                mInitLaunched = Boolean.FALSE;
                if (Utils.shouldShowPermissionsAlert(this, Constants.PERMISSIONS)) {
                    ActivityCompat.requestPermissions(this, Constants.PERMISSIONS, Constants.GENERAL_REQUEST_PERMISSION_CODE);
                } else {
                    final Uri uri = Uri.fromParts("package", getPackageName(), null);
                    startActivityForResult(new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).setData(uri), requestCode);
                }
            }
        }
    }

    /**
     * onActivityResult
     *
     * @param requestCode request code
     * @param resultCode  result code
     * @param data        intent data
     */
    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mInitLaunched = Boolean.TRUE;
    }

    /**
     * onBackPressed
     */
    @Override
    public void onBackPressed() {
        //Empty method
    }
}
