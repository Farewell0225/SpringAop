/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: StaticProxy
 * Author:   yuanlin_csu
 * Date:     2019/5/14 19:29
 * Description: ��̬�����࣬����Ŀ����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.staticproxy;

/**
 * ��һ�仰���ܼ�����<br>
 * ����̬�����࣬����Ŀ���ࡵ
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 * <p>�����಻��ı�Ŀ���࣬�����쳣��Ҫ����</p>
 */
public class StaticProxy implements BeProxyed {

    private BeProxyedImpl beProxyed;

    public StaticProxy() {
        super();
    }

    public StaticProxy(BeProxyedImpl beProxyed) {

        this.beProxyed = beProxyed;

    }


    public void request() {

        System.out.println("be proxyed before");
        try {
            beProxyed.request();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println("be proxyed after");
        }

    }

    public void next() {

        System.out.println("be proxyed before");
        try {
            beProxyed.next();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println("be proxyed after");
        }

    }




}
