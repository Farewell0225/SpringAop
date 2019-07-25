/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ApiServiceImpl
 * Author:   yuanlin_csu
 * Date:     2019/6/24 10:50
 * Description: 服务提供者 api 实现
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈服务提供者 api 实现〉
 *
 * @author yuanlin_csu
 * @create 2019/6/24
 * @since 1.0.0
 */
public class ApiServiceImpl implements ApiService {


    @Override
    public String sayHello(String name) {

        return "hello Mr " + name;
    }
}
