/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: Proxy
 * Author:   yuanlin_csu
 * Date:     2019/4/30 11:19
 * Description: ����������ӿڴ��������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.proxy;

/**
 * ��һ�仰���ܼ�����<br> 
 * ������������ӿڴ����������
 *
 * @author yuanlin_csu
 * @create 2019/4/30
 * @since 1.0.0
 */

public interface Proxy {
    /**
     * ��ʽ�������
     *
     * @param proxyChain ���� �������� ��Ӧ�Ĵ�����
     */
    <T> Object doProxy( ProxyChain<T> proxyChain);

}
