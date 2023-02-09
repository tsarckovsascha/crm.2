package controller;

import DB.DBManager;
import entity.Term;
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
        String idTerm = request.getParameter("id_term");
        String selectId = request.getParameter("selectId");
        ArrayList<Term> terms = manager.getTermbyId(idTerm);
        ArrayList<Term> allTerms = manager.getTermbyId(idTerm);
        if (allTerms.isEmpty()) {

            request.setAttribute("id_term", idTerm);

            request.setAttribute("teremNull", 1);

            request.getRequestDispatcher("JSP/term.jsp").forward(request, response);


        } else {
            if (selectId == null) {
                term = allTerms.get(0);
            } else {
                term = Functions.getTermbyID(allTerms, selectId);
            }


            request.setAttribute("id_term", term);
            request.setAttribute("allTerms", allTerms);
            request.setAttribute("term", term);


            request.getRequestDispatcher("JSP/term.jsp").forward(request, response);
        }

    }
}
