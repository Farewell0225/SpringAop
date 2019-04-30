/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: ProxyChain
 * Author:   yuanlin_csu
 * Date:     2019/4/30 11:22
 * Description: ������Ĵ���������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.proxy;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * ��һ�仰���ܼ�����<br> 
 * ���������� ��Ӧ�Ĵ�������
 *
 * @author yuanlin_csu
 * @create 2019/4/30
 * @since 1.0.0
 */
public class ProxyChain<T> {

    // Ŀ����
    private final Class<T> targetClass;
    // Ŀ�����
    private final T targetObject;
    // �˴α�����ķ��������������С��ԪΪ������
    private final Method method;
    // ���� cgLib ���� cgLib �ṩ����������ִ��ԭĿ�����еķ���
    private final MethodProxy methodProxy;
    // �˴α�����ķ����Ĳ���
    private final Object[] params;
    // ������
    private List<Proxy> proxyList;
    // index ָʾ��Ҫִ�е� ����ǿ�����Ϊ�������߼�������
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
     * ��� doProxy() �Լ����� index ʵ�� ����ʽ����
     */
    public Object doProxyChain() throws Throwable {
        Object result;
        if (this.index >= proxyList.size()) {
            result = methodProxy.invokeSuper(targetObject, params);
            this.index = 0; // TODO �Լ���ӣ�Ϊ��ʵ�� ��ʽ���� �Ķ�ε���
        } else {
            result = proxyList.get(this.index++).doProxy(this);
        }
        return result;
    }

}


