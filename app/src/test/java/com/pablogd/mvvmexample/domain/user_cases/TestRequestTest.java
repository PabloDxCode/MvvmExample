package com.pablogd.mvvmexample.domain.user_cases;

import com.pablogd.mvvmexample.data.models.ResponseDto;
import com.pablogd.mvvmexample.data.service.EnvironmentConfig;
import com.pablogd.mvvmexample.domain.UserCasesFactory;
import com.pablogd.mvvmexample.domain.listeners.OnTestRequestFinishListener;
import com.pablogd.mvvmexample.utils.TestingResponse;
import com.pablogd.mvvmexample.utils.TestingUtils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * MainViewModelTest
 * Created by pablogutierrez on 17/12/18.
 */
public class TestRequestTest {

    private TestRequest mTestRequest;

    @Before
    public void setUp() throws Exception {
        mTestRequest = UserCasesFactory.getUserCasesFactory().getTestRequest();
    }

    @Test
    public void shouldGetTestResponse_whenLaunchTestRequest(){
        EnvironmentConfig.getInstance().initSimulation(TestingResponse.getTestResponse());
        mTestRequest.startTestRequest(new OnTestRequestFinishListener() {
            @Override
            public void onSuccess(final ResponseDto responseDto) {
                Assert.assertNotNull(responseDto);
                Assert.assertTrue(TestingUtils.isIpAddress(responseDto.getOrigin()));
            }

            @Override
            public void onError(final String error) {
                Assert.assertNotNull(error);
            }
        });
    }

    @Test
    public void shouldGetTestResponseError_whenLaunchTestRequest(){
        EnvironmentConfig.getInstance().initSimulation(TestingResponse.getTestResponseError());
        mTestRequest.startTestRequest(new OnTestRequestFinishListener() {
            @Override
            public void onSuccess(final ResponseDto responseDto) {
                Assert.assertNotNull(responseDto);
                Assert.assertTrue(TestingUtils.isIpAddress(responseDto.getOrigin()));
            }

            @Override
            public void onError(final String error) {
                Assert.assertNotNull(error);
            }
        });
    }

}
