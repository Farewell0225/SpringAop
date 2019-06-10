/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: WaitDemo
 * Author:   yuanlin_csu
 * Date:     2019/6/4 16:51
 * Description: wait�����߳�demo
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.concurrent;

import com.csu.share.ShareObject;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��wait�����߳�demo��
 *
 * @author yuanlin_csu
 * @create 2019/6/4
 * @since 1.0.0
 */
public class WaitDemo implements Runnable{

    private ShareObject shareObject;

    public WaitDemo(){
        super();
    }

    public WaitDemo(ShareObject shareObject){
        this.shareObject = shareObject;
    }

    public void run() {

        // ���ù�������wait() �� notify() ����ʱ ����Թ�������������򱨴�
        synchronized (shareObject){
            System.out.println("wait get lock!!!");

            try {
                // ��ǰ�̻߳ᱻֱ�ӹ���
                shareObject.wait();
            } catch (InterruptedException e) {
                System.out.println("wait Exception");
                e.printStackTrace();
            }

            System.out.println("test wait 1");

        }

        System.out.println("test wait 2");

    }
}
