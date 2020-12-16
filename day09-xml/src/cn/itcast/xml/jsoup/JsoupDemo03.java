package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
* Document/Element对象快速入门（Document继承自Element。Elements继承自ArrayList）
*
        getElementById(String id)：根据id属性值获取唯一的element对象
        getElementsByTag(String tagName)：根据标签名称获取元素对象集合
        getElementsByAttribute(String key)：根据属性名称获取元素对象集合
        getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
* */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        //2.1 获取student.xml的path
        String path = JsoupDemo03.class.getClassLoader().getResource("student.xml").getPath();
        //path输出为：/D:/JavaProject/IDEAProject/javaweb-code/out/production/day9-xml/student.xml

        //2. 获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3. 获取元素对象
        //3.1 获取所有student对象。getElementsByTag(String tagName)：根据标签名称获取元素对象集合
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("---------------------");

        //3.2 获取属性名为id的元素对象们。getElementsByAttribute(String key)：根据属性名称获取元素对象集合
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("---------------------");

        //3.2 获取number属性值为heima_0001的元素对象。getElementsByAttributeValue(String key, String value)：根据对应的属性名和属性值获取元素对象集合
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);
        System.out.println("---------------------");

        //3.3 获取id属性值的元素对象。getElementById(String id)：根据id属性值获取唯一的element对象
        Element elements3 = document.getElementById("itcast");
        System.out.println(elements3);


    }
}
