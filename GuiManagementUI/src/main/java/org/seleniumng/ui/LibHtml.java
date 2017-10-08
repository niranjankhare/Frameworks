package org.seleniumng.ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LibHtml {
    public static void main(String[] args) {
        Document html = Jsoup.parse("<html></html>");
       
//        .appendElement("table")
//        .appendElement("tr")
//        .appendElement("th")
        ;
//        print (html);
        
        Element table = new Element("table");
        table.appendElement("tr").appendElement("th");
        table.appendElement("tr").appendElement("td").appendElement("textarea").attr("name","Question");
        html.body()
        .appendElement("div").appendChild(table);
        ;
        
        print (html);
        
    }
    
    private static void print (Document d){
       System.out.println(d.toString());
    }
}

