package controller;

import DB.DBManager;
import entity.News;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HomeController", value = "/home")

public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBManager manager = new DBManager();
        ArrayList<News> AllNews = manager.getAllNews();
        req.setAttribute("AllNews", AllNews);
        req.getRequestDispatcher("JSP/home.jsp").forward(req,resp);
    }
}
