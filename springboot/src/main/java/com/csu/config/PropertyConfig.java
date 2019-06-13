/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: PropertyConfig
 * Author:   yuanlin_csu
 * Date:     2019/6/13 14:54
 * Description: 读书list属性值
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈读书list属性值〉
 *
 * @author yuanlin_csu
 * @create 2019/6/13
 * @since 1.0.0
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "mybatis")
public class PropertyConfig{
    private List<String> mapperlocations;

    public List<String> getMapperlocations() {
        return mapperlocations;
    }

    public void setMapperlocations(List<String> mapperlocations) {
        this.mapperlocations = mapperlocations;
    }
}
