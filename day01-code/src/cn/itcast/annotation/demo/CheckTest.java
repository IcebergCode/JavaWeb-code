package cn.itcast.annotation.demo;

import javafx.scene.chart.CategoryAxis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/*
* 简单的测试框架，相当于解析程序！！！
*
* 当主方法执行后，会自动执行被检测的所有方法(加了Check注解的方法)，判断方法是否有异常，记录到文件中
* */
public class CheckTest {
    public static void main(String[] args) throws IOException {
        //1. 创建Calculator对象
        Calculator c = new Calculator();

        //2. 获取字节码文件对象
        Class cls = c.getClass();

        //3. 获取所有的方法
        Method[] methods = cls.getMethods();

        int num = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            //4. 判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)){
                //5. 有注解，则执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //e.printStackTrace();
                    //6. 捕获异常

                    //记录到文件中
                    num++;
                    bw.write(method.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现" + num + "次异常");

        bw.flush();
        bw.close();
    }

}
