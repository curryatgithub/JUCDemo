package com.atguigu.demo;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Tickets{

    private int numbers = 50;

    /*public synchronized void sale(){
        if (numbers> 0){
            System.out.println(Thread.currentThread().getName()+
                    "\t"+"卖出第："+(51-numbers--)+"\t还剩下："+numbers);
        }
    }*/

    Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (numbers > 0){
                System.out.println(Thread.currentThread().getName()+
                        "\t"+"卖出第："+(51-numbers--)+"\t还剩下："+numbers);
            }
        }finally {
            lock.unlock();
        }
    }

}

public class SaleTicketDemo {
    public static void main(String[] args) {
        /**
         * 三个售票员    卖出      50张票
         * 如何编写企业级需要的工程化代码？
         *
         * 1 在高内聚低耦合的前提下，线程 操作  资源类,多线程开发中，一言不合先new一个资源类,线程对资源类进行什么样的操作？
         */
        //1.继承 2.new三个线程
       // Thread(Runnable target,String a)
        Tickets tickets = new Tickets();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <1000; i++) {
                    tickets.sale();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    tickets.sale();
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    tickets.sale();
                }
            }
        }, "C").start();*/

        new Thread(() -> {for (int i=0;i<20;i++) tickets.sale();},"a").start();
        new Thread(() -> {for (int i=0;i<20;i++) tickets.sale();},"b").start();
        new Thread(() -> {for (int i=0;i<20;i++) tickets.sale();},"c").start();
    }
}