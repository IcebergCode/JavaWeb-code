package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo04 {
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

		/*获取成员方法们
			 * Method[] getMethods()
			 * Method getMethod(String name, 类<?>... parameterTypes)

			 * Method[] getDeclaredMethods()
			 * Method getDeclaredMethod(String name, 类<?>... parameterTypes)
		 * */

		//获取指定名称的方法
		Method eat_method1 = personClass.getMethod("eat");	//参数传递方法名称和参数列表，eat方法没有参数，就不传递了
		Person p = new Person();
		//执行方法
		eat_method1.invoke(p);

		Method eat_method2 = personClass.getMethod("eat", String.class);
		//执行方法
		eat_method2.invoke(p, "饭");
		System.out.println("---------------------");

		//获取所有public修饰的方法
		Method[] methods = personClass.getMethods();
		for (Method method : methods) {
			System.out.println(method);
			//method.setAccessible(true);	//也有暴力反射的方法
			String name = method.getName();
			System.out.println(name);
		}
		System.out.println("=================");


		//获取类名
		String className = personClass.getName();
		System.out.println(className);	//cn.itcast.domain.Person
	}
}
