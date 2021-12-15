package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter wr = resp.getWriter();

        if(req.getPathInfo()==null) {
            List<Product> products = productRepository.findAll();

            wr.println("<table>");
            wr.println("<tr>");
            wr.println("<th>ID</th>");

            wr.println("<th>Name</th>");

            wr.println("<th>Cost</th>");
            wr.println("</tr>");


            for (Product ls : products) {
                wr.println("<tr>");
                wr.println("<td>");
                wr.println(ls.getId());
                wr.println("</td>");


                wr.println("<td>");
                String urlProd=req.getContextPath()+req.getServletPath()+"/"+ls.getId();
                wr.println("<a href='"+urlProd+"'>"+ls.getName()+"</a>");
                wr.println("</td>");


                wr.println("<td>");
                wr.println(ls.getCost());
                wr.println("</td>");
                wr.println("</tr>");
            }


            wr.println("</table>");
        }else{
            if(req.getPathInfo()=="/5") {
                //String pathInfo=req.getPathInfo();
                // String[] tk = pathInfo.split("\\s", 1);
                long id = 5L;
                // id = (long) tk;

                Product pr = productRepository.findByID(id);
                wr.println("<table>");
                wr.println("<tr>");
                wr.println("<th>ID</th>");

                wr.println("<th>Name</th>");

                wr.println("<th>Cost</th>");
                wr.println("</tr>");


                wr.println("<tr>");
                wr.println("<td>");
                wr.println(pr.getId());
                wr.println("</td>");

                wr.println("<td>");
                wr.println(pr.getName());
                wr.println("</td>");


                wr.println("<td>");
                wr.println(pr.getCost());
                wr.println("</td>");
                wr.println("</tr>");
            }
        }

    }
}
