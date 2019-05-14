/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: JdkProxy
 * Author:   yuanlin_csu
 * Date:     2019/5/14 20:49
 * Description: JDK����ʵ��AOP
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.jdkproxy;

import com.csu.staticproxy.BeProxyedImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��JDK����ʵ��AOP��
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 *
 * <P>jdk ��̬���� ��Ҫʵ�� InvocationHandler �ӿ�</P>
 * <p>ʵ�ʵ���ʱʵ�������� reflect.proxy ��Ϊ��������</p>
 *
 */
public class JdkProxy implements InvocationHandler {

    /*  �����Ŀ���� ��AOP ����Ŀ����Ĵ���,�൱�� spring ��ʹ�� @AspectJ
        ע�� ���� Ŀ������Ҫ������ʹ�� @excution�������巽�����������
    */

    private BeProxyedImpl beProxyedIml;


    public JdkProxy(BeProxyedImpl beProxyedIml) {
        this.beProxyedIml = beProxyedIml;
    }

    /* ���÷���ʵ�ֵ���Ŀ���෽�� ����object ���� */
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
