/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: MainProvider
 * Author:   yuanlin_csu
 * Date:     2019/6/24 11:22
 * Description: 提供者启动类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈提供者启动类,支持ClassPathXmlApplicationContext〉
 *
 * @author yuanlin_csu
 * @create 2019/6/24
 * @since 1.0.0
 */
public class MainProvider {

    public static void main(String [] args) throws IOException {
        // 默认路径从resources 下开始
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("dubbo-provider.xml");
        context.start();
        System.err.println( "Start Success !!");
        // 任意键退出
        System.in.read();

    }


}
