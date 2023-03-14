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
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> cateList = new CategoryDAO().getCategories();
        ArrayList<Product> proList = new ProductDAO().getProductsHot();
        ArrayList<Product> proList1 = new ProductDAO().getProductsBestSale();
        ArrayList<Product> proList2 = new ProductDAO().getProductsNew();
        // Chuyen tiep du lieu ra View
        req.setAttribute("listC", cateList);
        req.setAttribute("listP", proList);
        req.setAttribute("listP1", proList1);
        req.setAttribute("listP2", proList2);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
