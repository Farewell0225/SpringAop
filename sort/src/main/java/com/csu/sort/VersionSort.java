/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: VersionSort
 * Author:   yuanlin_csu
 * Date:     2019/12/19 15:00
 * Description: �汾������
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.sort;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * ��һ�仰���ܼ�����<br> 
 * ���汾������
 *
 * @author yuanlin_csu
 * @create 2019/12/19
 * @since 1.0.0
 */
public class VersionSort {

    public VersionSort(){
       super();
    }

    public static void main(String [] args) throws IOException {

        InputStream  inputStream =  Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("sort.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String tmpStr = null;
        Set<String> set = new TreeSet<String>();
        do {
            tmpStr = bufferedReader.readLine();
            if (StringUtils.isNotEmpty(tmpStr)){
                set.add(tmpStr);
            }

        }while(tmpStr != null);

        Iterator<String> it = set.iterator();
        StringBuilder resStrBuilder = new StringBuilder();
        while(it.hasNext()){
            resStrBuilder.append(it.next());
            resStrBuilder.append("|");
        }

        String resStr = resStrBuilder.toString();
        resStr = StringUtils.trim(resStr);
        System.out.println("1 = " + resStr);
        resStr = resStr + "|";
        System.out.println("2 = " + resStr);
        resStr = StringUtils.strip(resStr,"|");

        System.out.println(resStr);

    }



}
