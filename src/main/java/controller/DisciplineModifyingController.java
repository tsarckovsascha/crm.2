package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DisciplineModifyingController", value = "/disciplineModifying")
public class DisciplineModifyingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("JSP/disciplineModifying.jsp").forward(request,response);
    }

}
