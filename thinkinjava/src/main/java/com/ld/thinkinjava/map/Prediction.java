package com.ld.thinkinjava.map;

/**
 * Created by liudun on 2017/6/21.
 */
public class Prediction {

    boolean shadow = Math.random() > 0.5;

    @Override
    public String toString(){
        if (shadow) return "six more weeks of winter!";
        else return "early spring!";
    }
}