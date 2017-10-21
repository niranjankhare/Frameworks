package org.seleniumng.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.lang.reflect.Field;
import java.sql.*;

import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.InsertResultStep;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep5;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;

import db.jooq.generated.automationDb.*;
import static db.jooq.generated.automationDb.tables.Guimap.*;
import static db.jooq.generated.automationDb.tables.Pages.*;
//import static org.jooq.impl.DSL.*;

public class LibDatabase {
    private static String       userName   = "manfriday";
    private static String       password   = "umsqa";
    private static String       url        = "jdbc:mysql://localhost:3306/automation";
    private static Connection conn  = initDbConnection();
    private static DSLContext   dslContext = DSL.using(conn);

    private static List<String> allTables  = getTableList();

    public static void main(String[] args) {

        LinkedHashMap<String, LinkedHashMap<String, String>> parammap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        getAvailablePages();
    }

    public static List<String> getTableFields(String tableName) {

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Table<?> result = null;
        List<Table<?>> tables = Automation.AUTOMATION.getTables();
        
        for (Table<?> t:tables){
            if (t.getName().toUpperCase().equals(tableName.toUpperCase())){
                result = t;
                break;
            }
        }
        
        org.jooq.Field<?>[] fieldList = result.fields();

        List<String> returnList = new ArrayList<String>();
        for (org.jooq.Field<?> tf : fieldList) {
            returnList.add(tf.getName());
        }

        return returnList;
    }

    public static void updateTable(String pageName,
            LinkedHashMap<String, LinkedHashMap<String, String>> cleanParamMap) {
        try  {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            // https://www.jooq.org/doc/3.8/manual/sql-building/sql-statements/insert-statement/insert-on-duplicate-key/

            Table<?> table = null;
//
//            Field f = db.jooq.generated.automationDb.Tables.class.getDeclaredField(tableName.toUpperCase());
//            if (TableLike.class.isAssignableFrom(f.getType())) {
//                table = TableLike.class.cast(f.get(null));
//            }
               
            table =GUIMAP;
            UniqueKey<?> pk = table.getPrimaryKey();
//            System.out.println(pk.g)
            org.jooq.Field[] fields = table.fields();
            
            
            for (Entry<String, LinkedHashMap<String, String>> row : cleanParamMap.entrySet()) {
                String elementType = row.getValue().get("ELEMENTTYPE");
                String controlName = row.getValue().get("CONTROLNAME");
                String controlDescription = row.getValue().get("CONTROLDESCRIPTION");
                InsertValuesStep5<?, String, String, String, String, String> insertSetStep = create.insertInto(table.asTable(),GUIMAP.PAGENAME,GUIMAP.ELEMENTTYPE ,
                        GUIMAP.CONTROLNAME, GUIMAP.CONTROLDESCRIPTION,GUIMAP.FIELDNAME);
                insertSetStep.values(pageName, elementType,controlName, controlDescription, elementType+controlName);
                insertSetStep.returning(GUIMAP.GUIMAPID, GUIMAP.ELEMENTTYPE);
                Result<?> x = ((InsertResultStep<?>) insertSetStep).fetch();
                
            }

            System.out.println("done");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static List<String> getTableList() {
        List<String> tables = new ArrayList<String>();
        for (TableLike<?> t : Automation.AUTOMATION.getTables()) {
            tables.add(((Table) t).getName());
        }
        return tables;
    }

    private static Connection initDbConnection() {
        try  {
            conn = DriverManager.getConnection(url, userName, password);
            return conn;
        } catch (Exception e) {
            System.out.println("Unable to connect to database, Exiting!!:");
            e.printStackTrace();
            System.exit(-1);
            ;
            return null;
        }

    }

    public static LinkedHashMap getAvailablePages() {
        LinkedHashMap<String, String> list = new LinkedHashMap<String,String>();
          SelectJoinStep<Record2<String, String>> x = dslContext.select(PAGES.PAGENAME,PAGES.PAGEDESCRIPTION ).from(PAGES);
//        Result<Record2<String, String>> r = x.fetch();
        for (Record rec: x.fetch()){
            
            list.put(rec.get(PAGES.PAGENAME),rec.get(PAGES.PAGEDESCRIPTION));
        }
         
        return list;
    }


}
