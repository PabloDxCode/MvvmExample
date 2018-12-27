package com.pablogd.mvvmexample.data.repository.impl;

import com.pablogd.mvvmexample.data.models.ResponseDto;
import com.pablogd.mvvmexample.data.repository.TestRequestRepository;
import com.pablogd.mvvmexample.data.service.EnvironmentConfig;
import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;
import com.pablogd.mvvmexample.utils.TestingResponse;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TestRequestRepositoryImplTest
 * Created by pablogutierrez on 18/12/18.
 */
public class TestRequestRepositoryImplTest {

    private TestRequestRepository mTestRequestRepository;

    @Before
    public void setUp() throws Exception {
        mTestRequestRepository = new TestRequestRepositoryImpl();
    }

    @Test
    public void shouldGetTestResponse_whenLaunchTestRequest() throws Exception {
        EnvironmentConfig.getInstance().initSimulation(TestingResponse.getTestResponse());
        mTestRequestRepository.launchTestRequest(new OnTestRequestFinishListener() {
            @Override
            public void onSuccess(final ResponseDto responseDto) {
                Assert.assertNotNull(responseDto);
            }

            @Override
            public void onError(final String error) {}
        });
    }

    @Test
    public void shouldGetTestResponseError_whenLaunchTestRequest() throws Exception {
        EnvironmentConfig.getInstance().initSimulation(TestingResponse.getTestResponseError());
        mTestRequestRepository.launchTestRequest(new OnTestRequestFinishListener() {
            @Override
            public void onSuccess(final ResponseDto responseDto) {}

            @Override
            public void onError(final String error) {
                Assert.assertNotNull(error);
            }
        });
    }
}