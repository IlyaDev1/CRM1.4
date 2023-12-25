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

@WebServlet("/Task/index")
public class IndexServlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<TaskObject> tasks = TaskDB.select();
        request.setAttribute("tasks", tasks);

        request.getRequestDispatcher("/Task/index.jsp").forward(request, response);
    }
}