package com.kg.xmlhttprequest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



/**
 * HelloServlet
 * 
 * @param <Country>
 */
@WebServlet("/country/*")
public class HelloServlet<Country> extends HttpServlet {
String action="",
mode="";
    ArrayList<Country> countryList = new ArrayList<Country>();
    private Gson gson = new Gson();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("EDIT method called");
    //      String mode=req.getParameter("mode");
    //   System.out.println("mode value called::"+mode);
    int id=Integer.parseInt(req.getParameter("id"));
    String name=req.getParameter("name");
  
    
        System.out.println("inside if::"+id+name);

    String query = "UPDATE countrylist SET id="+id+",name='"+name+"' where id="+id;
    try{
    int rs = MysqlConnect.getDbCon().edit(query);
    System.out.println("the no of rows edited   "+rs);
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = "SELECT * from countrylist";
        try {
            
            List<Object> list = MysqlConnect.getDbCon().resultSetToArrayList(query);
            List<Country> countryList = (List<Country>)(List<?>)list;
            
            String countryJsonString = new Gson().toJson(countryList);
            System.out.println(countryJsonString);

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(countryJsonString);

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    System.out.println("dodelete method called");
    int id=Integer.parseInt(req.getParameter("id"));
    String query = "DELETE from countrylist where id="+id;
    try{
    int rs = MysqlConnect.getDbCon().delete(query);
    System.out.println("the no of rows deleted   "+rs);
   

    }
catch (SQLException e) {
            e.printStackTrace();
        }
}

protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("insert method called");
         String mode=req.getParameter("mode");
      System.out.println("mode value called::"+mode);
    int id=Integer.parseInt(req.getParameter("id"));
    String name=req.getParameter("name");
  
    System.out.println(id+name);
       
        
    String query = "INSERT INTO countrylist (id, name) VALUES ("+id+",'"+name+"')";
    try{
    int rs = MysqlConnect.getDbCon().insert(query);
    System.out.println("the no of rows inserted   "+rs);
    } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}