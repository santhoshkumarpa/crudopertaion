package com.kgisl.fetchapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
// import java.util.List;

// import com.mysql.cj.xdevapi.Statement;

/**
 * Mysqlconnect
 */
public class Mysqlconnect {

    private static Mysqlconnect db;
    private Statement statement;
    private  Connection conn;
    public static Object getdbcon;

    private Mysqlconnect(){
        String url="jdbc:mysql://localhost:3306/";
        String dbname="basedata";
        String username="root";
        String pass="";
        try {
            this.conn = DriverManager.getConnection(url + dbname, username, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
     }
     public static synchronized  Mysqlconnect getdbcon(){
         if(db==null){
             db=new Mysqlconnect();
         }
        return db;

     }
     public ArrayList<Object> resultSetToArrayList(String query) throws SQLException {
        statement = db.conn.createStatement();
        ResultSet rs = statement.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();

        ArrayList<Object> list = new ArrayList<Object>();
        while (rs.next()) {

            HashMap<Object, Object> row = new HashMap<>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            list.add(row);

        }

        return list;
    }
}