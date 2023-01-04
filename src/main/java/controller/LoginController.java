package controller;

import DB.DBManager;
import entity.Role;
import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();
        request.setAttribute("allRole", allRole);

        request.getRequestDispatcher("JSP/login.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getParameter("login");
        request.getParameter("password");
        request.getParameter("rolId");

        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();

        if (login.isEmpty() || passord.isEmpty() || roleId.isEmpty()) {
            request.setAttribute("errorEmpty", 1);
            request.setAttribute("login", login);
            request.setAttribute("passord", passord);
            request.setAttribute("rolId", rolId);

            request.getRequestDispatcher("JSP/login.jsp").forward(request, response);


            if (manager.isLogin(login, passord, rolId)) {

                request.getSession().setAttribute("isLogin", 1);
                response.sendRedirect("JSP/home.jsp");
            } else {

                request.setAttribute("errorLogin", 1);
                request.setAttribute("allRole", allRole);
                request.getRequestDispatcher("JSP/login.jsp").forward(request, response);

            }
        }
    }
