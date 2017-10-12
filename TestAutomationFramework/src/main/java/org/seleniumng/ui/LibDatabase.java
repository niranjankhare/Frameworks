package org.seleniumng.ui;

import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Field;
import java.sql.*;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.TableLike;
import org.jooq.impl.DSL;

import static db.jooq.generated.automationDb.Tables.*;
import static org.jooq.impl.DSL.*;

public class LibDatabase {

    public static void main (String[] args){
        getTableData("SaMpLe");
    }
    
    
	public static List<String> getTableData (String tableName){
	    String userName = "manfriday";
        String password = "umsqa";
        String url = "jdbc:mysql://localhost:3306/automation";
        Field f = null;
        try {
            f = db.jooq.generated.automationDb.Tables.class.getDeclaredField(tableName.toUpperCase());
        } catch (Exception e){
            
        }
        TableLike table = null;
        if (TableLike.class.isAssignableFrom(f.getType())) 
            try {
                table = TableLike.class.cast(f.get(null));
            } catch (Exception e){
                
            }

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        Result<Record> result  = null;
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            result = create.select().from(table).fetch();
            System.out.println("done");

        }
            catch (Exception e) {
                e.printStackTrace();
         }
        
        org.jooq.Field<?>[] fieldList = result.fields();
        org.jooq.Field<?> x = fieldList[0];
        List<String> returnList = new ArrayList<String>();
        for (org.jooq.Field tf:fieldList){
            returnList.add(tf.getName());
        }
        
	    return returnList;
	}
		
}

