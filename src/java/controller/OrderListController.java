/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
import dal.Customer;
import dal.Employee;
import dal.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CustomerDAO;
import models.EmployeeDAO;
import models.OrderDAO;

/**
 *
 * @author msi
 */
public class OrderListController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
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
            int count = new OrderDAO().getTotalOrder();
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
            String StartOrderDate = req.getParameter("txtStartOrderDate");
            String EndOrderDate = req.getParameter("txtEndOrderDate");
            ArrayList<Order> listO = new OrderDAO().pagingOrder(i);
            if (StartOrderDate != null && EndOrderDate != null) {
                listO = new OrderDAO().pagingOrderByOrderDate(StartOrderDate, EndOrderDate, i);
                count = new OrderDAO().getTotalOrderByOrderDate(StartOrderDate, EndOrderDate);
                endPage = count / 5;
                if (count % 5 != 0) {
                    endPage++;
                }
            }
            ArrayList<Employee> listE = new EmployeeDAO().getAllEmployees();
            ArrayList<Customer> listC = new CustomerDAO().getAllCustomer();
            req.setAttribute("StartOrderDate", StartOrderDate);
            req.setAttribute("EndOrderDate", EndOrderDate);
            req.setAttribute("listO", listO);
            req.setAttribute("listE", listE);
            req.setAttribute("listC", listC);
            req.setAttribute("endP", endPage);
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        }
    }
}
