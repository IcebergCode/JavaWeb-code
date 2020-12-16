package cn.itcast.annotation;

public @interface MyAnno {  //接口中能定义啥，注解中也能定义啥，因为注解的本质就是接口
    public abstract String name();  //称定义的抽象方法就为注解的属性

    int age();   //返回值是基本数据类型
    int length() default 100;   //使用MyAnno注解时候，不给length赋值，默认就是10

    //String show02();    //返回值是String类型

    Person per();   //返回值是一个枚举类型
    MyAnno2 anno2();    //返回值是注解

    String[] strs();    //返回值是String类型的数组

}
