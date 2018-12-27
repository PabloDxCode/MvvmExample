package com.pablogd.mvvmexample.app.model_view;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.Observer;

import com.pablogd.mvvmexample.app.view_model.MainViewModel;
import com.pablogd.mvvmexample.data.service.EnvironmentConfig;
import com.pablogd.mvvmexample.domain.user_cases.TestRequest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * MainViewModelTest
 * Created by pablogutierrez on 21/12/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    private MainViewModel mainViewModel;

    @Mock
    private Observer<String> responsetestMLD;

    @Mock
    private Observer<Boolean> isLoadingMLD;

    @Mock
    private Observer<String> mErrorMessageMLD;

    @Before
    public void setUp() throws Exception {
        mainViewModel = new MainViewModel();
        mainViewModel.getResponseMutableLiveData().observeForever(responsetestMLD);
        mainViewModel.getIsLoading().observeForever(isLoadingMLD);
        mainViewModel.getErrorMessage().observeForever(mErrorMessageMLD);
    }

    @Test
    public void shouldCreateTestRequest_whenViewModelIsCreated() throws Exception {
        final TestRequest testRequest = mainViewModel.getTestRequest();
        assertNotNull(testRequest);
    }

    @Test
    public void shouldGetTestResponse_whenLaunchTestRequestFromViewModel() throws Exception {
        EnvironmentConfig.getInstance().initSimulation(getTestResponse());
        mainViewModel.launchTestRequest();
        verify(responsetestMLD).onChanged("177.231.48.206");
    }

    @Test
    public void shouldGetTestResponseError_whenLaunchTestRequestFromViewModel() throws Exception {
        EnvironmentConfig.getInstance().initSimulation(getTestResponseError());
        mainViewModel.launchTestRequest();
        verify(mErrorMessageMLD).onChanged("El objeto com.pablogd.mvvmexample.data.models.ResponseDto no coincide con la respuesta \"\"");
    }

    /**
     * Method to get response to test
     *
     * @return map
     */
    public static Map<String, String> getTestResponse() {
        final Map<String, String> simulationResponse = new HashMap<>();
        simulationResponse.put("1", "{\n" +
                "  \"args\": {}, \n" +
                "  \"headers\": {\n" +
                "    \"Accept\": \"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8\", \n" +
                "    \"Accept-Encoding\": \"gzip, deflate, br\", \n" +
                "    \"Accept-Language\": \"es-ES,es;q=0.9,en;q=0.8\", \n" +
                "    \"Connection\": \"close\", \n" +
                "    \"Host\": \"httpbin.org\", \n" +
                "    \"Upgrade-Insecure-Requests\": \"1\", \n" +
                "    \"User-Agent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36\"\n" +
                "  }, \n" +
                "  \"origin\": \"177.231.48.206\", \n" +
                "  \"url\": \"https://httpbin.org/get\"\n" +
                "}");
        return simulationResponse;
    }

    /**
     * Method to get response to test
     *
     * @return map
     */
    public static Map<String, String> getTestResponseError() {
        final Map<String, String> simulationResponseError = new HashMap<>();
        simulationResponseError.put("1", "");
        return simulationResponseError;
    }

}
