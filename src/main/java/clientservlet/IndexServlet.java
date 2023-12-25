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

@WebServlet("/Client/index")
public class IndexServlet extends HttpServlet {
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        ArrayList<ClientObject> clients = ClientDB.select();
        request.setAttribute("clients", clients);

        request.getRequestDispatcher("/Client/index.jsp").forward(request, response);
    }
}