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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(value = "/login.do",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> login(@RequestParam( value = "name" ) String userName,@RequestParam(value = "password") String passWord){

        Map<String,String> resMap = new HashMap<String, String>();
        resMap.put("resName",userName);
        resMap.put("resPassWord",passWord);
        System.out.println("name = " + userName);
        System.out.println("password = " + passWord);


        return resMap;
    }



}
