package controller;

import DB.DBManager;
import entity.Disciplins;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisciplinsController", value = "/disciplins")
public class DisciplinsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Disciplins> allDisciplins = manager.getAllDisciplins();
        request.setAttribute("allDisciplins", allDisciplins);
        request.getRequestDispatcher("JSP/disciplins.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
