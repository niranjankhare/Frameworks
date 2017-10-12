package org.seleniumng.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

public class LibHtml {


//    private static String addRowScript  = "function add_fields() {var rowCount = document.getElementById('myTable').rows.length;document.getElementById(\"myTable\").getElementsByTagName(\"tbody\")[0].insertRow(-1).innerHTML = '<tr><td><textarea name=\"Question'+rowCount+'\" placeholder=\"Question\" id=\"question'+rowCount+'\" style = \"resize: none; width:100%;\"></textarea></td><td><textarea name=\"Answer'+rowCount+'\" placeholder =\"Answer\" id=\"answer'+rowCount+'\" style=\"resize:none;width: 100%;\"></textarea></td ></tr>';window.onload = add_fields();}";
    private static String addRowScriptBaseline  = "function add_fields() {var rowCount = document.getElementById('myTable').getElementsByTagName(\"tbody\")[0].rows.length;document.getElementById(\"myTable\").insertRow(-1).innerHTML = '<tr><td><textarea name=\"PAGENAME'+rowCount+'\" placeholder=\"PAGENAME\" id=\"PAGENAME'+rowCount+'\" style = \"resize: none; width:100%;\"></textarea></td><td><textarea name=\"PARENTID'+rowCount+'\" placeholder =\"PARENTID\" id=\"PARENTID'+rowCount+'\" style=\"resize:none;width: 100%;\"></textarea></td ></tr>';} ";
    private static String addRowScript = "function add_fields() {var rowCount = document.getElementById('myTable').getElementsByTagName(\"tbody\")[0].rows.length;document.getElementById(\"myTable\").insertRow(-1).innerHTML = '";
    private static String addRowScriptTemplate = "function add_fields() {var rowCount = document.getElementById('__TABLENAME__').getElementsByTagName(\"tbody\")[0].rows.length;document.getElementById(\"__TABLENAME__\").insertRow(-1).innerHTML = '__ROWHTML__';} ";
    public static void main(String[] args) {
    	getDocumentStr();
    }
    
    public static String getTableEntryForm (String tableName){
        //TODO: Get list of columns for the view/table 
        String scriptBlock = addRowScriptTemplate.replaceAll("__TABLENAME__", tableName).replaceAll("__ROWHTML__", getFormattedRow(Arrays.asList("PAGENAME","PARENTID")));
        
        Document html = Jsoup.parse("<html></html>");
        
        Element scriptElement = new Element ("script").text(scriptBlock);
        
        Element table = new Element("table").attr("id","myTable");
        Element headerRow = new Element("tr");
        headerRow.appendElement("th").text("PAGENAME");
        headerRow.appendElement("th").text("PARENTID");
        
        Element tbody = new Element("tbody");
        
        table.appendChild(tbody);
        tbody.appendChild(headerRow);
//        tbody.appendChild(dataRow);
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
        html.body().attr("onload", "add_fields()");
        
        return Parser.unescapeEntities(html.toString(),false);
    }
    
    
    public static Document getHtmlReponse() {
        String scriptBlock = addRowScript+ getHtml()+ "';} ";
        Document html = Jsoup.parse("<html></html>");
        
        Element scriptElement = new Element ("script").text(scriptBlock);
        
        Element table = new Element("table").attr("id","myTable");
        Element headerRow = new Element("tr");
        headerRow.appendElement("th").text("PAGENAME");
        headerRow.appendElement("th").text("PARENTID");
        
//        Element dataRow = new Element("tr");
        // TODO: parameterise based on table data // or do I run jscript on document load?
//        dataRow.appendElement("td").appendElement("textarea").attr("name","Question").attr("placeholder","Question").attr("id","question1").attr("style","resize: none; width: 100%;");
//        dataRow.appendElement("td").appendElement("textarea").attr("name","Answer").attr("placeholder","Answer").attr("id","answer1").attr("style","resize: none; width: 100%;");
        Element tbody = new Element("tbody");
        
        table.appendChild(tbody);
        tbody.appendChild(headerRow);
//        tbody.appendChild(dataRow);
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
        html.body().attr("onload", "add_fields()");

        return html;

		
	}

	public static String getDocumentStr (){
		String toPrint = Parser.unescapeEntities(getHtmlReponse().toString(),false);
       
       final File f = new File("generated.html");
       String fullPath = f.getAbsolutePath();
	System.out.println("Output html to:"+ fullPath );
       WriteFile(fullPath, toPrint);
       return toPrint;
    }
	
	private static void WriteFile (String fileName, String content){
		File f = new File(fileName);
		
		System.out.println(f.getName());
		FileOutputStream fo = null;
		if (!f.exists()){ 
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
		
		fo = new FileOutputStream(f);
		String b = content;
		fo.write(b.getBytes());
		fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    private static String getFormattedRow(List<String> columns){
        columns = Arrays.asList("PAGENAME","PARENTID");
        Element row = new Element ("tr");
        for (String column:columns){
            Element e = getTextArea(column);
            Element cell = new Element ("td").appendChild(e);
            row.appendChild(cell);
        }
        
        String strElement = Parser.unescapeEntities(row.toString(),false);
        return strElement;
    }
	
	private static String getHtml(){
	    List<String> columns = Arrays.asList("PAGENAME","PARENTID");
        Element row = new Element ("tr");
        for (String column:columns){
            Element e = getTextArea(column);
            Element cell = new Element ("td").appendChild(e);
            row.appendChild(cell);
        }
        
        String strElement = Parser.unescapeEntities(row.toString(),false);
        return strElement;
	}
	
	public static Element getTextArea (String columnName){
        
        String idNameStr = columnName+"'+rowCount+'";
//      String rowNum = "1";
//      Document html = Jsoup.parse("<html></html>");
        Element textArea = new Element ("textarea");
        textArea.attr("name",idNameStr)
        .attr("placeholder",columnName)
        .attr("id",idNameStr)
        .attr("style", "resize: none; width:100%;")
        ;
        return textArea;
        
    }
}

