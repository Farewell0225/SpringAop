/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Client
 * Author:   yuanlin_csu
 * Date:     2019/5/14 21:23
 * Description: 模拟客户端调用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.jdkproxy;

import com.csu.staticproxy.BeProxyed;
import com.csu.staticproxy.BeProxyedImpl;

import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈模拟客户端调用〉
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 *
 * <p>模拟客户端请求目标类，reflect.Proxy 类实例</p>
 * <p>基于接口的代理</p>
 *
 */
public class Client {

    public  static void main(String [] args){

        BeProxyed beProxyed = (BeProxyed) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{BeProxyed.class}, new JdkProxy(new BeProxyedImpl()));

        beProxyed.request();

        // 当接口中增加方法时只需添加 增加方法的实现 代理类无需变化

        beProxyed.next();

    }

}
