package org.seleniumng.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import java.lang.reflect.Field;
import java.sql.*;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
//import org.jooq.Table;
//import org.jooq.TableField;
import org.jooq.TableLike;
//import org.jooq.TableRecord;
import org.jooq.impl.DSL;


//import static db.jooq.generated.automationDb.Tables.*;
//import static org.jooq.impl.DSL.*;

public class LibDatabase {
    private static String userName = "manfriday";
    private static String password = "umsqa";
    private static String url = "jdbc:mysql://192.168.3.141:3306/automation";
    public static void main (String[] args){
        
        LinkedHashMap<String,String[]> parammap = new LinkedHashMap<String,String[]>();
        parammap.put("PARENTID1", new String[]{"id1"});
        parammap.put("PAGENAME1", new String[]{"name1"});
        parammap.put("PAGEDESCRIPTION1", new String[]{"desc1"});

        parammap.put("PARENTID2", new String[]{"id2"});
        parammap.put("PAGENAME2", new String[]{"name2"});
        parammap.put("PAGEDESCRIPTION2", new String[]{"desc2"});

        updateTable("SaMpLe", parammap);
    }
    
    
	public static List<String> getTableData (String tableName){
	    
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Result<Record> result  = null;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            result = create.select().from(tableName).fetch();
            System.out.println("done");

        }
            catch (Exception e) {
                e.printStackTrace();
         }
        
        org.jooq.Field<?>[] fieldList = result.fields();
       
        List<String> returnList = new ArrayList<String>();
        for (org.jooq.Field<?> tf:fieldList){
            returnList.add(tf.getName());
        }
        
	    return returnList;
	}


    public static void updateTable(String tableName, LinkedHashMap<String, String[]> parammap) {
        Result<Record> result  = null;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            //https://www.jooq.org/doc/3.8/manual/sql-building/sql-statements/insert-statement/insert-on-duplicate-key/
           
          Field f = null;
          try {
              f = db.jooq.generated.automationDb.Tables.class.getDeclaredField(tableName.toUpperCase());
          } catch (Exception e){
              
          }
          TableLike<?> table = null;
          if (TableLike.class.isAssignableFrom(f.getType())){ 
              try {
                  table = TableLike.class.cast(f.get(null));
              } catch (Exception e){
                  
              }
          }

          org.jooq.Field[] fields = table.fields(); 
          
//           create.insertInto(table.asTable(), fields[0]).values((Object)"PAGEnamenew1", (Object)"ParentPagenew1", (Object)"Newpagedesc").execute();
           create.insertInto(table.asTable()).set(fields[0], "Pagenamenew1").set(fields[1], "parentid2").set(fields[2], "Pagedescnew").execute();
            System.out.println("done");

        }
            catch (Exception e) {
                e.printStackTrace();
         }
        
    }
		
}

