/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: NotifyDemo
 * Author:   yuanlin_csu
 * Date:     2019/6/4 17:02
 * Description: 唤醒方法demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.concurrent;

import com.csu.share.ShareObject;

import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈唤醒方法demo〉
 *
 * @author yuanlin_csu
 * @create 2019/6/4
 * @since 1.0.0
 */
public class NotifyDemo implements Runnable {

    private ShareObject shareObject;

    public NotifyDemo() {
        super();
    }

    public NotifyDemo(ShareObject shareObject) {
        this.shareObject = shareObject;
    }


    public void run() {

        synchronized (shareObject) {
            System.out.println("Notify get Lock ！！！");
            // 虽然 唤起其他线程，但资源不会立即释放需要等待本线程执行完毕
            shareObject.notify();

            System.out.println("notify be excute!!!");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("notify sleep Exception!!!");
                e.printStackTrace();
            }

        }

        // 本线程执行完才退出。
        System.out.println("notify be ending !!!");


    }
}
