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
import org.jooq.InsertSetStep;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.TableLike;
import org.jooq.impl.DSL;

import db.jooq.generated.automationDb.*;
//import static org.jooq.impl.DSL.*;

public class LibDatabase {
    private static String       userName   = "manfriday";
    private static String       password   = "umsqa";
    private static String       url        = "jdbc:mysql://localhost:3306/automation";

    private static DSLContext   dslContext = initDbConnection();

    private static List<String> allTables  = getTableList();

    public static void main(String[] args) {

        LinkedHashMap<String, LinkedHashMap<String, String>> parammap = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        updateTable("Sample", parammap);
    }

    public static List<String> getTableData(String tableName) {

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Table result = null;

        List<Table<?>> tables = Automation.AUTOMATION.getTables();
        
        for (Table t:tables){
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

    public static void updateTable(String tableName,
            LinkedHashMap<String, LinkedHashMap<String, String>> cleanParamMap) {
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            // https://www.jooq.org/doc/3.8/manual/sql-building/sql-statements/insert-statement/insert-on-duplicate-key/

            TableLike<?> table = null;

            Field f = db.jooq.generated.automationDb.Tables.class.getDeclaredField(tableName.toUpperCase());
            if (TableLike.class.isAssignableFrom(f.getType())) {
                table = TableLike.class.cast(f.get(null));
            }

            org.jooq.Field[] fields = table.fields();

            for (Entry<String, LinkedHashMap<String, String>> row : cleanParamMap.entrySet()) {
                InsertSetStep<?> insertSetStep = create.insertInto(table.asTable());
                for (org.jooq.Field column : fields) {
                    insertSetStep.set(column, row.getValue().get(column.getName()));
                }
                int x = ((Query) insertSetStep).execute();
                System.out.println("Key:" + x);
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

    private static DSLContext initDbConnection() {
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn);
            return create;
        } catch (Exception e) {
            System.out.println("Unable to connect to database, Exiting!!:");
            e.printStackTrace();
            System.exit(-1);
            ;
            return null;
        }

    }


}
