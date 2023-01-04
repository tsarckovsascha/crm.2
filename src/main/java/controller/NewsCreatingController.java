package controller;

import DB.DBManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewsCreatingController", value = "/newsCreating")
public class NewsCreatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("JSP/newsCreating.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String header = request.getParameter("header");
        String text = request.getParameter("text");

        if (header.isEmpty() || text.isEmpty()) {
            request.setAttribute("error", 1);
            request.setAttribute("header", header);
            request.setAttribute("text", text);

            request.getRequestDispatcher("JSP/studentCreating.jsp").forward(request, response);

        }
        DBManager manager = new DBManager();
        manager.newsCreating(header, text);

        response.sendRedirect("/home");
    }
}