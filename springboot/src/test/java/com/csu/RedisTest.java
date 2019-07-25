/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RedisTest
 * Author:   yuanlin_csu
 * Date:     2019/6/18 18:29
 * Description: redis 集成测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

import com.csu.util.RedisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redis 集成测试〉
 *
 * @author yuanlin_csu
 * @create 2019/6/18
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private ValueOperations valueOperations;

    // 并未声明 jedisPool 用于测试，springboot 自动装配 并未装配
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testStringKey(){
        String oldKey = "test";
                //StringUtils.toString(new Date().getTime());
        String value = oldKey + "yuanlin";
        valueOperations.set(oldKey,value);
        boolean res = redisUtils.existsKey(oldKey);
        System.out.println("是否存在" + res);

       // System.out.println("zuixiao = "+ jedisPoolConfig.getMinIdle());
       // System.out.println("timout = " + redisConnectionFactory.getConnection());

    }

    /*public  void testSqlSession(){

        SqlSession sqlSession =
    }*/


}
