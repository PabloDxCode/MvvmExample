package com.pablogd.mvvmexample.app.ui.controllers;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Toast;

import com.pablogd.mvvmexample.R;
import com.pablogd.mvvmexample.app.utils.ProgressDialogUtils;
import com.pablogd.mvvmexample.app.utils.TransitionUtils;
import com.pablogd.mvvmexample.app.view_model.MainViewModel;
import com.pablogd.mvvmexample.app.view_model.ViewModelFactory;

public class MainController extends BaseController {

    public static void newInstance(final Activity fromActivity) {
        new TransitionUtils().build(fromActivity, MainController.class).start();
        fromActivity.finish();
    }

    /**
     * Main view model
     */
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewModelFactory viewModelFactory = new ViewModelFactory();
        mMainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);
        new ProgressDialogUtils(this);
        configView();
    }

    private void configView(){
        mMainViewModel.getResponseMutableLiveData().observe(this, response -> Toast.makeText(MainController.this, response, Toast.LENGTH_SHORT).show());
        mMainViewModel.getIsLoading().observe(this, this::showHideProgress);
        mMainViewModel.getErrorMessage().observe(this, error -> Toast.makeText(MainController.this, error, Toast.LENGTH_SHORT).show());
        findViewById(R.id.bt_start_request).setOnClickListener(view -> mMainViewModel.launchTestRequest());
    }

}
