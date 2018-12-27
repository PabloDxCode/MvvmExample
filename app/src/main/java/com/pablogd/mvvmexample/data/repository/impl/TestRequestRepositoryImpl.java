package com.pablogd.mvvmexample.data.repository.impl;

import com.pablogd.mvvmexample.data.service.NetworkGeneric;
import com.pablogd.mvvmexample.data.service.ResponseListener;
import com.pablogd.mvvmexample.data.models.CommonResponse;
import com.pablogd.mvvmexample.data.models.ResponseDto;
import com.pablogd.mvvmexample.data.repository.TestRequestRepository;
import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;

/**
 * TestRequestRepositoryImpl
 * Created by pablogutierrez on 17/12/18.
 */
public class TestRequestRepositoryImpl implements TestRequestRepository, ResponseListener<ResponseDto> {

    private OnTestRequestFinishListener mListener;
    private NetworkGeneric<ResponseDto> mNetworkGeneric;

    public TestRequestRepositoryImpl() {
        mNetworkGeneric = new NetworkGeneric<>(this);
    }

    @Override
    public void launchTestRequest(final OnTestRequestFinishListener listener) {
        mListener = listener;
        mNetworkGeneric.createInterface("1");
    }

    @Override
    public void onRequestSuccessObj(final ResponseDto responseObject) {
        mListener.onSuccess(responseObject);
    }

    @Override
    public void onRequestFail(final CommonResponse error) {
        mListener.onError(error.getMessage());
    }

    @Override
    public void invokeNetwork() {
        mNetworkGeneric.startRequest(mNetworkGeneric.getApiInterface().testRequest());
    }

    @Override
    public Class getTypeClass() {
        return ResponseDto.class;
    }
}
