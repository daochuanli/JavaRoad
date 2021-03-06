package com.soapsnake.pattern.structurals.observerpattern.object;

import com.soapsnake.pattern.structurals.observerpattern.observer.ObserverConcreate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author soapsnake
 * 目标对象,负责处理具体的任务
 */
public class ObjectConcreateImpl extends ObjectConcreate {

    /**
     * 维护一个观察者集合,注册的观察者将会存放在这个集合当中,在这里出错了一次,记住这个集合实例是和目标对象绑定的
     */
    List<ObserverConcreate> observers = new ArrayList<ObserverConcreate>();
    private String objectContent;

    public String getObjectContent() {
        return objectContent;
    }

    public void setObjectContent(String objectContent) {
        this.objectContent = objectContent;                            //先设置object内容

        /**
         * 价格低于2400元才会广播
         */
        if (Integer.parseInt(objectContent) < 2400) notifyObserver();   //再进行通知

    }

    /**
     * 注册观察者
     */
    @Override
    public void registorObserver(ObserverConcreate observer) {
        observers.add(observer);
    }

    /**
     * 广播观察者,在设置目标content的时候会被调用,不需要再另外手动调用
     */
    @Override
    public void notifyObserver() {
        for (ObserverConcreate observer : observers) {
            observer.remind(this);
        }
    }

}
