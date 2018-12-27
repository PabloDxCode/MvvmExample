package com.pablogd.mvvmexample.data.service;

import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import static org.junit.Assert.*;

/**
 * RetrofitClientTest
 * Created by pablogutierrez on 18/12/18.
 */
public class RetrofitClientTest {

    private RetrofitClient mRetrofitClient;

    @Before
    public void setUp() throws Exception {
        mRetrofitClient = new RetrofitClient();
    }

    @Test
    public void shouldGetLogginInterceptor_whenAskToRetrofitClient() throws Exception {
        final HttpLoggingInterceptor loggingInterceptor = mRetrofitClient.getLoggingInterceptor();
        Assert.assertNotNull(loggingInterceptor);
    }

    @Test
    public void shouldGetOkHttpClient_whenAskToRetrofitClient() throws Exception {
        final HttpLoggingInterceptor loggingInterceptor = mRetrofitClient.getLoggingInterceptor();
        final OkHttpClient okHttpClient = mRetrofitClient.getOkHttpClient(loggingInterceptor);
        Assert.assertNotNull(okHttpClient);
    }

    @Test
    public void shouldGetRetrofitInstance_whenAskToRetrofitClient() throws Exception {
        final HttpLoggingInterceptor loggingInterceptor = mRetrofitClient.getLoggingInterceptor();
        final OkHttpClient okHttpClient = mRetrofitClient.getOkHttpClient(loggingInterceptor);
        final Retrofit retrofit = mRetrofitClient.getRetrofitBuilder(okHttpClient);
        Assert.assertNotNull(retrofit);
    }

    @Test
    public void shouldGetGsonBuilder_whenAskToRetrofitClient() throws Exception {
        final GsonBuilder gsonBuilder = mRetrofitClient.getGsonBuilder();
        Assert.assertNotNull(gsonBuilder);
    }

}