package com.soapsnake.concurrence.runnable.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrnamentalGarden {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Entrance(i));

            Thread.sleep(3000);
            Entrance.cancel();
            //executorService.shutdown();
            if (!executorService.awaitTermination(250, TimeUnit.MILLISECONDS))
                System.out.println("some tasks were not terminated : 某些线程没有被关闭");
            System.out.println("total: " + Entrance.getTotalCount());
            System.out.println("sum of Entrances: " + Entrance.sumEntrances());
        }
    }
}
