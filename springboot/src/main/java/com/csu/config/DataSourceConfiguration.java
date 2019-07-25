/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: DataSourceConfiguration
 * Author:   yuanlin_csu
 * Date:     2019/6/12 18:16
 * Description: 数据源配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 〈一句话功能简述〉<br>
 * 〈数据源配置〉
 *
 * @author yuanlin_csu
 * @create 2019/6/12
 * @since 1.0.0
 */
@SpringBootConfiguration
public class DataSourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String jdbcDriver;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String jdbcUser;

    @Value("${spring.datasource.password}")
    private String jdbcPassword;

    @Value("${c3p0.minPoolSize}")
    private int minPoolSize;

    @Value("${c3p0.maxPoolSize}")
    private int maxPoolSize;

    @Value("${c3p0.maxIdleTime}")
    private int maxIdleTime;

    @Value("${c3p0.acquireIncrement}")
    private int acquireIncrement;

    @Value("${c3p0.maxStatements}")
    private int maxStatements;

    @Value("${c3p0.initialPoolSize}")
    private int initialPoolSize;

    @Value("${c3p0.idleConnectionTestPeriod}")
    private int idleConnectionTestPeriod;

    @Value("${c3p0.acquireRetryAttempts}")
    private int acquireRetryAttempts;

    @Value("${c3p0.acquireRetryDelay}")
    private int acquireRetryDelay;

    @Value("${c3p0.breakAfterAcquireFailure}")
    private boolean breakAfterAcquireFailure;

    @Value("${c3p0.testConnectionOnCheckout}")
    private boolean testConnectionOnCheckout;

    /*
        手动设置参数写法
     */
    @Bean(name = "dataSource")
    public DataSource createDatasource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUser);
        dataSource.setPassword(jdbcPassword);
        // 关闭连接后不自动提交
        dataSource.setAutoCommitOnClose(false);

        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMaxIdleTime(maxIdleTime);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setMaxStatements(maxStatements);
        dataSource.setInitialPoolSize(initialPoolSize);
        dataSource.setIdleConnectionTestPeriod(idleConnectionTestPeriod);
        dataSource.setAcquireRetryDelay(acquireRetryDelay);
        dataSource.setBreakAfterAcquireFailure(breakAfterAcquireFailure);
        dataSource.setTestConnectionOnCheckout(testConnectionOnCheckout);


        return dataSource;

    }


}
