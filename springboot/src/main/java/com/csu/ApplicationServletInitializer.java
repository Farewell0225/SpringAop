/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ApplicationServletInitializer
 * Author:   yuanlin_csu
 * Date:     2019/6/17 17:26
 * Description: 应用部署初始化类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 〈一句话功能简述〉<br> 
 * 〈应用部署初始化类〉
 *
 * @author yuanlin_csu
 * @create 2019/6/17
 * @since 1.0.0
 */
public class ApplicationServletInitializer
        extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }
}
