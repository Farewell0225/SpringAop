/**
 * Copyright (C), 2018-2019, XXX���޹�˾
 * FileName: Audience
 * Author:   yuanlin_csu
 * Date:     2019/4/16 14:54
 * Description: ����
 * History:
 * <author>          <time>          <version>          <desc>
 * ��������           �޸�ʱ��           �汾��              ����
 */
package com.csu.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * ��һ�仰���ܼ�����<br> 
 * �����桵
 *
 * @author yuanlin_csu
 * @create 2019/4/16
 * @since 1.0.0
 */
@Aspect
public class Audience {

    /*@Pointcut("execution(** com.csu.concert.Performance.perform(..))")
    public void perform(){}*/

    @Before("execution(** com.csu.concert.Performance.perform(..))")
    public void selienceCellPhones(){
        System.out.println("Selience Cell Phones 111");
    }

    @Before("execution(** com.csu.concert.Performance.perform(..))")
    public void takeSeats(){

        System.out.println("Taking Seats 222");

    }

    @AfterReturning("execution(** com.csu.concert.Performance.perform(..))")
    public void applause(){
        System.out.println("clap clap clap!!! 333");

    }

    @AfterThrowing("execution(** com.csu.concert.Performance.perform(..))")
    public void demandRefund() {

        System.out.println("demanding Refund 444");

    }

    @Around("execution( ** com.csu.concert.Performance.perform(..))")
    public void watchPerformance(ProceedingJoinPoint joinPoint){

        try {

            System.out.println("Selience Cell Phones 555");
            System.out.println("Taking Seats 666");
            joinPoint.proceed();
            System.out.println("clap clap clap!!! 777");

        } catch (Throwable throwable) {

            System.out.println("demanding Refund 88");
        }

    }




}
