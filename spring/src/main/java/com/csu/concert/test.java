/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: test
 * Author:   yuanlin_csu
 * Date:     2019/4/22 16:53
 * Description: f
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.concert;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈f〉
 *
 * @author yuanlin_csu
 * @create 2019/4/22
 * @since 1.0.0
 */
public class test {


    public static void main(String[] args) {

       /* ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Performance performance = (Performance)context.getBean("performanceImpl");

        try {
            performance.perform();
        } catch (Throwable throwable) {

            System.out.println("ddddddddddd");
        }
        System.out.println("wwwwwwwwwwwwwwwww");*/


       List<String> list = new ArrayList<String>(5);

       list.add("1");
       list.add("2");
       list.add("3");
       list.remove(1);
       System.out.println(list.get(1));

    }
}
