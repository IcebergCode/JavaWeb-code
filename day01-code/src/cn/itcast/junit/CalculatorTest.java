package cn.itcast.junit;

public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();
        //调用方法
        /*int result1 = c.add(1, 2);
        System.out.println(result1);*/

        int result2 = c.sub(1, 2);
        System.out.println(result2);
    }
}
