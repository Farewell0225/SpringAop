/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: MyTask
 * Author:   yuanlin_csu
 * Date:     2019/5/6 13:48
 * Description: 测试任务线程
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

/**
 * 〈打印当前线程id 然后当前线程沉睡1秒后退出，使用sleep方法挂起后沉睡指定时间后继续执行，其沉睡期间并不出让cpu资源〉<br>
 * 〈测试任务线程〉
 *
 * @author yuanlin_csu
 * @create 2019/5/6
 * @since 1.0.0
 */
public class MyTask implements Runnable {


    public void run() {
        System.out.println(System.currentTimeMillis() / 1000 + "Thread ID : " + Thread.currentThread().getId());

        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
