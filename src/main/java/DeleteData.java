import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        deleteCountry(req,resp);
    }

    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void deleteCountry(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       

        int id = Integer.parseInt(req.getParameter("id"));

        System.out.println("Deleted id :" + id);

    
        String query="delete from datas where id="+id+"";
        try {
            int rs = MysqlConnect.getDbCon().delete(query);
            System.out.println("the no of rows deleted   " + rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/");
        dispatcher.forward(req, resp);
   
      }

}