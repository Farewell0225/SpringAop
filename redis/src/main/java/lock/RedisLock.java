/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: RedisLock
 * Author:   yuanlin_csu
 * Date:     2019/8/14 17:05
 * Description: Redis�ֲ�ʽ��ʹ�ò���
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package lock;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��Redis�ֲ�ʽ��ʹ�ò��ԡ�
 *
 * @author yuanlin_csu
 * @create 2019/8/14
 * @since 1.0.0
 */
public class RedisLock {


    private static final String adderss = "redis://127.0.0.1:6379";



    public static void main(String []args){


        JedisShardInfo shardInfo = new JedisShardInfo(adderss);

        shardInfo.setPassword("yuanlin");
       // Jedis jedis = new Jedis(shardInfo);

      /*  jedis.connect();
        // ���ز���ָ��ִ��״̬
        String str = jedis.select(13);

        if (!StringUtils.equalsIgnoreCase("OK", str)) {

            System.out.println("redis ���ݿ�ѡ��״̬�жϴ��� : " + str);
            jedis.close();
            return;
        }
*/
        String lockKey = "lock";
        String sysKey = "data";


        //Jedis jedis,String key,String value,long timeOut
        for(int i = 0;i<10;i++){
            Jedis jedis = new Jedis(shardInfo);
            jedis.connect();
            String str = jedis.select(13);

            if (!StringUtils.equalsIgnoreCase("OK", str)) {

                System.out.println("redis ���ݿ�ѡ��״̬�жϴ��� : " + str);
                jedis.close();
                continue;
            }

            TestThread temp = new TestThread(jedis,lockKey,"yuanlin",10000,sysKey);
            Thread thread = new Thread(temp);
            thread.setName("thread " + (i+1));
            thread.start();
        }



    }

}
