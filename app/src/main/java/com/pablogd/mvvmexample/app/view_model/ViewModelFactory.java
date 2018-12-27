package com.pablogd.mvvmexample.app.view_model;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

/**
 * ViewModelFactory
 * Created by pablogutierrez on 16/12/18.
 */
public class ViewModelFactory implements ViewModelProvider.Factory {

    /**
     * create
     *
     * @param modelClass model class
     * @param <T>        class extended view model
     * @return class extended view model
     */
    @SuppressWarnings({"unchecked", "ConstantConditions"})
    @Override
    public @NonNull
    <T extends ViewModel> T create(@NonNull final Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
