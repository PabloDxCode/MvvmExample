package com.pablogd.mvvmexample.data.service;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.pablogd.mvvmexample.BuildConfig;
import com.pablogd.mvvmexample.domain.utils.LogUtils;
import com.pablogd.mvvmexample.env.Environment;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * NetworkModule
 * Created by pablogutierrez on 08/09/18.
 */
public class RetrofitClient {

    public HttpLoggingInterceptor getLoggingInterceptor() {
        final String TAG_REQUEST = "OkHttp";
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            /**
             * log
             * @param message message
             */
            @Override
            public void log(@NonNull final String message) {
                LogUtils.build(TAG_REQUEST, message).d();
            }
        });
    }

    public OkHttpClient getOkHttpClient(final HttpLoggingInterceptor loggingInterceptor) {
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public Retrofit getRetrofitBuilder(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(Environment.URL_SERVICE)
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(getGsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @NonNull
    public GsonBuilder getGsonBuilder() {
        return new GsonBuilder()
                .setLenient();
    }

}
