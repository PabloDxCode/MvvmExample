package com.pablogd.mvvmexample.data.service;

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;
import com.pablogd.mvvmexample.data.models.CommonResponse;
import com.pablogd.mvvmexample.env.Environment;

import java.net.SocketTimeoutException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * NetworkDummy
 * Created by evaltierrah on 14/09/17.
 */
public class NetworkGeneric<T> {

    /**
     * Listener for answers
     */
    private ResponseListener responseListener;
    /**
     * Instance of consumer on next
     */
    private Consumer onNext;
    /**
     * Instance of consumer on error
     */
    private Consumer onError;
    /**
     * Instance of apiInterface
     */
    private ConnectionApiService apiInterface;
    /**
     * Retrofit instance
     */
    private final Retrofit mRetrofit;

    /**
     * Constructor
     */
    public NetworkGeneric(final ResponseListener<T> responseListener) {
        final RetrofitClient retrofitClient = new RetrofitClient();
        final OkHttpClient okHttpClient = retrofitClient.getOkHttpClient(retrofitClient.getLoggingInterceptor());
        mRetrofit = retrofitClient.getRetrofitBuilder(okHttpClient);
        this.responseListener = responseListener;

        onNext = (Consumer<T>) responseListener::onRequestSuccessObj;

        onError = (Consumer<Throwable>) throwable -> {
            final CommonResponse response = new CommonResponse();
            if (throwable instanceof SocketTimeoutException) {
                response.setCode(ConstantsService.CODE_TIMEOUT);
                response.setMessage(ConstantsService.MESSAGE_TIMEOUT);
                responseListener.onRequestFail(response);
            } else {
                if (throwable instanceof HttpException) {
                    response.setMessage(((HttpException) throwable).response().message());
                    if (response.getMessage().equals("")) {
                        response.setMessage(ConstantsService.MESSAGE_GENERIC);
                    }
                    response.setCode(String.valueOf(((HttpException) throwable).response().code()));
                    responseListener.onRequestFail(response);
                } else {
                    response.setMessage(ConstantsService.MESSAGE_GENERIC);
                    response.setCode("");
                    responseListener.onRequestFail(response);
                }
            }
        };
    }

    /**
     * Method to create interface
     */
    public void createInterface(final String idOperation) {
        apiInterface = mRetrofit.create(ConnectionApiService.class);
        if(Environment.SIMULATION){
            new SimulationServices<T>(idOperation, responseListener).simulationResponse();
        } else {
            responseListener.invokeNetwork();
        }
    }

    /**
     * Method to start request
     *
     * @param observable observable instance
     */
    @SuppressWarnings("unchecked")
    public void startRequest(final Observable<?> observable) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError);
    }

    /**
     * Method to get api interface
     *
     * @return connection api service dummy
     */
    public ConnectionApiService getApiInterface() {
        return apiInterface;
    }
}
