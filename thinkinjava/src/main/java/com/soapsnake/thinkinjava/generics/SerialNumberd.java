package com.soapsnake.thinkinjava.generics;

/**
 * Created by soapsnake on 2017/7/16.
 */
public class SerialNumberd extends Decorator {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public SerialNumberd(Basic basic) {
        super(basic);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}
