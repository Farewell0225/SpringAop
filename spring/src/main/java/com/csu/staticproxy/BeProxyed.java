/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: BeProxyed
 * Author:   yuanlin_csu
 * Date:     2019/5/14 19:22
 * Description: 被AOP静态代理实现的接口
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.staticproxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈被AOP静态代理实现的接口〉
 *
 * @author yuanlin_csu
 * @create 2019/5/14
 * @since 1.0.0
 * <p>aop的静态代理实现时代理类与目标类所需实现的接口</p>
 */

public interface BeProxyed {

    public void request();
    public void next();


}
