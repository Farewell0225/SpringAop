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
public class CachedThreadPoolDemo {

    public CachedThreadPoolDemo(){
        super();
    }

    public static void main(String []args){

        /**
         * 创建可变大小线程池，
         */

        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for ( int i = 0;i <2000;i++){

            executorService.submit(task);

        }

        executorService.shutdown();

    }

}
