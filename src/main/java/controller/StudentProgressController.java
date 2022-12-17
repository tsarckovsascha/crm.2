package controller;

import DB.DBManager;
import entity.Student;
import entity.StudentProgress;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentProgressController", value = "/studentProgress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        ArrayList<StudentProgress> getAllStudentProgress = manager.getAllStudentProgress();
        request.setAttribute("getAllStudentProgress", getAllStudentProgress);
        request.getRequestDispatcher("JSP/studentProgress.jsp").forward(request,response);
    }


}
