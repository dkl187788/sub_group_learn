package com.dukl.learn.base.httprequest;

/**
 * Created by adu on 2019/6/17.
 */
public class Config {
    private static int httpConnectTimeout = 60000;

    private static int httpSocketTimeout = 300000;

    private static int httpMaxPoolSize = 5;

    private static long httpIdelTimeout = 300 * 1000;

    private static long httpMonitorInterval = 120 * 1000;

    public static int getHttpConnectTimeout() {
        return httpConnectTimeout;
    }

    public static void setHttpConnectTimeout(int httpConnectTimeout) {
        Config.httpConnectTimeout = httpConnectTimeout;
    }

    public static int getHttpSocketTimeout() {
        return httpSocketTimeout;
    }

    public static void setHttpSocketTimeout(int httpSocketTimeout) {
        Config.httpSocketTimeout = httpSocketTimeout;
    }

    public static int getHttpMaxPoolSize() {
        return httpMaxPoolSize;
    }

    public static void setHttpMaxPoolSize(int httpMaxPoolSize) {
        Config.httpMaxPoolSize = httpMaxPoolSize;
    }

    public static long getHttpIdelTimeout() {
        return httpIdelTimeout;
    }

    public static void setHttpIdelTimeout(long httpIdelTimeout) {
        Config.httpIdelTimeout = httpIdelTimeout;
    }

    public static long getHttpMonitorInterval() {
        return httpMonitorInterval;
    }

    public static void setHttpMonitorInterval(long httpMonitorInterval) {
        Config.httpMonitorInterval = httpMonitorInterval;
    }
}
