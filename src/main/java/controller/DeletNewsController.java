package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeletNewsController", value = "/deletNews")
public class DeletNewsController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idnNews = request.getParameter("idnNews");
        DBManager manager = new DBManager();
        manager.deletNews(idnNews);

        response.sendRedirect("/home");
    }
}
