/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
import dal.CartItem;
import dal.Customer;
import dal.Employee;
import dal.Order;
import dal.OrderDetail;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import models.CustomerDAO;
import models.EmployeeDAO;
import models.OrderDAO;
import models.OrderDetailDAO;

/**
 *
 * @author msi
 */
public class CartActionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc = (Account) req.getSession().getAttribute("AccSession");
        ArrayList<CartItem> cartList = (ArrayList<CartItem>) req.getSession().getAttribute("CartSession");
        String CustomerID = randomString(5);
        String CompanyName = req.getParameter("txtCompanyName");
        String ContactName = req.getParameter("txtContactName");
        String ContactTitle = req.getParameter("txtContactTitle");
        String Address = req.getParameter("txtAddress");
        String RequiredDate = req.getParameter("txtRequiredDate");
        String msgCompanyName = "", msgContactName = "", msgContactTitle = "", msgAddress = "", msgRequiredDate = "", msgCart = "";
        if (CompanyName.equals("")) {
            msgCompanyName += "Company name is required";
            req.setAttribute("msgCompanyName", msgCompanyName);
        }
        if (ContactName.equals("")) {
            msgContactName += "Contact name is required";
            req.setAttribute("msgContactName", msgContactName);
        }
        if (ContactTitle.equals("")) {
            msgContactTitle += "Contact title is required";
            req.setAttribute("msgContactTitle", msgContactTitle);
        }
        if (Address.equals("")) {
            msgAddress += "Address is required";
            req.setAttribute("msgAddress", msgAddress);
        }
        if (RequiredDate.equals("")) {
            msgRequiredDate += "Required date is required";
            req.setAttribute("msgRequiredDate", msgRequiredDate);
        }
        if (cartList == null || cartList.size() == 0) {
            msgCart += "There are no products in the cart";
            req.setAttribute("msgCart", msgCart);
        }
        if (!msgCompanyName.equals("") || !msgContactName.equals("") || !msgContactName.equals("") || !msgAddress.equals("") || !msgRequiredDate.equals("") || !msgCart.equals("")) {
            req.getRequestDispatcher("../cart.jsp").forward(req, resp);
        } else {
            LocalDate loDate = java.time.LocalDate.now();
            Date OrderDate = Date.valueOf(loDate);
            ArrayList<Employee> listE = new EmployeeDAO().getAllEmployees();
            Random generator = new Random();
            int EmployeeID = generator.nextInt(listE.size()) + 1;
            Customer cus = null;
            Order o = null;
            OrderDetail od = null;
            if (acc != null) {
                cus = new CustomerDAO().getCustomerbyID(acc.getCustomerID());
                o = new Order(cus.getCustomerID(), EmployeeID ,OrderDate, Date.valueOf(RequiredDate), Address);
                new OrderDAO().AddOrder(cus, o);

            } else {
                cus = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address);
                o = new Order(cus.getCustomerID(), EmployeeID, OrderDate, Date.valueOf(RequiredDate), Address);
                new CustomerDAO().AddCustomer(cus);
                new OrderDAO().AddOrder(cus, o);
            }
            ArrayList<OrderDetail> odList = new ArrayList<>();
            for (CartItem item : cartList) {
                od = new OrderDetail(new OrderDAO().getLastOrder(), item.getProduct().getProductID(), item.getProduct().getUnitPrice(), item.getQuantity(), 0);
                odList.add(od);
            }
            for (OrderDetail item : odList) {
                new OrderDetailDAO().AddOrderDetail(item);
            }

            req.getSession().removeAttribute("CartSession");
            if (acc == null) {
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/account/all-order");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("CartSession") != null) {
            if (req.getSession().getAttribute("AccSession") != null) {
                Account a = (Account) req.getSession().getAttribute("AccSession");
                Customer c = new CustomerDAO().getCustomerbyID(a.getCustomerID());
                req.setAttribute("c", c);
            }
            int id = Integer.parseInt(req.getParameter("proID"));
            ArrayList<CartItem> cartList = (ArrayList<CartItem>) req.getSession().getAttribute("CartSession");
            boolean remove = Boolean.parseBoolean(req.getParameter("remove"));
            boolean sub = Boolean.parseBoolean(req.getParameter("sub"));
            boolean add = Boolean.parseBoolean(req.getParameter("add"));
            for (CartItem item : cartList) {
                if (item.getProduct().getProductID() == id) {
                    if (remove) {
                        cartList.remove(cartList.indexOf(item));
                        break;
                    }
                    if (add) {
                        item.setQuantity(item.getQuantity() + 1);
                        break;
                    }
                    if (sub) {
                        item.setQuantity(item.getQuantity() - 1);
                        if (item.getQuantity() == 0) {
                            cartList.remove(cartList.indexOf(item));
                            break;
                        }
                    }
                }
            }
            double total = 0;
            for (CartItem item : cartList) {
                total += item.getProduct().getUnitPrice() * item.getQuantity();
            }
            req.setAttribute("total", total);
            req.getSession().setAttribute("CartSession", cartList);
            req.getRequestDispatcher("../cart.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    private String randomString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
