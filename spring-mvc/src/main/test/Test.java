/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: Test
 * Author:   yuanlin_csu
 * Date:     2019/6/3 15:45
 * Description: 测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈测试〉
 *
 * @author yuanlin_csu
 * @create 2019/6/3
 * @since 1.0.0
 */

class AddTest {
  public  int anInt = 0;
}


public class Test {


    public Test(){
        super();
    }


    public static void add(AddTest addTest){
       // addTest.anInt++;

        AddTest newAddTest = new AddTest();

        addTest = newAddTest;
        addTest.anInt++;

    }

    public static void add(String str){
        // 每一个String 都是会创建一个新的对象，从常量池中获取。
        str = "2";
    }

    public static  void main(String [] args){

        AddTest addTest = new AddTest();
        System.out.println( "first: "+ addTest.anInt);

        add(addTest);
        System.out.println("next: " + addTest.anInt);
        String str = "1";
        System.out.println("str: " + str);
        add(str);
        System.out.println("str2: " + str);




    }


}
