package cn.itcast.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
* Jsoup快速入门
* */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //2.1 获取student.xml的path
        String path = JsoupDemo02.class.getClassLoader().getResource("student.xml").getPath();
        //path输出为：/D:/JavaProject/IDEAProject/javaweb-code/out/production/day9-xml/student.xml

        //2.2 解析xml文档，加载文档进内存，获取dom树--->Document
        //parse方法一：parse(File in, String charsetName)：解析xml或html文件的。
       /* Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/

       //parse方法二：parse​(String html)：解析xml或html字符串
        /*String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\n" +
                " <students>\n" +
                "\t<student number=\"heima_0001\">\n" +
                "\t\t<name>tom</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\t\t \n" +
                " </students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/

        //parse方法三：parse​(URL url, int timeoutMillis)：通过网络路径指获取指定的html或xml的文档对象
        URL url = new URL("https://www.baidu.com/index.php?tn=monline_3_dg");  //代表网络中的一个路径
        Document document = Jsoup.parse(url, 1000);
        System.out.println(document);


    }
}
