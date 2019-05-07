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

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ��һ�仰���ܼ�����<br> 
 * ���̳߳�newFiexThreadPool��
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
         * �����߳����̶�Ϊ5���̳߳أ�MyTask �д�ӡ��ǰ�̵߳�id ֵ֮���˯һ��������ʹ��ǰ�߳�
         * ���У��ɱ���������ʹ�ã���������idֵ��ͬ�� �߳�����ʱ���� Ϊ1000����
         */

        // ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        MyTask task = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for ( int i = 0;i <10;i++){

            executorService.submit(task);

        }

    }

}
