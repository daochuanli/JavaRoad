package com.soapsnake.thinkinjava.generics;

/**
 * Created by soapsnake on 2017/7/9.
 */
public class Foo2<T> {

    private T x;

    public <F extends FactoryI<T>> Foo2(F factory) {
        x = factory.create();
    }
}
