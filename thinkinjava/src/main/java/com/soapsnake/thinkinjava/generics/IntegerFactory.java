package com.soapsnake.thinkinjava.generics;

/**
 * Created by soapsnake on 2017/7/9.
 */
public class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create() {
        return new Integer(0);
    }
}
