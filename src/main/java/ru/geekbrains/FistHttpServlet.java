package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/http_servlet/*")
public class FistHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Привет новый сервлет</h1>");
        resp.getWriter().println("<p>contextPath:"+req.getContextPath()+"</p>");
        resp.getWriter().println("<p>servletPath:"+req.getServletPath()+"</p>");
        resp.getWriter().println("<p>PathInfo:"+req.getPathInfo()+"</p>");
        resp.getWriter().println("<p>QueryString:"+req.getQueryString()+"</p>");
        resp.getWriter().println("<p>param1:"+req.getParameter("param1")+"</p>");
        resp.getWriter().println("<p>param2:"+req.getParameter("param2")+"</p>");
        resp.getWriter().println("<p>param2:"+req.getParameter("id")+"</p>");
    }
}
