package com.pablogd.mvvmexample.domain.user_cases;

import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;

/**
 * TestRequest
 * Created by pablogutierrez on 17/12/18.
 */
public interface TestRequest {

    void startTestRequest(OnTestRequestFinishListener listener);

}
