/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: TestWaitAndNotify
 * Author:   yuanlin_csu
 * Date:     2019/6/4 17:13
 * Description: ����wait��notify����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.entrance;

import com.csu.concurrent.NotifyDemo;
import com.csu.concurrent.WaitDemo;
import com.csu.share.ShareObject;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * ��һ�仰���ܼ�����<br> 
 * ������wait��notify������
 *
 * @author yuanlin_csu
 * @create 2019/6/4
 * @since 1.0.0
 */
public class TestWaitAndNotify {

    @Test
    public void test(){
        // �������
        ShareObject shareObject = new ShareObject();

        Thread threadWait = new Thread(new WaitDemo(shareObject));
        Thread threadNotify = new Thread(new NotifyDemo(shareObject));

        threadWait.start();
        // �߳�����˭�Ȼ�ȡ����Դ����һ�£�����ȷ�� wait�߳���ִ��
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("test exception!!!");
            e.printStackTrace();
        }

        System.out.println("wait state : " + threadWait.getState());
        assertEquals("WAITING",threadWait.getState().toString());

        threadNotify.start();

      /*  try {
            Thread.currentThread().join();
            System.out.println("join end!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // ��˯һ�Σ����⵱ǰ�߳�ֱ�ӽ���
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("wait state2 : " + threadWait.getState().toString());
        } catch (InterruptedException e) {
            System.out.println("test exception!!!");
            e.printStackTrace();
        }

        System.out.println("notify state : " + threadNotify.getState());

        System.out.println("end!!!");


    }


}
