package com.zx;


import java.util.concurrent.TimeUnit;

class RecorderTest {


    public static void main(String[] args) {
        RecorderExample recorder = new RecorderExample();

//        new Thread(recorder::reader).start();
        new Thread(recorder::writer).start();
        new Thread(recorder::reader).start();



    }

}

class RecorderExample {

    int x = 0;
    boolean flag = false;

    public void writer() {
        x = 42; //1
        flag = true; //2
    }

    public void reader() {
        if (flag) { //3
            System.out.println(x); //4 }
        }
    }
}