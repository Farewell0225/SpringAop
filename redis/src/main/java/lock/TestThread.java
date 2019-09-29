/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TestThread
 * Author:   yuanlin_csu
 * Date:     2019/8/14 17:06
 * Description: 线程任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
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
 * 〈一句话功能简述〉<br>
 * 〈线程任务〉
 *
 * @author yuanlin_csu
 * @create 2019/8/14
 * @since 1.0.0
 */
public class TestThread implements Runnable {

    // 传入的共享锁的key
    private String key;
    // 共享锁的key不存在时会设置此值
    private String vlaue;

    // 共享数据key
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

        // 获取锁，并在超时之前再次尝试获取锁，在键不存在时为键设置值
        long startTime = System.currentTimeMillis();
        long endTime = startTime + this.timeOut;
        boolean gainLock = false;
        Pipeline pipeline = jedis.pipelined();

        // 为锁设置超时时间，当无法获取到锁时为锁设置，并发下，影响不大，但是需判断，锁本身是否，存在超时时间
        while (System.currentTimeMillis() < endTime) {

            // setnx返回1 成功，0 失败
            if (jedis.setnx(key, Thread.currentThread().getName()) == 1) {
                // 获取锁成功,设置半小时超时
                jedis.expire(key,1800);
                System.out.println("线程 " + Thread.currentThread().getName() + " 获取锁成功");
                gainLock = true;
                break;

            }else if(jedis.ttl(key)==-1) {
               /**
                *  当 key 不存在时，返回 -2 。 当 key
                *  存在但没有设置剩余生存时间时，返回 -1 。
                *  否则，以毫秒为单位，返回 key 的剩余生存时间。
                *  注意：在 Redis 2.8 以前，当 key
                *  不存在，或者 key 没有设置剩余生存时间时，命令都返回 -1 。
                */
               jedis.expire(key,1800);


            } else{

                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (!gainLock) {
            // 此时为超时情况
            System.out.println("线程 " + Thread.currentThread().getName() + " 超时");
            // 使用事务执行
            releaseLock(jedis, key, Thread.currentThread().getName());
            System.out.println("线程 " + Thread.currentThread().getName() + " 释放锁成功1,key=" + key);
            return;
        }

        // 此时，已获取到锁
        // 0-value已存在时返回，1-新成员加入时返回

        long redLong = jedis.sadd(sysKey, Thread.currentThread().getName());
        System.out.println("redLong = " + redLong);
        if (redLong == 0) {
            System.out.println("线程 " + Thread.currentThread().getName() + " 操作重复");
            releaseLock(jedis, key, Thread.currentThread().getName());
            System.out.println("线程 " + Thread.currentThread().getName() + " 释放锁成功2,key=" + key);
            return;
        } else {

            releaseLock(jedis, key, Thread.currentThread().getName());
            System.out.println("线程 " + Thread.currentThread().getName() + " 释放锁成功3,key=" + key);
            return;
        }


    }

    // 释放锁
    private void releaseLock(Jedis jedis, String lockKey, String lockValue) {
        // 以事务方式执行
        //Pipeline pipeline = jedis.pipelined();
       // Response<String> rsponse = pipeline.get(lockKey);
        String strRes = jedis.get(lockKey);
        System.out.println("strRes = " + strRes);
        // 做释放重试机制，判断
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
                System.out.println("释放成功 ： " + threadLocalName);
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
