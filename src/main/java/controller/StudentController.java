package controller;

import DB.DBManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<Student> allStudent = manager.getAllStudent();
        request.setAttribute("allStudent", allStudent);
        request.getRequestDispatcher("JSP/student.jsp").forward(request,response);

    }


}
