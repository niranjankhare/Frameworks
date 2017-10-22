package org.seleniumng.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

public class LibHtml {

    private static String addRowScriptTemplate = "function add_fields() {var rowCount = document.getElementById('__TABLENAME__').getElementsByTagName(\"tbody\")[0].rows.length;document.getElementById(\"__TABLENAME__\").insertRow(-1).innerHTML = '__ROWHTML__';} ";

    public static void main(String[] args) {
        // Test block only
    }

    // REQUIRED
    public static String getTableEntryForm(String tableName, String whereColumn, String hasValue) {
        // TODO: Get list of columns for the view/table
        tableName.replaceAll(tableName, tableName.toLowerCase());
        List<String> fieldsList = LibDatabase.getTableFields(tableName);
        if (whereColumn != null)fieldsList.remove(whereColumn);
        String scriptBlock = addRowScriptTemplate.replaceAll("__TABLENAME__", tableName).replaceAll("__ROWHTML__",
                getFormattedRow(fieldsList));

        Document html = Jsoup.parse("<html></html>");

        Element scriptElement = new Element("script").text(scriptBlock);

        Element table = new Element("table").attr("id", tableName);
        Element headerRow = new Element("tr");

        // Add columns to the displayed table as header row
        for (String field : fieldsList) {
            headerRow.appendElement("th").text(field);
        }

        Element tbody = new Element("tbody");

        table.appendChild(tbody);
        tbody.appendChild(headerRow);
        // tbody.appendChild(dataRow);

        // Form Submit elements:
        Element elTableName = new Element("input");
        elTableName.attr("type", "hidden");
        elTableName.attr("id", "tableName");
        elTableName.attr("name", "tableName");
        elTableName.attr("value", tableName);

        Element elPageName = new Element("input");
        elPageName.attr("type", "hidden");
        elPageName.attr("id", "pageName");
        elPageName.attr("name", "pageName");
        elPageName.attr("value", hasValue);
        
        Element addMore = new Element("input");
        addMore.attr("type", "button");
        addMore.attr("id", "addRow");
        addMore.attr("onclick", "add_fields();");
        addMore.attr("value", "Add row");

        Element submit = new Element("input");
        submit.attr("type", "submit");
        submit.attr("id", "submit");
        submit.attr("value", "Go!");

        Element form = new Element("form").attr("id", "guimap").attr("method", "post").attr("action", "/updateTable");
        form.appendChild(table);
        form.appendChild(addMore);
        form.appendChild(elTableName);
        if (whereColumn!=null)
            form.appendChild(elPageName);
        form.appendChild(submit);
        html.body().before(scriptElement);
        html.body().appendChild(form);
        html.body().attr("onload", "add_fields()");

        return Parser.unescapeEntities(html.toString(), false);
    }

    public static String getPageEntryForm(String pageName) {
        return getTableEntryForm ("entryform","PAGENAME",pageName);
//        // TODO: Get list of columns for the view/table
//        
//        //pageName.replaceAll(pageName, pageName.toLowerCase());
//        List<String> fieldsList = LibDatabase.getTableFields("entryform");
//        fieldsList.remove("PAGENAME");
//        String scriptBlock = addRowScriptTemplate.replaceAll("__TABLENAME__", "entryform").replaceAll("__ROWHTML__",
//                getFormattedRow(fieldsList));
//
//        Document html = Jsoup.parse("<html></html>");
//        // hidden input for reflecting pageNmae for update tables:
//        
//        Element scriptElement = new Element("script").text(scriptBlock);
//
//        Element table = new Element("table").attr("id", "entryform");
//        Element headerRow = new Element("tr");
//
//        // Add columns to the displayed table as header row
//        for (String field : fieldsList) {
//            headerRow.appendElement("th").text(field);
//        }
//
//        Element tbody = new Element("tbody");
//
//        table.appendChild(tbody);
//        tbody.appendChild(headerRow);
//        // tbody.appendChild(dataRow);
//
//        // Form Submit elements:
//        Element name = new Element("input");
//        name.attr("type", "hidden");
//        name.attr("id", "pageName");
//        name.attr("name", "pageName");
//        name.attr("value", pageName);
//
//        Element addMore = new Element("input");
//        addMore.attr("type", "button");
//        addMore.attr("id", "addRow");
//        addMore.attr("onclick", "add_fields();");
//        addMore.attr("value", "Add row");
//
//        Element submit = new Element("input");
//        submit.attr("type", "submit");
//        submit.attr("id", "submit");
//        submit.attr("value", "Go!");
//
//        Element form = new Element("form").attr("id", "guimap").attr("method", "post").attr("action", "/updateTable");
//        form.appendChild(table);
//        form.appendChild(addMore);
//        form.appendChild(name);
//        form.appendChild(submit);
//        html.body().before(scriptElement);
//        html.body().appendChild(form);
//        html.body().attr("onload", "add_fields()");
//
//        return Parser.unescapeEntities(html.toString(), false);
    }

    private static void WriteFile(String fileName, String content) {
        File f = new File(fileName);

        System.out.println(f.getName());
        FileOutputStream fo = null;
        if (!f.exists()) {
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

    // REQUIRED
    private static String getFormattedRow(List<String> columns) {
        Element row = new Element("tr");
        for (String column : columns) {
            Element e = getTextArea(column);
            Element cell = new Element("td").appendChild(e);
            row.appendChild(cell);
        }

        String strElement = Parser.unescapeEntities(row.toString(), false);
        return strElement;
    }

    public static Element getTextArea(String columnName) {

        String idNameStr = "Row" + "'+rowCount+'" + "." + columnName;
        Element textArea = new Element("textarea");
        textArea.attr("name", idNameStr).attr("placeholder", columnName).attr("id", idNameStr).attr("style",
                "resize: none; width:100%;");
        return textArea;

    }

    public static String getWelcomeForm() {
        Document html = Jsoup.parse("<html></html>");
        html.body().appendElement("h2").text("Welcome to automation GUI map maintenance portal!");

        Element selectPage = new Element("select").attr("name","pageName");
        selectPage = addAvailablePages(selectPage);
        
        Element form = new Element("form").attr("id", "guimap").attr("method", "post").attr("action", "/fetchPage");
        form.appendChild(selectPage);
        form.appendChild(new Element ("input").attr("type", "submit").attr("value", "Fetch Entry Form"));
        html.body().appendChild(form);
        return Parser.unescapeEntities(html.toString(), false);
    }

    private static Element addAvailablePages(Element selectElement) {
        LinkedHashMap<String, String> availablePages = LibDatabase.getAvailablePages();
        return addOptionsToSelect(selectElement, availablePages);
    }
    
    private static Element addAvailableTypes(Element selectElement) {
        LinkedHashMap<String, String> availableTypes = LibDatabase.getStandardTypes();
        return addOptionsToSelect (selectElement,availableTypes);
    }
    
    private static Element addOptionsToSelect (Element selectElement,LinkedHashMap<String, String> map ){
        for (Entry<String, String> entry : map.entrySet()) {
            selectElement.appendChild(new Element("option").val(entry.getKey()).text(entry.getValue()));
        }
        return selectElement;
    }

}
