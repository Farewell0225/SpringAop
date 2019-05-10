/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Son
 * Author:   yuanlin_csu
 * Date:     2019/5/7 21:25
 * Description: son
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈son〉
 *
 * @author yuanlin_csu
 * @create 2019/5/7
 * @since 1.0.0
 */
public class Son implements Cloneable {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {



            if (i == 0) {
                String stm = Integer.toString(i);
                Test test = new Test(stm);
                executorService.submit(test);
            } else{
                Test test = new Test();
                executorService.submit(test);
            }




        }


        executorService.shutdown();

       System.out.println(threadLocal.get());





    }
}

class Test extends Thread  implements Runnable {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    private String st = "1";

    public Test() {
        super();
    }

    public Test(String str) {

        this.st = str;
    }

    @Override
    public void run() {
        threadLocal.set(st);
        System.out.println("Thread ID : " + Thread.currentThread().getId() + " ori = " + st + " str = "+ threadLocal.get() + "ThreadLocal" + threadLocal);

        if ( !st.equals("1") ){
            try {
                Thread.sleep(1000);
                System.out.println("1111111111");
                System.out.println("Thread ID : " + Thread.currentThread().getId() + "ori = " + st + " str = "+ threadLocal.get() + "ThreadLocal" + threadLocal);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
