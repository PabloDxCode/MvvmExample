package com.pablogd.mvvmexample.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TestingUtils
 * Created by pablogutierrez on 20/12/18.
 */
public class TestingUtils {

    public static boolean isIpAddress(String ipAddress) {
        final String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        final Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        final Matcher matcher = pattern.matcher(ipAddress);
        return matcher.matches();
    }

}
