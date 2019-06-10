/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TestShareSessionController
 * Author:   yuanlin_csu
 * Date:     2019/5/16 17:53
 * Description: redis session 共享的测试控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br> 
 * 〈redis session 共享的测试控制器〉
 *
 * @author yuanlin_csu
 * @create 2019/5/16
 * @since 1.0.0
 */
@Controller
public class TestShareSessionController {

    @RequestMapping(value = "/share.do",method = {RequestMethod.GET,RequestMethod.POST})
    public String shareSession (HttpServletRequest request,
                                @RequestParam(value = "name") String userName){
        request.getSession().setAttribute("user", userName);
        System.out.println("access !!!");


        return "shareSession.jsp";
    }




}
