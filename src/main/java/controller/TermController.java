package controller;

import DB.DBManager;
import entity.Term;
import entity.TermDisciplin;
import funfactions.Functions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TermController", value = "/term")
public class TermController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        Term term = new Term();
        //1. получить id Term
        String idTerm = req.getParameter("idTerm");
        String selectedId = req.getParameter("selectedId");
        Term termId = manager.getTermId(idTerm);
        // 2. получить все семестры
        ArrayList<Term> allTerm = manager.getTermbyId(idTerm);

        if (selectedId == null) {
            term = allTerm.get(0);
        } else {
            term = Functions.getTermbyID(allTerm, selectedId);
        }

        ArrayList <TermDisciplin> termDisciplin = manager.getDisciplineByTerm(term, idTerm);

        req.setAttribute("termId", termId);
        req.setAttribute("allTerm", allTerm);
        req.setAttribute("term", term);
        req.setAttribute("termDisciplin", termDisciplin);

        req.getRequestDispatcher("JSP/term.jsp").forward(req, resp);
    }
}
