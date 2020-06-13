/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TransactionService
 * Author:   yuanlin_csu
 * Date:     2019/5/21 17:01
 * Description: 事务测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.biz;

import com.csu.dao.TransactionMapper;
import com.csu.entity.Users;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * 〈一句话功能简述〉<br>
 * 〈事务测试〉
 *
 * @author yuanlin_csu
 * @create 2019/5/21
 * @since 1.0.0
 */
@Service("transactionService")
public class TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;



    @Transactional(propagation = Propagation.REQUIRED)
    public int intsertTransaction(Users users) {

        System.out.println("插入=============");
        try {//当此被捕获异常而没有抛出，spring 没有接收到异常则不会做事务处理，默认roll-back="RuntimeException"
            transactionMapper.insertUser(users);
        } catch (Exception e) {
            System.out.println("insert exception!!!");
            throw e;
        }

        System.out.println("插入=============end！！！");
        return -1;
    }

    // 默认运行时异常回滚，传播属性为required，存在事物则继承，不存在则开启事物
    //(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    //@Transactional(propagation = Propagation.REQUIRED)
    public int testTransaction(Users users, String roleId) {

        System.out.println("11111=" + users.getUserId());
        users.setDeptId("3");
        System.out.println("wwwwwww=" + users);
        int insRes = transactionMapper.insertUser(users);
        System.out.println("qqqqqqqq=" + users);
        System.out.println("主键id为：" + users.getUserId());
        System.out.println("dept====：" + users.getDeptId());
        System.out.println("主键id2为：" + insRes);


        return 1;

    }




    /*
    开启自己的事务，成功后提交，调用方事务是否失败，不会回滚?
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateTransaction(Users users, String roleId) {

        int updRoleId = NumberUtils.toInt(roleId);
        String memo = "测试数据2-" + System.currentTimeMillis();
        System.out.println("更新=============");
        transactionMapper.updateRole(memo, roleId);
        System.out.println("更新=============end！！！");
        return -1;
    }


}
