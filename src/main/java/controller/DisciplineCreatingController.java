package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplineCreatingController", value = "/disciplineCreating")
public class DisciplineCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("JSP/disciplineCreating.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        request.setAttribute("error", 1);
        request.setAttribute("name", name);

        if (name.isEmpty()){
            request.getRequestDispatcher("JSP/disciplineCreating.jsp").forward(request, response);
        }
        DBManager manager = new DBManager();
        manager.DisciplinCreating(name);

        response.sendRedirect("/disciplins");
    }
}