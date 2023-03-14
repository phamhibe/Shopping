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
public class CategoryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cateID = Integer.parseInt(req.getParameter("cateID"));
        ArrayList<Category> cateList = new CategoryDAO().getCategories();
        Category cate = new CategoryDAO().getCategoryByID(cateID);
        ArrayList<Product> proList = new ProductDAO().getProductsByCategoryID(cateID);
        req.setAttribute("cateID", cateID);
        req.setAttribute("listC", cateList);
        req.setAttribute("listP", proList);
        req.setAttribute("cate", cate);
        req.getRequestDispatcher("category.jsp").forward(req, resp);

    }
}
