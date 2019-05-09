/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: FiexThreadPoolDemo
 * Author:   yuanlin_csu
 * Date:     2019/5/6 13:46
 * Description: �̳߳�newFiexThreadPool
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��һ�仰���ܼ�����<br> 
 * ���̳߳�newFiexThreadPool��
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
         * ������һ�̴߳������񣬲���ת���У��������������������ȳ���
         * ���������߳�id��ͬ�������߳�ִ�С�
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
