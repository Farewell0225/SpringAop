/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: BeProxyed
 * Author:   yuanlin_csu
 * Date:     2019/5/14 19:22
 * Description: ��AOP��̬����ʵ�ֵĽӿ�
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.staticproxy;

/**
 * ��һ�仰���ܼ�����<br> 
 * ����AOP��̬����ʵ�ֵĽӿڡ�
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 * <p>aop�ľ�̬����ʵ��ʱ��������Ŀ��������ʵ�ֵĽӿ�</p>
 */

public interface BeProxyed {

    public void request();
    public void next();


}
