package com.AutoTrader.utilities;

public class BrowsilUtils {

    public static void wait(int seconds){

        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {

        }
    }
}
