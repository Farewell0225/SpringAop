/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Controller
 * Author:   yuanlin_csu
 * Date:     2019/4/30 10:18
 * Description: 被AOP代理拦截的控制器类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.proxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈被AOP代理拦截的控制器类〉
 *
 * @author yuanlin_csu
 * @create 2019/4/30
 * @since 1.0.0
 */
public class Controller {

    public Controller(){
        super();
    }

    public void process(){

        System.out.println("proxy one apspect be advised");

    }



}
