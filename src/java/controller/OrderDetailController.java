/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Order;
import dal.OrderDetail;
import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.OrderDAO;
import models.OrderDetailDAO;
import models.ProductDAO;

/**
 *
 * @author msi
 */
public class OrderDetailController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("orderID"));
        Order o = new OrderDAO().getOrderbyOrderID(id);
        req.setAttribute("o", o);
        ArrayList<OrderDetail> listOD = new OrderDetailDAO().getOrderDetailbyOrderID(o.getOrderID());
        req.setAttribute("listOD", listOD);
        ArrayList<Product> listP = new ProductDAO().getAllProducts();
        req.setAttribute("listP", listP);
        req.getRequestDispatcher("order-detail.jsp").forward(req, resp);
    }
    
}
