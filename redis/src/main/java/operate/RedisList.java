/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: RedisString
 * Author:   yuanlin_csu
 * Date:     2019/7/25 11:33
 * Description: String����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package operate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��List���͡�
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

        // ��Ҫ��Ȩ����ʱ ʹ�����»�ȡ����,Ĭ�ϴ�index=0 ��ʼ

        JedisShardInfo shardInfo = new JedisShardInfo(adderss);

        shardInfo.setPassword("yuanlin");
        Jedis jedis = new Jedis(shardInfo);

        jedis.connect();
        // ���ز�����ɶ��
        String str = jedis.select(1);

        System.out.println("select res : " + str);

        String setStr = jedis.set("secend","Ԭ��333");

        System.out.println("set key res : " + setStr);

        Long delKey = jedis.del("secend");

        System.out.println("del key status : " + delKey);

        String delStrKey = jedis.get("secend");

        System.out.println("get del key res : " + delStrKey);




        jedis.close();


    }


}
