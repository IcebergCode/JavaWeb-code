package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/*
* 框架类
* */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        //可以创建任意类的对象，可以执行任意方法

        /*
        * 前提：奴能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
        * */

        /*Person p = new Person();
        p.eat();*/

        //1. 加载配置文件
        //1.1 创建Properties对象
        Properties pro = new Properties();
        //1.2 加载配置文件，转换为一个集合
        //1.2.1 获取class目录(就是类路径下)下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();//获取ReflectTest字节码文件所对应的类加载器
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        //2. 获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3. 加载该类进内存
        Class cls = Class.forName(className);   //将字节码文件加载进内存，返回Class对象

        //4. 创建对象
        Object obj = cls.newInstance();

        //5. 获取方法对象
        Method method = cls.getMethod(methodName);

        //6. 执行方法
        method.invoke(obj);

    }
}
