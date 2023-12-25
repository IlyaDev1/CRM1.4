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

@WebServlet("/Lesson/index")
public class IndexServlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<LessonObject> lessons = LessonDB.select();
        request.setAttribute("lessons", lessons);

        request.getRequestDispatcher("/Lesson/index.jsp").forward(request, response);
    }
}