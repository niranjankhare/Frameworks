package org.seleniumng.ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

public class OnView {

	public static void main (String[] args){
		Element e = getTextArea();
		String strElement = Parser.unescapeEntities(e.toString(),false);
		System.out.println(strElement.replaceAll("`\"", "").replaceAll("\"", "\\\""));
		//System.out.println(e.toString().replaceAll("\"&quot;", "\""));
	}
	
	public static Element getTextArea (){
		String columnName = "PAGENAME";
		String idNameStr = columnName+"\"+rowNum`";
		String rowNum = "1";
		Document html = Jsoup.parse("<html></html>");
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
