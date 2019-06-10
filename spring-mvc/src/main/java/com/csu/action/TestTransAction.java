/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TestTransAction
 * Author:   yuanlin_csu
 * Date:     2019/5/21 10:03
 * Description: 测试spring 事物
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.action;

import com.csu.biz.TransactionService;
import com.csu.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试spring 事物〉
 *
 * @author yuanlin_csu
 * @create 2019/5/21
 * @since 1.0.0
 */
@Controller
public class TestTransAction {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/trans.do",method = RequestMethod.GET)
    public String transaction(){

        // 测试事物，先修改再增加，判断修改的添加时错误，导致修改的数据回滚
        // 1. 修改 role 表的 第一条数据的备注
        // 2.修改完成，增加一个user表数据
        System.out.println("Start!!!!!!!!!!!!!");
        Users user = new Users();
        String roleId = "1";

        user.setUserId(12);

        transactionService.testTransaction(user,roleId);

        System.out.println("end");

        return "";
    }



}
