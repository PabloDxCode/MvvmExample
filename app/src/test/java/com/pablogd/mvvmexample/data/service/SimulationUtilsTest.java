package com.pablogd.mvvmexample.data.service;

import com.pablogd.mvvmexample.data.models.CommonResponse;
import com.pablogd.mvvmexample.data.models.ResponseDto;
import com.pablogd.mvvmexample.utils.TestingResponse;
import com.pablogd.mvvmexample.utils.TestingUtils;

import org.junit.Assert;
import org.junit.Test;

/**
 * SimulationUtilsTest
 * Created by pablogutierrez on 18/12/18.
 */
public class SimulationUtilsTest {

    @Test
    public void shouldGetSimulationResponse_whenLaunchSimulationService() throws Exception {
        EnvironmentConfig.getInstance().initSimulation(TestingResponse.getTestResponse());
        new SimulationServices<ResponseDto>("1", new ResponseListener<ResponseDto>() {

            @Override
            public void onRequestSuccessObj(final ResponseDto responseObject) {
                Assert.assertNotNull(responseObject);
                Assert.assertTrue(TestingUtils.isIpAddress(responseObject.getOrigin()));
            }

            @Override
            public void onRequestFail(final CommonResponse error) {}

            @Override
            public void invokeNetwork() {}

            @Override
            public Class getTypeClass() {
                return ResponseDto.class;
            }
        }).simulationResponse();
    }

    @Test
    public void shouldGetSimulationResponseError_whenLaunchSimulationService() throws Exception {
        EnvironmentConfig.getInstance().initSimulation(TestingResponse.getTestResponseError());
        new SimulationServices<ResponseDto>("1", new ResponseListener<ResponseDto>() {

            @Override
            public void onRequestSuccessObj(final ResponseDto responseObject) {}

            @Override
            public void onRequestFail(final CommonResponse error) {
                Assert.assertNotNull(error);
                Assert.assertEquals(ConstantsService.CODE_TIMEOUT, error.getCode());
            }

            @Override
            public void invokeNetwork() {}

            @Override
            public Class getTypeClass() {
                return ResponseDto.class;
            }
        }).simulationResponse();
    }

}