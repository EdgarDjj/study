package spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Description:
 * Jsoup测试
 *
 * @author:edgarding
 * @date:2021/3/3
 **/
public class JsoupTest {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://hellogithub.com/periodical/category/Java%20%E9%A1%B9%E7%9B%AE//").get();
//            System.out.println(doc);
//            Elements newHeadlines = doc.select("#mp-itn b a");
            System.out.println(doc.select("p"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
