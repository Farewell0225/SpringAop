/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: NotifyDemo
 * Author:   yuanlin_csu
 * Date:     2019/6/4 17:02
 * Description: ���ѷ���demo
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.concurrent;

import com.csu.share.ShareObject;

import java.util.concurrent.TimeUnit;

/**
 * ��һ�仰���ܼ�����<br>
 * �����ѷ���demo��
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
            System.out.println("Notify get Lock ������");
            // ��Ȼ ���������̣߳�����Դ���������ͷ���Ҫ�ȴ����߳�ִ�����
            shareObject.notify();

            System.out.println("notify be excute!!!");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("notify sleep Exception!!!");
                e.printStackTrace();
            }

        }

        // ���߳�ִ������˳���
        System.out.println("notify be ending !!!");


    }
}
