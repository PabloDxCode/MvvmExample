package com.pablogd.mvvmexample.data.repository;

import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;

/**
 * TestRequestRepository
 * Created by pablogutierrez on 17/12/18.
 */
public interface TestRequestRepository {

    void launchTestRequest(OnTestRequestFinishListener listener);

}
