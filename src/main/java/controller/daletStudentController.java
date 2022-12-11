package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "daletStudentController", value = "/daletStudent")
public class daletStudentController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idStudent = request.getParameter("idStudent");
        DBManager manager = new DBManager();
        manager.daletStudent(idStudent);

        response.sendRedirect("/student");
    }
}
