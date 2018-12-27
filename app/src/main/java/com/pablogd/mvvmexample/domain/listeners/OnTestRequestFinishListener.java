package com.pablogd.mvvmexample.domain.listeners;

import com.pablogd.mvvmexample.data.models.ResponseDto;

/**
 * OnTestRequestFinishListener
 * Created by pablogutierrez on 17/12/18.
 */
public interface OnTestRequestFinishListener {

    void onSuccess(ResponseDto responseDto);

    void onError(String error);

}
