/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ProxyChain
 * Author:   yuanlin_csu
 * Date:     2019/4/30 11:22
 * Description: 被代理的代理链对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈被代理者 对应的代理链〉
 *
 * @author yuanlin_csu
 * @create 2019/4/30
 * @since 1.0.0
 */
public class ProxyChain<T> {

    // 目标类
    private final Class<T> targetClass;
    // 目标对象
    private final T targetObject;
    // 此次被代理的方法（被代理的最小单元为方法）
    private final Method method;
    // 所属 cgLib ，由 cgLib 提供，最终由它执行原目标类中的方法
    private final MethodProxy methodProxy;
    // 此次被代理的方法的参数
    private final Object[] params;
    // 代理链
    private List<Proxy> proxyList;
    // index 指示将要执行的 “增强（或称为‘横切逻辑’）”
    private int index = 0;

    public ProxyChain(Class<T> targetClass, T targetObject, Method method, MethodProxy methodProxy, Object[] params, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targetObject = targetObject;
        this.method = method;
        this.methodProxy = methodProxy;
        this.params = params;

        this.proxyList = proxyList;
    }

    public Class<T> getTargetClass() {
        return targetClass;
    }

    public Method getMethod() {
        return method;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public Object[] getParams() {
        return params;
    }

    public T getTargetObject() {
        return targetObject;
    }

    /**
     * 配合 doProxy() 以及利用 index 实现 “链式代理”
     */
    public Object doProxyChain() throws Throwable {
        Object result;
        if (this.index >= proxyList.size()) {
            result = methodProxy.invokeSuper(targetObject, params);
            this.index = 0; // TODO 自己添加，为了实现 链式代理 的多次调用
        } else {
            result = proxyList.get(this.index++).doProxy(this);
        }
        return result;
    }

}


