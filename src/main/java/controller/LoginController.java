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

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String rolId = request.getParameter("rolId");

        DBManager manager = new DBManager();
        ArrayList<Role> allRole = manager.getAllRole();



        if (login.isEmpty() || password.isEmpty() || rolId.isEmpty()) {
            request.setAttribute("errorEmpty", 1);
            request.setAttribute("login", login);
            request.setAttribute("password", password);
            request.setAttribute("allRole", allRole);

            request.getRequestDispatcher("JSP/login.jsp").forward(request, response);


            if (manager.isLogin(login, password, rolId)) {

                request.getSession().setAttribute("isLogin", 1);
                request.getSession().setAttribute("RoleId", 1);
                request.getSession().setAttribute("RoleName", 1);
                request.getSession().setAttribute("Name", 1);
                response.sendRedirect("JSP/home.jsp");
            } else {

                request.setAttribute("errorLogin", 1);
                request.setAttribute("allRole", allRole);
                request.getRequestDispatcher("JSP/login.jsp").forward(request, response);

            }
        }
    }
}
