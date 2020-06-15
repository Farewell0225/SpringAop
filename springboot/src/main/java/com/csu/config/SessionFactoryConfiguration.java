///**
// * Copyright (C), 2018-2019, XXX有限公司
// * FileName: SessionFactoryConfiguration
// * Author:   yuanlin_csu
// * Date:     2019/6/13 14:29
// * Description: mybatis配置
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package com.csu.config;
//
//import jdk.internal.dynalink.beans.StaticClass;
//import org.apache.commons.lang3.ArrayUtils;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringBootConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈mybatis配置〉
// *
// * @author yuanlin_csu
// * @create 2019/6/13
// * @since 1.0.0
// */
//@SpringBootConfiguration
//public class SessionFactoryConfiguration {
//    // 注入list属性
//    @Autowired
//    private PropertyConfig propertyConfig;
//
//   /* // *Mapper.xml 对应的路径
//    @Value("${mybatis.mapperlocations}")
//    private List<String> mapperLocations;*/
//
//    @Value("${mybatis.type-aliases-package}")
//    private String typeAliasesPackage;
//
//    @Value("${mybatis.sqlSessionFactory.name}")
//    private String sqlSessionFactoryBeanName;
//
//    @Autowired
//    private DataSource dataSource;
//
//    private static final Logger log = LoggerFactory.getLogger("SS.log");
//
//    @Bean(name="${mybatis.sqlSessionFactory.name}")
//    public SqlSessionFactoryBean createSqlSessionFactory() throws IOException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        List<String> mapperLocations = propertyConfig.getMapperlocations();
//        int length = mapperLocations.size();
//        PathMatchingResourcePatternResolver [] resolver =
//                new PathMatchingResourcePatternResolver[length];
//        Resource [] mapperLocationsResources = null;
//        /* String[] str1 = {"Hello","world","java"};
//            String[] str2 = {"Veriable","syntax","interator"};
//            int str1Length = str1.length;
//            int str2length = str2.length;
//
//            str1 = Arrays.copyOf(str1, str1Length+str2length);//数组扩容
//            System.arraycopy(str2, 0, str1, str1Length, str2length);*/
//
//        for (int i = 0 ; i < length ; i++){
//            resolver[i] =
//                    new PathMatchingResourcePatternResolver();
//            Resource [] tempLocations = resolver[i].getResources(mapperLocations.get(i));
//            if (i == 0){
//                mapperLocationsResources = tempLocations;
//
//            } else {
//                // 扩容
//               // int len1 = mapperLocationsResources.length;
//               // int len2 = tempLocations.length;
//               // mapperLocationsResources = Arrays.copyOf(mapperLocationsResources,len1 + len2);
//               // System.arraycopy(tempLocations,0,mapperLocationsResources,len2);
//                mapperLocationsResources = ArrayUtils.addAll(mapperLocationsResources,tempLocations);
//
//            }
//
//        }
//
//
//        // PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX= claspath*
//
//
//        // 设置 mapper 对应的 XML 文件的路径
//        sqlSessionFactoryBean.setMapperLocations(mapperLocationsResources);
//        // 设置数据源
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        // 设置 entity 接口所在的包设置别名
//        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
//
//        /**
//         * 设置自定义的类型处理器，而非MapperScan扫描的接口
//         * sqlSessionFactoryBean.setTypeHandlersPackage(typeHandlersPackage);
//         */
//
//
//        return sqlSessionFactoryBean;
//    }
//
//}
