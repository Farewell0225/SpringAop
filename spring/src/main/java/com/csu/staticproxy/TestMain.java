/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: TestMain
 * Author:   yuanlin_csu
 * Date:     2019/5/14 20:40
 * Description: �ͻ���Ŀ��������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.staticproxy;

/**
 * ��һ�仰���ܼ�����<br> 
 * ���ͻ���Ŀ��������
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 */
public class TestMain {


    public static void main(String [] args){

        BeProxyed beProxyed = new StaticProxy(new BeProxyedImpl());

        beProxyed.request();





    }


}
