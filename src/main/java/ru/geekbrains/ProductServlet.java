package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository=(ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productRepository.findAll();

        resp.getWriter().println("<table>");
        resp.getWriter().println("<tr>");
        resp.getWriter().println("<th>ID</th>");
        //resp.getWriter().println("Id");
        //resp.getWriter().println("</th>");
        resp.getWriter().println("<th>Name</th>");
       // resp.getWriter().println("Name");
       // resp.getWriter().println("</th>");
        resp.getWriter().println("</tr>");

        for (Product ls : products) {
            resp.getWriter().println("<tr>");
            resp.getWriter().println("<td>");
            resp.getWriter().println(ls.getId());
            resp.getWriter().println("</td>");

            resp.getWriter().println("<td>");
            resp.getWriter().println(ls.getName());
            resp.getWriter().println("</td>");
            resp.getWriter().println("</tr>");
        }


        resp.getWriter().println("</table>");

    }
}
