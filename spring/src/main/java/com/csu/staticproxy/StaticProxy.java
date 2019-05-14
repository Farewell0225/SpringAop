/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: StaticProxy
 * Author:   yuanlin_csu
 * Date:     2019/5/14 19:29
 * Description: 静态代理类，代理目标类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.staticproxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈静态代理类，代理目标类〉
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 * <p>代理类不会改变目标类，所以异常需要捕获</p>
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
