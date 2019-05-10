package com.kgisl.jdbcconnect;

import java.sql.*;

/**
 * ExcuteUpdate
 */
public class ExcuteUpdate {

    public static void main(String[] args) {
        try {
           // Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/basedata","root","");
            Statement stm=con.createStatement();
         //  int values = stm.executeUpdate("insert into datas(name,email) values('siva','siva@123.com')");
      //   stm.executeUpdate("update datas set name='santhosh_kumar',email='santhosh.pa@kgisl.com' where id=1");
      int i=stm.executeUpdate("insert into datas(name,email)values('santhosh','san@123.com')");
      

           System.out.println(i+" update colums");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}