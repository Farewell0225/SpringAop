/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: CursorService
 * Author:   yuanlin_csu
 * Date:     2019/7/24 10:41
 * Description: 游标使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu.biz;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * 〈一句话功能简述〉<br> 
 * 〈游标使用〉
 *
 * @author yuanlin_csu
 * @create 2019/7/24
 * @since 1.0.0
 */
//@Service("cursorService")
public class CursorService extends MyBatisCursorItemReader{

    public String selectCursor(){
        String resStr = "FAILD";

        // 开启游标
        super.doOpen();

        int counter = 0;
        while(true){

            Map<String,String> tempMapRes = (HashMap<String,String>)super.doRead();

            if (tempMapRes == null || tempMapRes.isEmpty()){
                break;
            }

            counter++;
            for (Map.Entry<String,String> e: tempMapRes.entrySet()) {
                System.out.print("计数 " + counter + ": ");

                System.out.println(e.getKey() + " = " + e.getValue());

            }

            resStr = "SUCCESS";

        }

        return resStr;
    }

}
