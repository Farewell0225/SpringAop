/*
package com.csu.config;

import org.apache.ibatis.annotations.ConstructorArgs;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


//@ConfigurationProperties(prefix = "mybatis")
@SpringBootConfiguration
public class ScannerConfigurer {

    @Value("${mybatis.sqlSessionFactory.name}")
    private String sqlSessionFactoryBeanName;

    private static final Logger log = LoggerFactory.getLogger("ScannerConfigurer.class");

    public ScannerConfigurer(){
        //System.out.println("basePackage = " + propertyConfig.getBasePackage());
        System.out.println("sqlSessionFactoryBeanName = " + sqlSessionFactoryBeanName);

    }

    // 手动配置 MapperScanner
    @Bean(name = "mapperScanner")
    public MapperScannerConfigurer createMapperScanBeanFactory(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.csu.dao");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
        return mapperScannerConfigurer;

    }

}
*/
