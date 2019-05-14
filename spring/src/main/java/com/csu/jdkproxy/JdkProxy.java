/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: JdkProxy
 * Author:   yuanlin_csu
 * Date:     2019/5/14 20:49
 * Description: JDK代理实现AOP
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.jdkproxy;

import com.csu.staticproxy.BeProxyedImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈JDK代理实现AOP〉
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 *
 * <P>jdk 动态代理 需要实现 InvocationHandler 接口</P>
 * <p>实际调用时实例被传入 reflect.proxy 作为参数调用</p>
 *
 */
public class JdkProxy implements InvocationHandler {

    /*  代理的目标类 ，AOP 基于目标类的代理,相当于 spring 中使用 @AspectJ
        注解 声明 目标类需要被代理，使用 @excution（）定义方法被代理规则
    */

    private BeProxyedImpl beProxyedIml;


    public JdkProxy(BeProxyedImpl beProxyedIml) {
        this.beProxyedIml = beProxyedIml;
    }

    /* 利用反射实现调用目标类方法 返回object 对象 */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before by jdk proxy ");
        try{
            Object result = method.invoke(beProxyedIml,args);
        } catch (Exception e){
            System.out.println("exception : " + e.getMessage());

        } finally {
            System.out.println("after by jdk proxy ");
        }




        return null;
    }
}
