/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RedisLock
 * Author:   yuanlin_csu
 * Date:     2019/8/14 17:05
 * Description: Redis分布式锁使用测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package lock;

import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Redis分布式锁使用测试〉
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
        // 返回参数指令执行状态
        String str = jedis.select(13);

        if (!StringUtils.equalsIgnoreCase("OK", str)) {

            System.out.println("redis 数据库选择状态判断错误 : " + str);
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

                System.out.println("redis 数据库选择状态判断错误 : " + str);
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
