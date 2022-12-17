package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "DeleteDisciplineController", value = "/deleteDiscipline")
public class DeleteDisciplineController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idsDiscipline = request.getParameter("idsDiscipline");
        DBManager manager = new DBManager();
        manager.deleteDiscipline(idsDiscipline);

        response.sendRedirect("/disciplins");
    }
}
