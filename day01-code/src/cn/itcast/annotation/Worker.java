package cn.itcast.annotation;

@MyAnno(name = "源氏", age = 1, per = Person.P1, anno2 = @MyAnno2, strs = {"aaa", "bbb"})
@MyAnno3
public class Worker {

    @MyAnno3
    public String name = "aaa";

    @MyAnno3
    public void show(){

    }
}
