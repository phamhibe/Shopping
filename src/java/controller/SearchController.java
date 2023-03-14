/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Category;
import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CategoryDAO;
import models.ProductDAO;

/**
 *
 * @author msi
 */
public class SearchController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("txtSearch");
        req.setAttribute("search", search);
        ArrayList<Product> listSearch = new ProductDAO().getProductsByProductName(search);
        req.setAttribute("listSearch", listSearch);
        ArrayList<Category> listC = new CategoryDAO().getCategories();
        req.setAttribute("listC", listC);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> listC = new CategoryDAO().getCategories();
        req.setAttribute("listC", listC);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }

}
