package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ReflectDemo03 {
    /**
    * * Class对象功能
		* 获取功能
			1、获取成员变量们
				* Field[] getFields()
				* Field getField(String name)

				* Field[] getDeclaredFields()
				* Field getDeclaredField(String name)
			2、获取构造方法们
				* Constructor<?>[] getConstructors()
				* Constructor<T> getConstructor(类<?>... parameterTypes)

				* Constructor<?>[] getDeclaredConstructors()
				* Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
			3、获取成员方法们
				* Method[] getMethods()
				* Method getMethod(String name, 类<?>... parameterTypes)

				* Method[] getDeclaredMethods()
				* Method getDeclaredMethod(String name, 类<?>... parameterTypes)
			4、获取类名
				* String getName()
    * */
    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;
		/*获取构造方法们
			 * Constructor<?>[] getConstructors()
			 * Constructor<T> getConstructor(类<?>... parameterTypes)

			 * Constructor<?>[] getDeclaredConstructors()
			 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
		 * */

		//Constructor<T> getConstructor(类<?>... parameterTypes)：创建了带参构造器(构造器理解为：构造器/构造方法类对象)
		Constructor constructor1 = personClass.getConstructor(String.class, int.class);
		System.out.println(constructor1);
		//通过带参构造器创建对象
		Object person1 = constructor1.newInstance("麦克雷", 10);
		System.out.println(person1);
		System.out.println("-----------------------");

		//创建空参构造器
		Constructor constructor2 = personClass.getConstructor();
		System.out.println(constructor2);
		//通过空参构造器创建对象
		Object person2 = constructor2.newInstance();
		System.out.println(person2);

		//如果使用空参构造方法创建对象，操作可以简化：Class对象的newInstance方法
		//使用空参构造创建对象，用这种方式，不用上面的哪种方式(52-57行)！！这种方法简单
		Object o = personClass.newInstance();
		System.out.println(o);

		//constructor1.setAccessible(true);	//也有暴力反射的方法

	}
}
