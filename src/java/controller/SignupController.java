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

/**
 *
 * @author msi
 */
public class SignupController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") == null) {
            req.getRequestDispatcher("../signup.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String CompanyName = req.getParameter("txtCopName");
        String ContactName = req.getParameter("txtCName");
        String ContactTitle = req.getParameter("txtTitle");
        String Address = req.getParameter("txtAddress");
        String Email = req.getParameter("txtEmail");
        String Password = req.getParameter("txtPass");
        String RePassword = req.getParameter("txtRePass");
        String msgCopName = "", msgCName = "", msgTitle = "", msgAddress = "", msgEmail = "", msgPass = "", msgRePass = "", msgCheckPass = "", msgCheckEmail = "";
        if (CompanyName.equals("")) {
            msgCopName += "Company name is required";
            req.setAttribute("msgCopName", msgCopName);
        }
        if (ContactName.equals("")) {
            msgCName += "Contact name is required";
            req.setAttribute("msgCName", msgCName);
        }
        if (ContactTitle.equals("")) {
            msgTitle += "Contact title is required";
            req.setAttribute("msgTitle", msgTitle);
        }
        if (Address.equals("")) {
            msgAddress += "Address is required";
            req.setAttribute("msgAddress", msgAddress);
        }
        if (Email.equals("")) {
            msgEmail += "Email is required";
            req.setAttribute("msgEmail", msgEmail);
        }
        if (Password.equals("")) {
            msgPass += "Password is required";
            req.setAttribute("msgPass", msgPass);
        }
        if (RePassword.equals("")) {
            msgRePass += "Re-Password is required";
            req.setAttribute("msgRePass", msgRePass);
        }
        if (!Password.equals(RePassword)) {
            msgCheckPass += "Please check your password again";
            req.setAttribute("msgCheckPass", msgCheckPass);
        }
        if (!msgCopName.equals("") || !msgCName.equals("") || !msgTitle.equals("") || !msgAddress.equals("") || !msgEmail.equals("") || !msgPass.equals("") || !msgRePass.equals("") || !msgCheckPass.equals("")) {
            req.getRequestDispatcher("../signup.jsp").forward(req, resp);
        } else {
            Account account = new AccountDAO().checkAccountExist(Email);
            if (account == null) {
                String CustomerID = randomString(5);
                Customer cust = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address);
                Account acc = new Account(0, Email, Password, CustomerID, 0, 0);
                new AccountDAO().AddAccount(acc, cust);
                resp.sendRedirect("signin");
            } else {
                msgCheckEmail += "Email is existed";
                req.setAttribute("msgCheckEmail", msgCheckEmail);
                req.getRequestDispatcher("../signup.jsp").forward(req, resp);
            }
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
}
