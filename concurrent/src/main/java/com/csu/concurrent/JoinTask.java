/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: JoinTask
 * Author:   yuanlin_csu
 * Date:     2019/6/4 19:55
 * Description: join��������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��join�������ԡ�
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
                System.out.println("end join continue task count �� " + count + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());
            } catch (InterruptedException e) {
                System.out.println("join exception!!!");
                e.printStackTrace();
            }
        }

        // ��ǰ�̳߳�˯,��ִֹ��join���߳�δִ�е�ʱ��ǰ�߳̾��˳���
        try {
            TimeUnit.SECONDS.sleep(count);
        } catch (InterruptedException e) {
            System.out.println("sleep exception task count : " + count);
            e.printStackTrace();
        }

        System.out.println("task over count ��" + count + " = " + Thread.currentThread().getName() + " State : " + Thread.currentThread().getState());
    }
}
