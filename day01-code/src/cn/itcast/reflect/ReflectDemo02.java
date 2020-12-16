package cn.itcast.reflect;

import cn.itcast.domain.Person;

import java.lang.reflect.Field;

public class ReflectDemo02 {
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

        /*
        * 1、获取成员变量们
                Field[] getFields()
                Field getField(String name)

                Field[] getDeclaredFields()
                Field getDeclaredField(String name)
        * */
        //1、Field[] getFields()：获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
			//field.setAccessible(true);	//进行了暴力反射，但是还是只获取了public修饰的成员变量a
            System.out.println(field);
        }
		System.out.println("---------------------");

        //2、Field getField(String name)：获取指定名称的public修饰的成员变量
		Field a = personClass.getField("a");
		//获取成员变量a的值
		Person p = new Person();
		Object value = a.get(p);	//需要实际传递一个实际Person对象进get方法内
		System.out.println(value);	//null
		//设置a的值
		a.set(p, "半藏");
		System.out.println(p);	//遍历p对象，重写toString方法后，public, protected, 默认的default, private成员变量都可以访问到
		System.out.println("=====================");

		//3、Field[] getDeclaredFields()：获取所有的成员变量，不考虑修饰符
		Field[] declaredFields = personClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {	//不用进行暴力反射，所有修饰符修饰的成员变量都能打印
			System.out.println(declaredField);
		}
		System.out.println("----------------------");

		//4、Field getDeclaredField(String name)：获取指定名称的成员变量，不考虑修饰符
		Field d = personClass.getDeclaredField("d");
		//在访问不是public修饰的成员变量时，需要忽略访问权限修饰符的安全检查，否则会报错
		d.setAccessible(true);	//暴力反射
		Object value2 = d.get(p);
		System.out.println(value2);
		d.set(p, "源氏");	//可以进行private修饰的成员变量的设置
		System.out.println(p);

	}
}
