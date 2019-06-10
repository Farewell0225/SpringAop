/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: JoinTask
 * Author:   yuanlin_csu
 * Date:     2019/6/4 19:55
 * Description: join方法测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈join方法测试〉
 *
 * @author yuanlin_csu
 * @create 2019/6/4
 * @since 1.0.0
 */
public class JoinTask implements Runnable {

    private Thread joinThread = null;
    private int count;

    public JoinTask(){
        super();
    }

    public JoinTask(int count){
        this.count = count;
    }

    public JoinTask(int count,Thread joinThread){
        this.count = count;
        this.joinThread = joinThread;
    }


    public void run() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("task count : " + count + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());

        if (joinThread != null){
            System.out.println("current task count : " + count + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());
            System.out.println("start join" + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());

            try {

                joinThread.start();

                joinThread.join();
                System.out.println("end join continue task count ： " + count + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                System.out.println("join exception!!!");
                e.printStackTrace();
            }
        }

        // 当前线程沉睡,防止执行join的线程未执行到时当前线程就退出。
        try {
            TimeUnit.SECONDS.sleep(count);
        } catch (InterruptedException e) {
            System.out.println("sleep exception task count : " + count);
            e.printStackTrace();
        }

        System.out.println("task over count ：" + count + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());
    }
}
