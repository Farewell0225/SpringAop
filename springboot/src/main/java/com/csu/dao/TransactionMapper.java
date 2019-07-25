/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TransactionMapper
 * Author:   yuanlin_csu
 * Date:     2019/5/21 10:17
 * Description: 测试事务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.dao;

import com.csu.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试事务〉
 *
 * @author yuanlin_csu
 * @create 2019/5/21
 * @since 1.0.0
 */
@Mapper
public interface TransactionMapper {

    // 更新role 表
    public int updateRole(@Param("memo") String memo, @Param("roleId") String roleId);

    // 插入user数据
    public int insertUser(Users user);

}
