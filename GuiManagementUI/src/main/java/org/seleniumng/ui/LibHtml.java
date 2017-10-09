package org.seleniumng.ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class LibHtml {
    
    private static String addRowScript = "function add_fields() {document.getElementById('myTable').insertRow(-1).innerHTML = '<tr><td><textarea name='Question' placeholder='Question' th:field='${questionAnswerSet.question}' id='question' style = 'resize: none; width:100%;'></textarea></td><td><textarea name='Answer' placeholder ='Answer' th: field='${questionAnswerSet.answer}' id='answer' style='resize:none;width: 100%;'></textarea></td ></tr>';}";
    
    public static void main(String[] args) {
        Document html = Jsoup.parse("<html></html>");
       
        Element scriptElement = new Element ("script").text(addRowScript);
        
        
//        .appendElement("table")
//        .appendElement("tr")
//        .appendElement("th")
        ;
//        print (html);
        
        Element table = new Element("table");
        Element headerRow = new Element("tr");
        headerRow.appendElement("th");
        
        Element dataRow = new Element("tr");
        
        dataRow.appendElement("td").appendElement("textarea").attr("name","Question");
        dataRow.appendElement("td").appendElement("textarea").attr("name","Answer");
        
        table.appendChild(headerRow);
        table.appendChild(dataRow);
        Element addMore = new Element ("input");
        addMore.attr("type", "button");
        addMore.attr("id", "addRow");
        addMore.attr("onclick","add_fields();");
        addMore.attr("value","Add row"); 
        html.body()
        .appendElement("div").appendChild(table);
        ;
        html.body().appendChild(addMore);
        html.body().before(scriptElement);
        print (html);
        
    }
    
    private static void print (Document d){
       System.out.println(d.toString());
    }
}

