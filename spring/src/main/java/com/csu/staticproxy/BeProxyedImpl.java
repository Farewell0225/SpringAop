/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: BeProxyedImpl
 * Author:   yuanlin_csu
 * Date:     2019/5/14 19:27
 * Description: ʵ��BeProxyed�ӿڣ�����̬�����Ŀ����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.staticproxy;

/**
 * ��һ�仰���ܼ�����<br> 
 * ��ʵ��BeProxyed�ӿڣ�����̬�����Ŀ���ࡵ
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 */
public class BeProxyedImpl implements BeProxyed{


    public void request() {
        System.out.println("this is be proxyed!!!");
    }

    public void next() {
        System.out.println("this is next method!!!");
    }
}
