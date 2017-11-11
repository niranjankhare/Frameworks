package org.seleniumng.ui;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

public class LibHtml {

    private static String addRowScriptTemplate  = "function add_fields() {var rowCount = document.getElementById('__TABLENAME__').getElementsByTagName(\"tbody\")[0].rows.length;document.getElementById(\"__TABLENAME__\").insertRow(-1).innerHTML = '__ROWHTML__';} ";

    private static String addRowScriptTemplateN = getScriptResource("addRows.js");                                                                                                                                                                                      // LibHtml.class.getResourceAsStream("");

    public static void main(String[] args) {
        LinkedHashMap<String, String> availableTypes = LibDatabase.getStandardTypes();
        String replaceText = "";
        for (Entry<String,String> e:availableTypes.entrySet()){
            replaceText = replaceText+"["+sq(e.getKey())+ "," + sq(e.getValue())+"]";
            replaceText = replaceText +",";
        }
        addRowScriptTemplateN = addRowScriptTemplateN.replaceAll("__OPTIONS__",replaceText.replaceAll(",$",""));
        System.out.println(addRowScriptTemplateN);
    }

    private static String sq(String str) {
        // TODO Auto-generated method stub
        return "'"+ str+"'";
    }

    private static String getScriptResource(String resouceName) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        InputStream inputStream = LibHtml.class.getResourceAsStream(resouceName);
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            // StandardCharsets.UTF_8.name() > JDK 7
            return result.toString("UTF-8");
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    // REQUIRED
    public static String getTableEntryForm(String tableName, String whereColumn, String hasValue) {
        // TODO: Get list of columns for the view/table
        tableName.replaceAll(tableName, tableName.toLowerCase());
        List<String> fieldsList = LibDatabase.getTableFields(tableName);
        if (whereColumn != null)
            fieldsList.remove(whereColumn);
        String scriptBlock = addRowScriptTemplate.replaceAll("__TABLENAME__", tableName).replaceAll("__ROWHTML__",
                getFormattedRow(fieldsList));
        scriptBlock = addRowScriptTemplateN.replaceAll("__OPTIONS__",getOptionsArray());
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
        if (whereColumn != null)
            form.appendChild(elPageName);
        form.appendChild(submit);
        html.body().before(scriptElement);
        html.body().appendChild(form);
        html.body().attr("onload", "add_fields()");

        return Parser.unescapeEntities(html.toString(), false);
    }

    public static String getPageEntryForm(String pageName) {
        String mainPropertiesView = "propsview";
        String extendedPropertiesView = "extendedpropsview";
        String whereColumn = "PAGENAME";

        mainPropertiesView.replaceAll(mainPropertiesView, mainPropertiesView.toLowerCase());
        List<String> mainFieldsList = LibDatabase.getTableFields(mainPropertiesView);
        List<String> extendedFieldsList = LibDatabase.getTableFields(extendedPropertiesView);
        mainFieldsList.remove(whereColumn);

        Element table = new Element("table").attr("id", mainPropertiesView);
        Element headerRow = new Element("tr");

        // Add columns to the displayed table as header row
        for (String field : mainFieldsList) {
            headerRow.appendElement("th").text(field);
        }

        headerRow.appendElement("th").text("More properties");

       // mainFieldsList.remove("CONTROLTYPE");
        String innerHtml = getFormattedRow(mainFieldsList, extendedFieldsList);

        String scriptBlock = addRowScriptTemplate.replaceAll("__TABLENAME__", mainPropertiesView)
                .replaceAll("__FIELDS__", getFieldsArray(mainFieldsList));
        scriptBlock = addRowScriptTemplateN.replaceAll("__OPTIONS__",getOptionsArray()).replaceAll("__FIELDS__", getFieldsArray(mainFieldsList));;
        Document html = Jsoup.parse("<html></html>");

        Element scriptElement = new Element("script").text(scriptBlock);

        Element tbody = new Element("tbody");

        table.appendChild(tbody);
        tbody.appendChild(headerRow);
        // tbody.appendChild(dataRow);

        // Form Submit elements:
        Element elTableName = new Element("input");
        elTableName.attr("type", "hidden");
        elTableName.attr("id", "tableName");
        elTableName.attr("name", "tableName");
        elTableName.attr("value", mainPropertiesView);

        Element elPageName = new Element("input");
        elPageName.attr("type", "hidden");
        elPageName.attr("id", "pageName");
        elPageName.attr("name", "pageName");
        elPageName.attr("value", pageName);

        Element addMore = new Element("input");
        addMore.attr("type", "button");
        addMore.attr("id", "addRow");
        addMore.attr("onclick", "add_fields();");
        addMore.attr("value", "Add row");

        Element submit = new Element("input");
        submit.attr("type", "submit");
        submit.attr("id", "submit");
        submit.attr("value", "Go!");
        Element parentPageDiv = new Element("div").attr("id", "formMainDiv").attr("style", "visibility=inherit;");
        parentPageDiv.appendChild(table);
        Element form = new Element("form").attr("id", "guimap").attr("method", "post").attr("action", "/updateTable");
        form.appendChild(parentPageDiv);
        form.appendChild(addMore);
        form.appendChild(elTableName);
        if (whereColumn != null)
            form.appendChild(elPageName);
        form.appendChild(submit);
        html.body().before(scriptElement);
        html.body().appendChild(form);
        html.body().attr("onload", "add_fields()");

        return Parser.unescapeEntities(html.toString(), false);

    }

