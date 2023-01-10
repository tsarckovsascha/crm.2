package controller;

import DB.DBManager;
import entity.DisciplinMark;
import entity.Student;
import entity.Term;
import entity.Term_disciplin;
import funfactions.Functions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Term_disciplinController", value = "/term_disciplin")
public class Term_disciplinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        Term term = new Term();
        String id_term = request.getParameter("id_term");
        String selectId = request.getParameter("selectId");
        ArrayList<Term> allTerms = manager.getAllTermsByIdStudent(id_term);
        if (allTerms.isEmpty()) {

            request.setAttribute("id_term", id_term);

            request.setAttribute("teremNull", 1);

            request.getRequestDispatcher("JSP/term.jsp").forward(request, response);


        } else {


            if (selectId == null) {
                term = allTerms.get(0);
            } else {
                term = Functions.getAllStudentProgress(allTerms, selectId);
            }

            request.setAttribute("id_term", id_term);
            request.setAttribute("allTerms", allTerms);
            request.setAttribute("term", term);


            request.getRequestDispatcher("JSP/term.jsp").forward(request, response);
        }

    }
}
