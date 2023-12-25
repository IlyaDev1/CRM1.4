package clientservlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import clientpackage.ClientObject;
import clientpackage.ClientDB;
 
 
@WebServlet("/Client/edit")
public class EditServlet extends HttpServlet {
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
 
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ClientObject client = ClientDB.selectOne(id);
            if(client!=null) {
                request.setAttribute("client", client);
                getServletContext().getRequestDispatcher("/Client/edit.jsp").forward(request, response);
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
            String name = request.getParameter("name");
            int lesson = Integer.parseInt(request.getParameter("lesson"));
            ClientObject client = new ClientObject(id, name, lesson);
            ClientDB.update(client);
            response.sendRedirect(request.getContextPath() + "/Client/index");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }
}