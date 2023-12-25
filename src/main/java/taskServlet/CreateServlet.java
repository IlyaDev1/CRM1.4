package taskServlet;


import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taskpackage.TaskObject;
import taskpackage.TaskDB;
 
@WebServlet("/Task/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/Task/create.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String text = request.getParameter("text");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            
            TaskObject task = new TaskObject(text, start, end);
            TaskDB.insert(task);
            response.sendRedirect(request.getContextPath()+"/Task/index.jsp");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/Task/create.jsp").forward(request, response); 
        }
    }
}