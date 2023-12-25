package taskServlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import taskpackage.TaskObject;
import taskpackage.TaskDB;
 
 
@WebServlet("/Task/edit")
public class EditServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            TaskObject task = TaskDB.selectOne(id);
            if(task!=null) {
                request.setAttribute("task", task);
                getServletContext().getRequestDispatcher("/Task/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String text = request.getParameter("text");
            String start = request.getParameter("start");
            String end = request.getParameter("end");
            TaskObject task = new TaskObject(id, text, start, end);
            TaskDB.update(task);
            response.sendRedirect(request.getContextPath() + "/Task/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}