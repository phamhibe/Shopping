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
public class EditProductController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ProductID = Integer.parseInt(req.getParameter("txtProductID"));
        String ProductName = req.getParameter("txtProductName");
        int CategoryID = Integer.parseInt(req.getParameter("ddlCategory"));
        String QuantityPerUnit = req.getParameter("txtQuantityPerUnit");
        double UnitPrice = Double.parseDouble(req.getParameter("txtUnitPrice"));
        int UnitsInStock = Integer.parseInt(req.getParameter("txtUnitsInStock"));
        int UnitsOnOrder = Integer.parseInt(req.getParameter("txtUnitsOnOrder"));
        int ReorderLevel = Integer.parseInt(req.getParameter("txtReorderLevel"));
        boolean Discontinued = Boolean.parseBoolean(req.getParameter("chkDiscontinued"));
        new ProductDAO().editProduct(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
        resp.sendRedirect("product-list");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("id"));
        Product p = new ProductDAO().getProductsByProductID(pid);
        req.setAttribute("p", p);
        ArrayList<Category> listC = new CategoryDAO().getCategories();
        req.setAttribute("listC", listC);
        req.getRequestDispatcher("edit-product.jsp").forward(req, resp);
    }

}
