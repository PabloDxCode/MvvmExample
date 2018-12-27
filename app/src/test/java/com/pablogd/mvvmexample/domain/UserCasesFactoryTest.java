package com.pablogd.mvvmexample.domain;

import com.pablogd.mvvmexample.domain.user_cases.TestRequest;

import org.junit.Assert;
import org.junit.Test;

/**
 * UserCasesFactoryTest
 * Created by pablogutierrez on 18/12/18.
 */
public class UserCasesFactoryTest {

    private UserCasesFactory mUserCasesFactory;

    @Test
    public void shouldGetUserCasesInstance_whenAskToUserCasesFactory() throws Exception {
        mUserCasesFactory = UserCasesFactory.getUserCasesFactory();
        Assert.assertNotNull(mUserCasesFactory);
    }

    @Test
    public void shouldGetTestRequestInstance_whenAskToUserCasesFactory() throws Exception {
        mUserCasesFactory = UserCasesFactory.getUserCasesFactory();
        final TestRequest testRequest = UserCasesFactory.getUserCasesFactory().getTestRequest();
        Assert.assertNotNull(testRequest);
    }

}
