package cn.itcast.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 描述需要执行的类名，和方法名
* */
@Target({ElementType.TYPE}) //使Pro注解作用在类上
@Retention(RetentionPolicy.RUNTIME) //使Probably注解保留在RUNTIME阶段
public @interface Pro {
    String className();
    String methodName();
}
