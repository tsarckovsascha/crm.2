package controller;

import DB.DBManager;
import entity.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentCreatingController", value = "/studentCreating")
public class StudentCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("JSP/studentCreating.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String groupName = request.getParameter("groupName");
        String registrationDate = request.getParameter("registrationDate");

        if (firstName.isEmpty() || lastName.isEmpty() || groupName.isEmpty() || registrationDate.isEmpty()) {
            request.setAttribute("error", 1);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("groupName", groupName);
            request.setAttribute("registrationDate", registrationDate);


            request.getRequestDispatcher("JSP/studentCreating.jsp").forward(request, response);

        }
        DBManager manager = new DBManager();
        manager.studentCreating(firstName, lastName, groupName, registrationDate);

        response.sendRedirect("/student");
    }
}

