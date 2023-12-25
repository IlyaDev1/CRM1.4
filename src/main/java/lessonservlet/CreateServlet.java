package lessonservlet;


import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lessonpackage.LessonObject;
import lessonpackage.LessonDB;
 
@WebServlet("/Lesson/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/Lesson/create.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String time = request.getParameter("time");
            String subject = request.getParameter("subject");
            String category = request.getParameter("category");

            LessonObject lesson = new LessonObject(time, subject, category);
            LessonDB.insert(lesson);
            response.sendRedirect(request.getContextPath()+"/Lesson/index.jsp");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/Lesson/create.jsp").forward(request, response); 
        }
    }
}