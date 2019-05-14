/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: Client
 * Author:   yuanlin_csu
 * Date:     2019/5/14 21:23
 * Description: ģ��ͻ��˵���
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.jdkproxy;

import com.csu.staticproxy.BeProxyed;
import com.csu.staticproxy.BeProxyedImpl;

import java.lang.reflect.Proxy;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��ģ��ͻ��˵��á�
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 *
 * <p>ģ��ͻ�������Ŀ���࣬reflect.Proxy ��ʵ��</p>
 * <p>���ڽӿڵĴ���</p>
 *
 */
public class Client {

    public  static void main(String [] args){

        BeProxyed beProxyed = (BeProxyed) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{BeProxyed.class}, new JdkProxy(new BeProxyedImpl()));

        beProxyed.request();

        // ���ӿ������ӷ���ʱֻ����� ���ӷ�����ʵ�� ����������仯

        beProxyed.next();

    }

}
