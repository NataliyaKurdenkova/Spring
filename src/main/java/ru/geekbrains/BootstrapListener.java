package ru.geekbrains;

import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc=sce.getServletContext();
        ProductRepository productRepository=new ProductRepository();

        productRepository.save(new Product(1L,"Product1", 10));
        productRepository.save(new Product(2L,"Product2", 50));
        productRepository.save(new Product(3L,"Product3", 31));
        productRepository.save(new Product(4L,"Product4", 6));
        productRepository.save(new Product(5L,"Product5", 15));
        productRepository.save(new Product(6L,"Product6", 14));
        productRepository.save(new Product(7L,"Product7", 52));
        productRepository.save(new Product(8L,"Product8", 25));
        productRepository.save(new Product(9L,"Product9", 60));
        productRepository.save(new Product(10L,"Product10", 18));
        sc.setAttribute("productRepository",productRepository);
    }
}
