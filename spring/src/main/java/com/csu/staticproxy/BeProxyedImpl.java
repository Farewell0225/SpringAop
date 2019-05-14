/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: BeProxyedImpl
 * Author:   yuanlin_csu
 * Date:     2019/5/14 19:27
 * Description: 实现BeProxyed接口，被静态代理的目标类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.staticproxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实现BeProxyed接口，被静态代理的目标类〉
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
