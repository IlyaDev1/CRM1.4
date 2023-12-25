package lessonservlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import lessonpackage.LessonDB;
 
@WebServlet("/Lesson/delete")
public class DeleteServlet extends HttpServlet {
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
         
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            LessonDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/Lesson/index");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}