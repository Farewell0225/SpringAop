/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: TestJoin
 * Author:   yuanlin_csu
 * Date:     2019/6/4 19:54
 * Description: ����join����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.entrance;

import com.csu.concurrent.JoinTask;
import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ������join������
 *
 * @author yuanlin_csu
 * @create 2019/6/4
 * @since 1.0.0
 */
public class TestJoin {

    @Test
    public void testJoin() throws InterruptedException {

        System.out.println("test state : " + Thread.currentThread().getState());
        Thread thread3 = new Thread(new JoinTask(3));
        Thread thread1 = new Thread(new JoinTask(1,thread3));

        thread3.setName("thread3");
        thread1.setName("thread1");

        thread1.start();
        System.out.println("test state2 : " + Thread.currentThread().getState());
        System.out.println("thread3 state : " + thread3.getState());
        System.out.println("thread1 state : " + thread1.getState());
        thread1.join();
        System.out.println("test state3 : " + Thread.currentThread().getState());
        System.out.println("thread3 state1 : " + thread3.getState());
        System.out.println("thread1 state1 : " + thread1.getState());
        Thread.currentThread().setName("test");
        System.out.println("end test name = " + Thread.currentThread().getName());



    }



}
