package org.seleniumng.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

//import edu.emory.mathcs.backport.java.util.Arrays;

public class OnView {

	public static void main (String[] args){
	    List<String> columns = Arrays.asList("PAGENAME","PARENTID");
	    Element row = new Element ("tr");
	    for (String column:columns){
	        Element e = getTextArea(column);
	        Element cell = new Element ("td").appendChild(e);
	        row.appendChild(cell);
	    }
		
		String strElement = Parser.unescapeEntities(row.toString(),false);
		System.out.println(strElement);
		//System.out.println(e.toString().replaceAll("\"&quot;", "\""));
	}
	
	public static Element getTextArea (String columnName){
		 
		String idNameStr = columnName+"'+rowCount+'";
//		String rowNum = "1";
//		Document html = Jsoup.parse("<html></html>");
		Element textArea = new Element ("textarea");
		textArea.attr("name",idNameStr)
		.attr("placeholder",columnName)
		.attr("id",idNameStr)
		.attr("style", "resize: none; width:100%;")
		;
		return textArea;
		
	}
//	<textarea name=\"Question'+rowCount+'\" placeholder=\"Question\" th:field=\"${questionAnswerSet.question}\" id=\"question'+rowCount+'\" style = \"resize: none; width:100%;\"></textarea>
}
