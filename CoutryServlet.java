package com.kgisl.fetchapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * CoutryServlet
 */
@WebServlet("/country")
public class CoutryServlet extends HttpServlet {
    ArrayList<Country> coutrylist = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet doget");
        setAccessControlHeaders(resp);
        List<Object> list;

        String sql = "select * from datas";
        try {
            list = Mysqlconnect.getdbcon().resultSetToArrayList(sql);
            if (list != null) {
                List<Country> coutrylist = (List<Country>) (List<?>) list;
                String countryJsonString = new Gson().toJson(coutrylist);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(countryJsonString);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:9090/country");
        resp.setHeader("Access-Control-Allow-Methods", "GET");
    }

}