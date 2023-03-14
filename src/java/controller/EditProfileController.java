/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
import dal.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import models.AccountDAO;
import models.CustomerDAO;

/**
 *
 * @author msi
 */
public class EditProfileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("cusID");
        String CompanyName = req.getParameter("txtCompanyName");
        String ContactName = req.getParameter("txtContactName");
        String ContactTitle = req.getParameter("txtContactTitle");
        String Address = req.getParameter("txtAddress");
        String Email = req.getParameter("txtEmail");
        String Password = req.getParameter("txtPassword");
        Customer cus = new Customer(id, CompanyName, ContactName, ContactTitle, Address);
        Account acc = new Account(0, Email, Password, id, 0, 0);
        new AccountDAO().updateAccount(acc, cus, id);
        resp.sendRedirect(req.getContextPath() + "/account/profile?cusID=" + cus.getCustomerID());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("cusID");
        Customer cus = new CustomerDAO().getCustomerbyID(id);
        req.setAttribute("cus", cus);
        req.getRequestDispatcher("../edit-profile.jsp").forward(req, resp);
    }

}
