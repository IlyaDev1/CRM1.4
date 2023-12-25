package lessonservlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import lessonpackage.LessonObject;
import lessonpackage.LessonDB;
 
 
@WebServlet("/Lesson/edit")
public class EditServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            LessonObject lesson = LessonDB.selectOne(id);
            if(lesson!=null) {
                request.setAttribute("lesson", lesson);
                getServletContext().getRequestDispatcher("/Lesson/edit.jsp").forward(request, response);
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
            String time = request.getParameter("time");
            String subject = request.getParameter("subject");
            String category = request.getParameter("category");
            LessonObject lesson = new LessonObject(id, time, subject, category);
            LessonDB.update(lesson);
            response.sendRedirect(request.getContextPath() + "/Lesson/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}