    private static String getFieldsArray(List<String> fieldList) {
        String replaceText = "";
        for (String field:fieldList){
            replaceText = replaceText+ sq(field)+ ",";
        }
        replaceText = replaceText.replaceAll(",$","");
        return replaceText;
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
    private static String getFormattedRow(List<String> columns, List<String> inLinePopupList) {

        Element selectType = getTextArea("ELEMENTTYPE");
        selectType.tagName("select");
        selectType = addAvailableTypes(selectType);
        String idRow = "Row";
        Element row = new Element("tr").attr("id", idRow);
        row.appendChild(new Element("td").appendChild(selectType));
        // ones that need to be on main page: 4

        row = addColumnsToRow(row, columns);

        Element moreProps = new Element("button").attr("type", "button").attr("value", "...")
        // .attr() for onclick
        ;
        row.appendChild(moreProps);
        // create a cell that has teh divPopup for the row

        // now create div for inline popup

        // now i i propertymap
        // Move property map to Types
        // move extra props to different table .. all of it goes into
        // the inline popup!!
        String strElement = Parser.unescapeEntities(row.toString(), false);
        return strElement;
    }

    private static Element addColumnsToRow(Element row, List<String> columns) {
        for (String column : columns) {
            Element e = getTextArea(column);
            Element cell = new Element("td").appendChild(e);
            row.appendChild(cell);
        }

        return row;
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

        Element selectPage = new Element("select").attr("name", "pageName");
        selectPage = addAvailablePages(selectPage);

        Element form = new Element("form").attr("id", "guimap").attr("method", "post").attr("action", "/fetchPage");
        form.appendChild(selectPage);
        form.appendChild(new Element("input").attr("type", "submit").attr("value", "Fetch Entry Form"));
        html.body().appendChild(form);
        return Parser.unescapeEntities(html.toString(), false);
    }

    private static Element addAvailablePages(Element selectElement) {
        LinkedHashMap<String, String> availablePages = LibDatabase.getAvailablePages();
        return addOptionsToSelect(selectElement, availablePages);
    }

    private static Element addAvailableTypes(Element selectElement) {
        LinkedHashMap<String, String> availableTypes = LibDatabase.getStandardTypes();
        System.out.println(availableTypes.size());
        return addOptionsToSelect(selectElement, availableTypes);
    }
    
    private static String getOptionsArray() {
        LinkedHashMap<String, String> availableTypes = LibDatabase.getStandardTypes();
        String replaceText = "";
        for (Entry<String,String> e:availableTypes.entrySet()){
            replaceText = replaceText+"["+sq(e.getKey())+ "," + sq(e.getValue())+"]";
            replaceText = replaceText +",";
        }
        return replaceText.replaceAll(",$","");
    }
    private static Element addOptionsToSelect(Element selectElement, LinkedHashMap<String, String> map) {
        for (Entry<String, String> entry : map.entrySet()) {
            selectElement.appendChild(new Element("option").val(entry.getKey()).text(entry.getValue()));
        }
        return selectElement;
    }

    private static String getFormattedRow(List<String> columns) {

        Element selectType = getTextArea("ELEMENTTYPE");
        selectType.tagName("select");
        selectType = addAvailableTypes(selectType);
        Element row = new Element("tr");
        row.appendChild(new Element("td").appendChild(selectType));
        // ones that need to be on main page: 4
        // for (String column : columns) {
        int i = 0;
        for (i = 0; i <= 3; i++) {
            String column = columns.get(i);
            Element e = getTextArea(column);
            Element cell = new Element("td").appendChild(e);
            row.appendChild(cell);
        }
        // now i i propertymap
        // Move property map to Types
        String propertyMap = columns.get(i);
        // move extra props to different table .. all of it goes into
        // the inline popup!!
        String strElement = Parser.unescapeEntities(row.toString(), false);
        return strElement;
    }
}
