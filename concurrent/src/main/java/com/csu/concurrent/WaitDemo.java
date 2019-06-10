/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: WaitDemo
 * Author:   yuanlin_csu
 * Date:     2019/6/4 16:51
 * Description: wait方法线程demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.concurrent;

import com.csu.share.ShareObject;

/**
 * 〈一句话功能简述〉<br> 
 * 〈wait方法线程demo〉
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

        // 调用共享对象的wait() 或 notify() 方法时 必须对共享变量加锁否则报错
        synchronized (shareObject){
            System.out.println("wait get lock!!!");

            try {
                // 当前线程会被直接挂起
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
