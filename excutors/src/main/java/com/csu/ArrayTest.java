/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: ArrayTest
 * Author:   yuanlin_csu
 * Date:     2019/6/13 15:57
 * Description: 测试数组的初始化
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.csu;

import org.junit.Test;

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试数组的初始化〉
 *
 * @author yuanlin_csu
 * @create 2019/6/13
 * @since 1.0.0
 */
public class ArrayTest {

    @Test
    public void testArray(){

        // 类的属性值，非静态的属于对象，在对象创建时才会，初始化默认值
        ArrrayTestObject arrrayTestObjects1 = new ArrrayTestObject();

        System.out.println( "sss====" + arrrayTestObjects1.getCount());

        ArrrayTestObject [] arrrayTestObjects = new ArrrayTestObject[3];


        System.out.println("res = " + arrrayTestObjects[0].getCount());

    }




}
