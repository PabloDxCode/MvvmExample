package com.pablogd.mvvmexample.domain;

import com.pablogd.mvvmexample.domain.user_cases.TestRequest;
import com.pablogd.mvvmexample.domain.user_cases.TestRequestImpl;

/**
 * UserCasesFactory
 * Created by pablogutierrez on 17/12/18.
 */
public class UserCasesFactory {

    private UserCasesFactory() {
    }

    public static UserCasesFactory getUserCasesFactory(){
        return new UserCasesFactory();
    }

    public TestRequest getTestRequest(){
        return new TestRequestImpl();
    }

}
