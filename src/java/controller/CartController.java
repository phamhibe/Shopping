/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
import dal.CartItem;
import dal.Customer;
import dal.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import models.CustomerDAO;
import models.ProductDAO;

/**
 *
 * @author msi
 */
public class CartController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pid = Integer.parseInt(req.getParameter("proID"));
        Product p = new ProductDAO().getProductsByProductID(pid);
        if (req.getSession().getAttribute("AccSession") != null) {
            Account a = (Account) req.getSession().getAttribute("AccSession");
            Customer c = new CustomerDAO().getCustomerbyID(a.getCustomerID());
            req.setAttribute("c", c);
        }
        ArrayList<CartItem> cartList = (ArrayList<CartItem>) req.getSession().getAttribute("CartSession");
        boolean buy = false;
        try {
            buy = Boolean.parseBoolean(req.getParameter("buy"));
        } catch (Exception e) {
            buy = false;
        }
        if (cartList == null) {
            cartList = new ArrayList<>();
            cartList.add(new CartItem(p, 1));
            req.getSession().setAttribute("CartSession", cartList);
        } else {
            if (!checkProductID(cartList, pid)) {
                cartList.add(new CartItem(p, 1));
            }
        }
        double total = 0;
        for (CartItem item : cartList) {
            total += item.getProduct().getUnitPrice() * item.getQuantity();
        }
        req.setAttribute("total", total);
        req.setAttribute("p", p);
        if (!buy) {
            resp.sendRedirect(req.getContextPath() + "/product/detail?proID=" + pid);
        } else {
            req.getRequestDispatcher("../cart.jsp").forward(req, resp);
        }
    }

    boolean checkProductID(ArrayList<CartItem> cartList, int id) {
        for (CartItem item : cartList) {
            if (item.getProduct().getProductID() == id) {
                item.setQuantity(item.getQuantity() + 1);
                return true;
            }
        }
        return false;
    }
}
