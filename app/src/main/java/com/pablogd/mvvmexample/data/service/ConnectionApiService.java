package com.pablogd.mvvmexample.data.service;

import com.pablogd.mvvmexample.data.models.ResponseDto;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

/**
 * ConnectionApiServiceDummy
 * Created by evaltierrah on 14/09/17.
 */
public interface ConnectionApiService {

    /**
     * Method that launch test request
     *
     * @return returns an object with the server response
     */
    @GET("get")
    Observable<ResponseDto> testRequest();

}
