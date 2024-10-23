package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("x") == null || req.getParameter("y") == null || req.getParameter("r") == null || req.getParameter("key") == null)
            req.getServletContext().getNamedDispatcher("Controller").forward(req, resp);
        else getServletContext().getNamedDispatcher("AreaChecker").forward(req, resp);
    }

}