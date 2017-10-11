package org.seleniumng.ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.parser.Parser;

public class LibHtml {


    private static String addRowScript  = "function add_fields() {var rowCount = document.getElementById('myTable').rows.length;document.getElementById(\"myTable\").getElementsByTagName(\"tbody\")[0].insertRow(-1).innerHTML = '<tr><td><textarea name=\"Question'+rowCount+'\" placeholder=\"Question\" id=\"question'+rowCount+'\" style = \"resize: none; width:100%;\"></textarea></td><td><textarea name=\"Answer'+rowCount+'\" placeholder =\"Answer\" id=\"answer'+rowCount+'\" style=\"resize:none;width: 100%;\"></textarea></td ></tr>';window.onload = add_fields();}";

    public static void main(String[] args) {
    	getDocumentStr();
    }
    
    public static Document getHtmlReponse() {
        Document html = Jsoup.parse("<html></html>");
        
        Element scriptElement = new Element ("script").text(addRowScript);
        
        Element table = new Element("table").attr("id","myTable");
        Element headerRow = new Element("tr");
        headerRow.appendElement("th").text("Question");
        headerRow.appendElement("th").text("Answer");
        
        Element dataRow = new Element("tr");
        // TODO: parameterise based on table data // or do I run jscript on document load?
//        dataRow.appendElement("td").appendElement("textarea").attr("name","Question").attr("placeholder","Question").attr("id","question1").attr("style","resize: none; width: 100%;");
//        dataRow.appendElement("td").appendElement("textarea").attr("name","Answer").attr("placeholder","Answer").attr("id","answer1").attr("style","resize: none; width: 100%;");
        Element tbody = new Element("tbody");
        
        table.appendChild(tbody);
        tbody.appendChild(headerRow);
        tbody.appendChild(dataRow);
        Element addMore = new Element ("input");
        addMore.attr("type", "button");
        addMore.attr("id", "addRow");
        addMore.attr("onclick","add_fields();");
        addMore.attr("value","Add row"); 
        
        
        Element submit = new Element ("input");
        submit.attr("type", "submit");
        submit.attr("id", "submit");
        submit.attr("value", "Go!");
      
        Element form = new Element("form").attr("id", "guimap").attr("method", "post").attr("action", "/test");
        form.appendChild(table);
        form.appendChild(addMore);
        form.appendChild(submit);
        html.body().before(scriptElement);
        html.body().appendChild(form);

        return html;

		
	}

	public static String getDocumentStr (){
		String toPrint = Parser.unescapeEntities(getHtmlReponse().toString(),false);
       System.out.println(toPrint);
       return toPrint;
    }
    
    

}

