/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TestMain
 * Author:   yuanlin_csu
 * Date:     2019/5/14 20:40
 * Description: 客户端目标类请求
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.staticproxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈客户端目标类请求〉
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
