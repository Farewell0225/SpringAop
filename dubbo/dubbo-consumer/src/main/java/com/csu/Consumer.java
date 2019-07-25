/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Consumer
 * Author:   yuanlin_csu
 * Date:     2019/6/24 13:41
 * Description: dubbo 消费者demo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

import com.csu.service.ApiService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈dubbo 消费者demo〉
 *
 * @author yuanlin_csu
 * @create 2019/6/24
 * @since 1.0.0
 */
public class Consumer {

    public static void main( String [] args){

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        System.err.println("consumer start success !!!");
        ApiService apiService =
                (ApiService) context.getBean("apiService");
        String resultStr1 = apiService.sayHello("袁林");
        System.out.println("result : " + resultStr1);

        ApiService apiService2 =
                (ApiService) context.getBean("apiService2");
        String resultStr2 = apiService2.sayHello("袁林222");
        System.out.println("result22 : " + resultStr2);

    }


}
