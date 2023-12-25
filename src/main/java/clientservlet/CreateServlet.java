package clientservlet;


import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clientpackage.ClientObject;
import clientpackage.ClientDB;
 
@WebServlet("/Client/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        getServletContext().getRequestDispatcher("/Client/create.jsp").forward(request, response);
    }
     
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            String name = request.getParameter("name");
            int lesson = Integer.parseInt(request.getParameter("lesson"));

            ClientObject client = new ClientObject(name, lesson);
            ClientDB.insert(client);
            response.sendRedirect(request.getContextPath()+"/Client/index.jsp");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/Client/create.jsp").forward(request, response); 
        }
    }
}