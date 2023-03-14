/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
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
public class ProductListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        if (acc == null || acc.getRole() == 2) { 
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            String index = req.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int i = Integer.parseInt(index);
        req.setAttribute("page", i);
        int cid = 0;
        try {
            cid = Integer.parseInt(req.getParameter("ddlCategory"));
        } catch (Exception e) {
            cid = -1;
        }
        String search;
        boolean isEmpty = true;
        try {
            search = req.getParameter("txtSearch");
            isEmpty = search.isEmpty();
        } catch (Exception e) {
            search = "";
        }
        req.setAttribute("cid", cid);
        ArrayList<Category> listC = new CategoryDAO().getCategories();
        req.setAttribute("listC", listC);
        int count = new ProductDAO().getTotalProduct();
        int endPage = count / 5;
        if (count % 5 != 0) {
            endPage++;
        }
        ArrayList<Product> listP = new ProductDAO().pagingProduct(i);
        if (cid != -1) {
            listP = new ProductDAO().pagingProductByCategoryID(cid, i);
            count = new ProductDAO().getTotalProductByCategoryID(cid);
            endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
        }
        if (!isEmpty) {
            listP = new ProductDAO().pagingProductByProductName(search, i);
            count = new ProductDAO().getTotalProductByProductName(search);
            endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
        }
        if (cid != -1 && !isEmpty) {
            listP = new ProductDAO().pagingProductByCategoryIDandProductName(cid, search, i);
            count = new ProductDAO().getTotalProductByCategoryIDandProductName(cid, search);
            endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
        }
        req.setAttribute("cid", cid);
        req.setAttribute("search", search);
        req.setAttribute("listP", listP);
        req.setAttribute("endP", endPage);
        req.getRequestDispatcher("product.jsp").forward(req, resp);
        }    
    }

}
