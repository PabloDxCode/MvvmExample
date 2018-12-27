package com.pablogd.mvvmexample.domain.user_cases;

import com.pablogd.mvvmexample.data.repository.TestRequestRepository;
import com.pablogd.mvvmexample.data.repository.impl.TestRequestRepositoryImpl;
import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;

/**
 * TestRequestImpl
 * Created by pablogutierrez on 17/12/18.
 */
public class TestRequestImpl implements TestRequest {

    @Override
    public void startTestRequest(final OnTestRequestFinishListener listener) {
        final TestRequestRepository requestRepository = new TestRequestRepositoryImpl();
        requestRepository.launchTestRequest(listener);
    }

}
