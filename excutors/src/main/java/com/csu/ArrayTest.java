/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: ArrayTest
 * Author:   yuanlin_csu
 * Date:     2019/6/13 15:57
 * Description: ��������ĳ�ʼ��
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu;

import org.junit.Test;

/**
 * ��һ�仰���ܼ�����<br> 
 * ����������ĳ�ʼ����
 *
 * @author yuanlin_csu
 * @create 2019/6/13
 * @since 1.0.0
 */
public class ArrayTest {

    @Test
    public void testArray(){

        // �������ֵ���Ǿ�̬�����ڶ����ڶ��󴴽�ʱ�Żᣬ��ʼ��Ĭ��ֵ
        ArrrayTestObject arrrayTestObjects1 = new ArrrayTestObject();

        System.out.println( "sss====" + arrrayTestObjects1.getCount());

        ArrrayTestObject [] arrrayTestObjects = new ArrrayTestObject[3];


        System.out.println("res = " + arrrayTestObjects[0].getCount());

    }




}
