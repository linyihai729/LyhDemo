package com.example.common2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class test {
    private int i = 10;
    private Object object = new Object();
    private static ArrayList<String> arrayList = null;
    private static LinkedList<String> linkedList = new LinkedList<>();
    private static Map<String, String> map = new HashMap<>();
    private static int sum = 128;
    private static double d1 = 0.1299, d2 = 0.124;
    private static char c1='鰀';


    public static void main(String[] args) throws IOException {
//        byte s = (byte) sum;
//        System.out.println(s + "");
//        if (Double.compare(d1, d2) >= 0) {
//            System.out.println(d1 + "!!");
//        } else {
//            System.out.println(d2 + "!!!");
//        }
//        System.out.print(c1+0);
        Dog dog= new Dog();
        dog.move();
    }


    class MyThread extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                i++;
                System.out.println("i:" + i);
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
                i++;
                System.out.println("i:" + i);
            }
        }
    }
}
