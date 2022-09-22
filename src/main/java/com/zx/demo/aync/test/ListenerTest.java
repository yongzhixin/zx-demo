package com.zx.demo.aync.test;

import com.zx.demo.aync.DefaultListenerFunture;
import com.zx.demo.aync.Listener;
import com.zx.demo.aync.ListenerFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ListenerTest {

    public static void main(String[] args) {
        DefaultListenerFunture<String> future = new DefaultListenerFunture(() -> {
            System.out.println("异步执行中...");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("异步执行结束...");
            return "返回结果";
        });
        future.addListener(new Listener() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (!future.isDone()) {
                    return;
                }
                Object o = future.get();
                System.out.println("执行Listener...");
                System.out.println(o);
            }
        });
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(future);
        new Thread(future).start();
    }

}
