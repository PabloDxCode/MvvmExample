package com.pablogd.mvvmexample.app.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * BaseViewModel
 * Created by pablogutierrez on 16/12/18.
 */
public class BaseViewModel extends ViewModel {

    /**
     * Mutable live data for loading behaviour
     */
    protected final MutableLiveData<Boolean> mIsLoading;

    /**
     * Mutable live data for error message
     */
    protected final MutableLiveData<String> mErrorMessage;

    /**
     * Constructor
     */
    BaseViewModel() {
        mIsLoading = new MutableLiveData<>();
        mErrorMessage = new MutableLiveData<>();
    }

    /**
     * Method to validate loading state
     * @return mutable data
     */
    public LiveData<Boolean> getIsLoading() {
        return mIsLoading;
    }

    /**
     * Method to get error message
     *
     * @return mutable data
     */
    public LiveData<String> getErrorMessage() {
        return mErrorMessage;
    }

}
