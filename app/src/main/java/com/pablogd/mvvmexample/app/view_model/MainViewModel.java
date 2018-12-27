package com.pablogd.mvvmexample.app.view_model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.pablogd.mvvmexample.data.models.ResponseDto;
import com.pablogd.mvvmexample.domain.UserCasesFactory;
import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;
import com.pablogd.mvvmexample.domain.user_cases.TestRequest;

/**
 * MainViewModel
 * Created by pablogutierrez on 16/12/18.
 */
public class MainViewModel extends BaseViewModel implements OnTestRequestFinishListener {

    private TestRequest mTestRequest;

    /**
     * Mutable live data for loading behaviour
     */
    private final MutableLiveData<String> mResponse;

    public MainViewModel() {
        mTestRequest = UserCasesFactory.getUserCasesFactory().getTestRequest();
        mResponse = new MutableLiveData<>();
    }

    public void launchTestRequest(){
        mIsLoading.setValue(Boolean.TRUE);
        mTestRequest.startTestRequest(this);
    }

    public LiveData<String> getResponseMutableLiveData(){
        return mResponse;
    }

    @Override
    public void onSuccess(ResponseDto responseDto) {
        mIsLoading.setValue(Boolean.FALSE);
        mResponse.setValue(responseDto.getOrigin());
    }

    @Override
    public void onError(String error) {
        mIsLoading.setValue(Boolean.FALSE);
        mErrorMessage.setValue(error);
    }

    public TestRequest getTestRequest(){
        return mTestRequest;
    }

}
