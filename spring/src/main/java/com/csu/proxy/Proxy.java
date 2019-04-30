/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Proxy
 * Author:   yuanlin_csu
 * Date:     2019/4/30 11:19
 * Description: 创建代理类接口处理代理链
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈创建代理类接口处理代理链〉
 *
 * @author yuanlin_csu
 * @create 2019/4/30
 * @since 1.0.0
 */

public interface Proxy {
    /**
     * 链式处理操作
     *
     * @param proxyChain 描述 被代理者 对应的代理链
     */
    <T> Object doProxy( ProxyChain<T> proxyChain);

}
