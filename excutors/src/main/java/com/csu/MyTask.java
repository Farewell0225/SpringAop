/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: MyTask
 * Author:   yuanlin_csu
 * Date:     2019/5/6 13:48
 * Description: ���������߳�
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu;

/**
 * ����ӡ��ǰ�߳�id Ȼ��ǰ�̳߳�˯1����˳���ʹ��sleep����������˯ָ��ʱ������ִ�У����˯�ڼ䲢������cpu��Դ��<br>
 * �����������̡߳�
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
