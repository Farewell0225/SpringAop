/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RedisString
 * Author:   yuanlin_csu
 * Date:     2019/7/25 11:33
 * Description: String类型
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package operate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈List类型〉
 *
 * @author yuanlin_csu
 * @create 2019/7/25
 * @since 1.0.0
 */
public class RedisList {

    private final String adderss = "redis://127.0.0.1:6379";

    private int port = 6379;

    public static void main(String [] args){

        new RedisList().run();

    }

    public void run() {

        // 需要授权密码时 使用如下获取连接,默认从index=0 开始

        JedisShardInfo shardInfo = new JedisShardInfo(adderss);

        shardInfo.setPassword("yuanlin");
        Jedis jedis = new Jedis(shardInfo);

        jedis.connect();
        // 返回参数是啥？
        String str = jedis.select(1);

        System.out.println("select res : " + str);

        String setStr = jedis.set("secend","袁林333");

        System.out.println("set key res : " + setStr);

        Long delKey = jedis.del("secend");

        System.out.println("del key status : " + delKey);

        String delStrKey = jedis.get("secend");

        System.out.println("get del key res : " + delStrKey);




        jedis.close();


    }


}
