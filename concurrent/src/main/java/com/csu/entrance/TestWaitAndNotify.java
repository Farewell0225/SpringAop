/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TestWaitAndNotify
 * Author:   yuanlin_csu
 * Date:     2019/6/4 17:13
 * Description: 测试wait与notify方法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.entrance;

import com.csu.concurrent.NotifyDemo;
import com.csu.concurrent.WaitDemo;
import com.csu.share.ShareObject;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试wait与notify方法〉
 *
 * @author yuanlin_csu
 * @create 2019/6/4
 * @since 1.0.0
 */
public class TestWaitAndNotify {

    @Test
    public void test(){
        // 共享变量
        ShareObject shareObject = new ShareObject();

        Thread threadWait = new Thread(new WaitDemo(shareObject));
        Thread threadNotify = new Thread(new NotifyDemo(shareObject));

        threadWait.start();
        // 线程启动谁先获取到资源，不一致，这里确保 wait线程先执行
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

        // 再睡一次，避免当前线程直接结束
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
