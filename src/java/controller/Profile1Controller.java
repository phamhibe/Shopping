/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
import dal.Customer;
import dal.Order;
import dal.OrderDetail;
import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CustomerDAO;
import models.OrderDAO;
import models.OrderDetailDAO;
import models.ProductDAO;

/**
 *
 * @author msi
 */
public class Profile1Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("orderID"));
        new OrderDAO().cancelOrder(id);
        resp.sendRedirect(req.getContextPath() + "/account/cancel-order");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        Customer cus = new CustomerDAO().getCustomerbyID(acc.getCustomerID());
        req.setAttribute("cus", cus);
        ArrayList<Order> listO = new OrderDAO().getOrderbyCustomerID(acc.getCustomerID());
        req.setAttribute("listO", listO);
        ArrayList<OrderDetail> listOD = new OrderDetailDAO().getAllOrderDetail();
        req.setAttribute("listOD", listOD);
        ArrayList<Product> listP = new ProductDAO().getAllProducts();
        req.setAttribute("listP", listP);
        req.getRequestDispatcher("../profile1.jsp").forward(req, resp);
    }
}
