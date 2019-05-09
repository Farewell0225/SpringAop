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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程池newFiexThreadPool〉
 *
 * @author yuanlin_csu
 * @create 2019/5/6
 * @since 1.0.0
 */
public class SingleThreadExecutorDemo {

    public SingleThreadExecutorDemo(){
        super();
    }

    public static void main(String []args){

        /**
         * 创建单一线程处理任务，并行转串行，并发任务进入队列先入先出。
         * 所有任务线程id相同表明单线程执行。
         */

        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for ( int i = 0;i <10;i++){

            executorService.submit(task);

        }

        executorService.shutdown();

    }

}
