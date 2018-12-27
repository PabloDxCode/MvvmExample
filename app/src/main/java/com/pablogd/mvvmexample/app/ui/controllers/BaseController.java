package com.pablogd.mvvmexample.app.ui.controllers;

import android.support.v7.app.AppCompatActivity;

import com.pablogd.mvvmexample.app.utils.ProgressDialogUtils;

/**
 * BaseController
 * Created by pablogutierrez on 16/12/18.
 */
public class BaseController extends AppCompatActivity{

    protected void showHideProgress(final boolean isLoading){
        if(isLoading){
            ProgressDialogUtils.showProgressDialog("Cargando...");
        } else {
            ProgressDialogUtils.hideProgressDialog();
        }
    }

}
