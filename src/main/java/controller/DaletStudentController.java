package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DaletStudentController", value = "/daletStudent")
public class DaletStudentController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idsStudent = request.getParameter("idsStudent");
        DBManager manager = new DBManager();
        manager.daletStudent(idsStudent);

        response.sendRedirect("/student");
    }
}
