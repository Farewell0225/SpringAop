/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: TestPaging
 * Author:   yuanlin_csu
 * Date:     2019/5/30 15:08
 * Description: 测试mybatis分页
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.dao;

import com.csu.entity.Users;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试mybatis分页〉
 *
 * @author yuanlin_csu
 * @create 2019/5/30
 * @since 1.0.0
 */
public interface TestPagingMapper {
    // 使用Rowbounds 分页
    public List<Users> selectByPage(RowBounds rowBounds);

}
