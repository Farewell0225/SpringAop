/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: LoginAction
 * Author:   yuanlin_csu
 * Date:     2019/5/10 14:48
 * Description: 登录控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈登录控制器〉
 *
 * @author yuanlin_csu
 * @create 2019/5/10
 * @since 1.0.0
 */
@Controller
public class LoginAction {


    @RequestMapping(value = "/first.do", method = RequestMethod.GET)
    public String first() {

        System.out.println("index excute!!!=================");

        return "first.html";
    }

    @RequestMapping(value = "/index.jsp", method = RequestMethod.GET)
    public String index() {

        System.out.println("index1111 excute!!!=================");

        return "index";
    }


    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> login(@RequestParam(name = "name") String userName,
                                     @RequestParam(name = "password") String passWord) {

        Map<String, String> resMap = new HashMap<String, String>();
        resMap.put("resName", userName);
        resMap.put("resPassWord", passWord);
        System.out.println("name = " + userName);
        System.out.println("password = " + passWord);


        return resMap;
    }


}
