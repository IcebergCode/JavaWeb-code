package cn.itcast.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 框架类
* */
@Pro(className = "cn.itcast.annotation.Demo1", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        /*
        * 前提：不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
        * */

        //1. 解析注解
        //1.1 获取该类(ReflectTest)的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;

        //2. 获取上面的注解对象
        /*
        * public class PorImpl implements Pro{
        *   public String className(){
        *       return "cn.itcast.annotation.Demo1";
        *   }
        *   public String methodName(){
        *       return "show";
        *   }
        * }
        * */
        Pro an = reflectTestClass.getAnnotation(Pro.class); //在内存中生成了一个该注解接口的子类实现对象，相当于23-30行代码

        //3. 调用注解对象中定义的抽象方法，获取返回值(拿到注解中定义的属性值)
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);  //cn.itcast.annotation.Demo1
        System.out.println(methodName); //show
        
        //4. 加载该类进内存
        Class cls = Class.forName(className);

        //5. 创建对象
        Object obj = cls.newInstance();

        //6. 获取方法对象
        Method method = cls.getMethod(methodName);

        //7. 执行方法
        method.invoke(obj); //demo1...show...

    }
}
