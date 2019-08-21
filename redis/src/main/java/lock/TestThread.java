/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: TestThread
 * Author:   yuanlin_csu
 * Date:     2019/8/14 17:06
 * Description: �߳�����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package lock;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * ��һ�仰���ܼ�����<br>
 * ���߳�����
 *
 * @author yuanlin_csu
 * @create 2019/8/14
 * @since 1.0.0
 */
public class TestThread implements Runnable {

    // ����Ĺ�������key
    private String key;
    // ��������key������ʱ�����ô�ֵ
    private String vlaue;

    // ��������key
    private String sysKey;
    // private String sysDataValue;

    private Jedis jedis;

    private long timeOut;


    public TestThread() {
        super();
    }

    public TestThread(Jedis jedis, String key, String value, long timeOut, String sysKey) {
        super();
        this.jedis = jedis;
        this.key = key;
        this.timeOut = timeOut;
        this.vlaue = value;
        this.sysKey = sysKey;

    }


    public void run() {

        // ��ȡ�������ڳ�ʱ֮ǰ�ٴγ��Ի�ȡ�����ڼ�������ʱΪ������ֵ
        long startTime = System.currentTimeMillis();
        long endTime = startTime + this.timeOut;
        boolean gainLock = false;
        Pipeline pipeline = jedis.pipelined();

        while (System.currentTimeMillis() < endTime) {

            if (jedis.setnx(key, Thread.currentThread().getName()) == 1) {
                // ��ȡ���ɹ�
                System.out.println("�߳� " + Thread.currentThread().getName() + " ��ȡ���ɹ�");
                gainLock = true;
                break;
            }else{
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (!gainLock) {
            // ��ʱΪ��ʱ���
            System.out.println("�߳� " + Thread.currentThread().getName() + " ��ʱ");
            // ʹ������ִ��
            releaseLock(jedis, key, Thread.currentThread().getName());
            System.out.println("�߳� " + Thread.currentThread().getName() + " �ͷ����ɹ�1,key=" + key);
            return;
        }

        // ��ʱ���ѻ�ȡ����
        // 0-value�Ѵ���ʱ���أ�1-�³�Ա����ʱ����

        long redLong = jedis.sadd(sysKey, Thread.currentThread().getName());
        System.out.println("redLong = " + redLong);
        if (redLong == 0) {
            System.out.println("�߳� " + Thread.currentThread().getName() + " �����ظ�");
            releaseLock(jedis, key, Thread.currentThread().getName());
            System.out.println("�߳� " + Thread.currentThread().getName() + " �ͷ����ɹ�2,key=" + key);
            return;
        } else {

            releaseLock(jedis, key, Thread.currentThread().getName());
            System.out.println("�߳� " + Thread.currentThread().getName() + " �ͷ����ɹ�3,key=" + key);
            return;
        }


    }

    // �ͷ���
    private void releaseLock(Jedis jedis, String lockKey, String lockValue) {
        // ������ʽִ��
        //Pipeline pipeline = jedis.pipelined();
       // Response<String> rsponse = pipeline.get(lockKey);
        String strRes = jedis.get(lockKey);
        System.out.println("strRes = " + strRes);
        // ���ͷ����Ի��ƣ��ж�
        String threadLocalName = Thread.currentThread().getName();
        while (true) {
            jedis.watch(lockKey);
            System.out.println("threadLocalName = " + threadLocalName);
            if (StringUtils.equals(strRes,threadLocalName)) {
                Transaction multi = jedis.multi();
                multi.del(key);
                multi.exec();
                jedis.unwatch();
                jedis.close();
                System.out.println("�ͷųɹ� �� " + threadLocalName);
                break;
            }
            jedis.unwatch();
        }

    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();

        System.out.println("long = " + l);
        while(System.currentTimeMillis() < (l + 10000)){
            System.out.println("long2 = " + System.currentTimeMillis());
        }
        System.out.println("long + 10000 = " + (l + 10000));

    }

}
