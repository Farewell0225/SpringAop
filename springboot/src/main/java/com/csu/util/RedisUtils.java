/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RedisUtils
 * Author:   yuanlin_csu
 * Date:     2019/6/18 18:14
 * Description: redis 操作工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redis 操作工具类 key的状态判断〉
 *
 * @author yuanlin_csu
 * @create 2019/6/18
 * @since 1.0.0
 */
@Component
public class RedisUtils {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    /**
     * 默认过期时长，单位：秒
     */
    public static final long DEFAULT_EXPIRE = 60 * 60 * 24;

    /**
     * 不设置过期时长
     */
    public static final long NOT_EXPIRE = -1;


    /**
     * 判断 键是否存在
     * @param keyName
     * @return
     */
    public boolean existsKey(String keyName){

        return redisTemplate.hasKey(keyName);

    }

    /**
     * 重命名 键
     * @param oldKeyName
     * @param newKeyName
     */
    public void renameKey(String oldKeyName,String newKeyName) {

        redisTemplate.rename(oldKeyName,newKeyName);

    }




}
