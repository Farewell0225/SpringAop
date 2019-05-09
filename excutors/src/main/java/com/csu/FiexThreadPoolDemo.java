/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: FiexThreadPoolDemo
 * Author:   yuanlin_csu
 * Date:     2019/5/6 13:46
 * Description: 线程池newFiexThreadPool
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程池newFiexThreadPool〉
 *
 * @author yuanlin_csu
 * @create 2019/5/6
 * @since 1.0.0
 */
public class FiexThreadPoolDemo {

    public FiexThreadPoolDemo(){
        super();
    }

    public static void main(String []args){

        /**
         * 创建线程数固定为5的线程池，MyTask 中打印当前线程的id 值之后沉睡一秒后结束，使当前线程
         * 空闲，可被其余任务使用，则输出结果id值相同的 线程相距的时间间隔 为1000左右
         */

        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for ( int i = 0;i <10;i++){

            executorService.submit(task);

        }

    }

}
