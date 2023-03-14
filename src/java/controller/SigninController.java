/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.Account;
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
public class SigninController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Lay du lieu tu 'login' form gui len
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPass");
        String msgEmail = "", msgPass = "";
        if (email.equals("")) {
            msgEmail = "Email is required";
            req.setAttribute("msgEmail", msgEmail);
        }

        if (pass.equals("")) {
            msgPass = "Password is required";
            req.setAttribute("msgPass", msgPass);
        }

        if (!msgEmail.equals("") || !msgPass.equals("")) {
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        } else {
            Account acc = new AccountDAO().getAccount(email, pass);
            if (acc != null) {
                // Cap session                   
                req.getSession().setAttribute("AccSession", acc);
                req.getSession().removeAttribute("CartSession");
                // Dieu huong toi 'index.jsp'
                if (acc.getRole() == 1) {
                    req.getRequestDispatcher("../dashboard.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/home");
                }
            } else {
                // Dong goi thong diep ve doGet (login.jsp)
                req.setAttribute("msg", "This account does not exist");
                req.getRequestDispatcher("../signin.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            req.getSession().removeAttribute("CartSession");
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        }
    }

}
