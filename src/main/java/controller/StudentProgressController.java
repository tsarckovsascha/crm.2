package controller;

import DB.DBManager;
import entity.DisciplinMark;
import entity.Student;
import entity.Term;
import funfactions.Functions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentProgressController", value = "/studentProgress")
public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        Term term = new Term();
        String idStudent = request.getParameter("idStudent");
        String selectId = request.getParameter("selectId");
        Student student = manager.getAllStudentProgress(idStudent);
        ArrayList<Term> allTerms = manager.getAllTermsByIdStudent(idStudent);
        if (allTerms.isEmpty()) {

            request.setAttribute("student", student);

            request.setAttribute("teremNull", 1);

            request.getRequestDispatcher("JSP/studentProgress.jsp").forward(request, response);


        } else {


            if (selectId == null) {
                term = allTerms.get(0);
            } else {
                term = Functions.getAllStudentProgress(allTerms, selectId);
            }
            ArrayList<DisciplinMark> DisciplinMark = manager.getDisciplinMark(idStudent, term);

            double avaradeaMark = Functions.getAvaradeaMark(DisciplinMark);

            request.setAttribute("student", student);
            request.setAttribute("allTerms", allTerms);
            request.setAttribute("term", term);
            request.setAttribute("DisciplinMark", DisciplinMark);
            request.setAttribute("avaradeaMark", avaradeaMark);


            request.getRequestDispatcher("JSP/studentProgress.jsp").forward(request, response);
        }

    }

}
