///**
// * Copyright (C), 2018-2019, XXX有限公司
// * FileName: RedisConfiguration
// * Author:   yuanlin_csu
// * Date:     2019/6/18 17:46
// * Description: Redis配置类
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.csu.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.math.NumberUtils;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.cache.RedisCacheWriter;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisPassword;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.*;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//import java.time.Duration;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈Redis配置类〉
// *
// * @author yuanlin_csu
// * @create 2019/6/18
// * @since 1.0.0
// */
//@SpringBootConfiguration
//// 开启默认使用redis 缓存
//@EnableCaching
//public class RedisConfiguration extends CachingConfigurerSupport {
//
//    /**
//     * redis:
//     *     port: 6379
//     *     host: 127.0.0.1
//     *     password: yuanlin
//     *     jedis:
//     *       pool:
//     *         max-active: 8
//     *         max-wait: -1ms
//     *         max-idle: 8
//     *         min-idle: 2
//     *     timeout: 5s
//     *     database: 0
//     *     存在值填充为空 的可能
//     */
//
//    @Value("${spring.redis.database}")
//    private Integer database;
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private Integer port;
//
//    @Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.timeout}")
//    private String connTimeout;
//
//    @Value("${spring.redis.jedis.pool.max-active}")
//    private Integer maxActive;
//
//    @Value("${spring.redis.jedis.pool.max-idle}")
//    private Integer maxIdle;
//
//    @Value("${spring.redis.jedis.pool.min-idle}")
//    private Integer minIdle;
//
//    @Value("${spring.redis.jedis.pool.max-wait}")
//    private String maxWait;
//
//
//    /**
//     * 选择redis作为默认缓存工具 2.0 的配置
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean(name = "cacheManager")
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//
//        return RedisCacheManager
//                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
//                .cacheDefaults(redisCacheConfiguration).build();
//
//    }
//
//    @Bean(name = "redisConnectionFactory")
//    public RedisConnectionFactory connectionFactory(){
//
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//
//        jedisPoolConfig.setMaxTotal(maxActive);
//
//        jedisPoolConfig.setMaxIdle(maxIdle);
//
//        jedisPoolConfig.setMaxWaitMillis(NumberUtils.toInt(maxWait));
//
//        jedisPoolConfig.setTestOnBorrow(true);
//        jedisPoolConfig.setTestOnReturn(false);
//        jedisPoolConfig.setTestWhileIdle(true);
//        JedisClientConfiguration jedisClientConfiguration = null;
//
//        // 客户端配置添加连接池
//        jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().
//                poolConfig(jedisPoolConfig).and().
//                readTimeout(Duration.ofMillis(NumberUtils.toLong(connTimeout))).build();
//
//        // 单机模式配置以上配置应该是基于 jedis-2.9.1 以上的配置，所需spring 版本在 5.1.7
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//
//        redisStandaloneConfiguration.setDatabase(database);
//        redisStandaloneConfiguration.setPort(port);
//        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
//        redisStandaloneConfiguration.setHostName(host);
//        RedisConnectionFactory redisConnectionFactory =
//                new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
//
//        return redisConnectionFactory;
//    }
//
//
//    /**
//     * retemplate相关配置
//     * 此时若没有 配置jedisPool 则自动装配会使用，默认的线程池配置
//     * @param factory
//     * @return
//     */
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        // 配置连接工厂
//        template.setConnectionFactory(factory);
//
//        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
//        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);
//
//        ObjectMapper om = new ObjectMapper();
//        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//
//        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jacksonSeial.setObjectMapper(om);
//
//        // 值采用json序列化
//        template.setValueSerializer(jacksonSeial);
//
//        //使用StringRedisSerializer来序列化和反序列化redis的key值
//        template.setKeySerializer(new StringRedisSerializer());
//
//        // 设置hash key 和value序列化模式
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(jacksonSeial);
//        template.afterPropertiesSet();
//
//        return template;
//    }
//
//    /**
//     * 对hash类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean(name = "hashOperations")
//    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForHash();
//    }
//
//    /**
//     * 对redis字符串类型数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean(name = "valueOperations")
//    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForValue();
//    }
//
//    /**
//     * 对链表类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean(name = "listOperations")
//    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForList();
//    }
//
//    /**
//     * 对无序集合类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean(name = "setOperations")
//    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForSet();
//    }
//
//    /**
//     * 对有序集合类型的数据操作
//     *
//     * @param redisTemplate
//     * @return
//     */
//    @Bean(name = "zSetOperations")
//    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
//        return redisTemplate.opsForZSet();
//    }
//
//
//
//}
