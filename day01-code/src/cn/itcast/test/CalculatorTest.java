package cn.itcast.test;

import cn.itcast.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    /*
    * 初始化方法：
    *       用于资源申请，所有测试方法在执行之前都会先执行该方法
    * */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /*
    * 释放资源方法：
    *       在所有测试方法执行完后，都会自动执行该方法
    * */
    @After
    public void close(){
        System.out.println("close...");
    }


    /*
    * 注意运行方法：testAdd和testSub可以单独运行
    * 1、在左边的绿色箭头运行；2、光标在哪个位置，右键运行就运行哪里
    * */

    /*
    * 测试add方法
    * */
    @Test
    public void testAdd(){
        //System.out.println("测试方法被执行了");
        //1、创建计算器对象
        Calculator c = new Calculator();
        //2、调用add方法
        int result = c.add(1, 2);
        System.out.println(result); //Calculator类中add方法改为相减
        System.out.println("testAdd...");

        //3、断言：我断言这个结果是3
        Assert.assertEquals(3, result);
        //System.out.println("testAdd...");   //上一行出错，本行不会再执行
    }

    @Test
    public void testSub(){
        //1、创建计算器对象
        Calculator c = new Calculator();
        //2、调用sub方法
        int result = c.sub(1, 2);
        System.out.println(result);
        System.out.println("testSub...");
        //3、断言：我断言这个结果是-1
        Assert.assertEquals(-1, result);
    }
}
