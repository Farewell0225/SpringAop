/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ElasticsearchConfigure
 * Author:   yuanlin_csu
 * Date:     2019/9/29 15:51
 * Description: es 配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.elesticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * 〈一句话功能简述〉<br> 
 * 〈es 配置〉
 *
 * @author yuanlin_csu
 * @create 2019/9/29
 * @since 1.0.0
 */
@SpringBootConfiguration
@ConfigurationProperties(prefix = "es")
public class ElasticsearchConfigure {

    @Value("${es.host}")
    private String host;

    @Value("${es.port}")
    private int port;

    @Value("${es.scheme}")
    private String scheme;


    @Bean
    public RestHighLevelClient createRestHigh(){

        HttpHost httpHost = new HttpHost(host,port,scheme);

        RestClientBuilder restBuilder = RestClient.builder(httpHost);


        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(restBuilder);


        return restHighLevelClient;

    }



}
