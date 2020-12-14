package com.helman.Controller;

import com.helman.Dao.Productdao;
import com.helman.Entity.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductAct", urlPatterns = {"/ProductAct"})
public class ProductCon extends HttpServlet {
    Productdao productdao = new Productdao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = new ArrayList<>();
        String productcode = req.getParameter("procode");

        if (productcode.isEmpty()){
            productList = productdao.findall();
        }else{
            productList.add(productdao.findById(productcode));
        }
        req.setAttribute("product", productList);
        req.getRequestDispatcher("/Product.jsp").forward(req, resp);
    }
}
