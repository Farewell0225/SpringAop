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

import com.csu.dao.TestPagingMapper;
import com.csu.dao.TransactionMapper;
import com.csu.entity.Users;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    private TestPagingMapper testPagingMapper;

    // 默认运行时异常回滚，传播属性为required，存在事物则继承，不存在则开启事物
    //(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    //@Transactional(propagation = Propagation.REQUIRED)
    public int testTransaction(Users users, String roleId) {

        int res = -1;
        /* try {*/
        int updRoleId = NumberUtils.toInt(roleId);
        String memo = "测试数据-" + System.currentTimeMillis();

       // int updRes = transactionMapper.updateRole(memo, roleId);

        /**
         * @Transactional(propagation = Propagation.REQUIRES_NEW),
         * 会开启新事物，下一条失败此条不会回滚
         */
        int uRes = updateTransaction(users, roleId);
        // 测试嵌套事物 @Transactional 默认REQUIRED,则此处出错，上一条会回滚
        /**
         *  改为 @Transactional(propagation = Propagation.REQUIRES_NEW),
         *  会开启新事物，则上一条不会回滚
         */

        int insRes = intsertTransaction(users);
        //int insRes = transactionMapper.insertUser(users);
        /*} catch(Exception e){

            throw e;

        }*/

       /* RowBounds rowBounds = new RowBounds(1,1);
        List<Users> resList = testPagingMapper.selectByPage(rowBounds);

        for (Users u: resList) {

            System.out.println("user = " + u.getUserId());

        }

        System.out.println("endsssssssssssss");*/
        return res;

    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int intsertTransaction(Users users) {

        System.out.println("插入=============");
        try{//当此被捕获异常而没有抛出，spring 没有接收到异常则不会做事务处理，默认roll-back="RuntimeException"
            transactionMapper.insertUser(users);
        }catch (Exception e){
            System.out.println("insert exception!!!");
            throw e;
        }

        System.out.println("插入=============end！！！");
        return -1;
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
