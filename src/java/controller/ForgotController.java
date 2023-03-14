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
public class ForgotController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("txtEmail");
        Account acc = new AccountDAO().getAccountbyEmail(email);
        String pass = acc.getPassword();
            if (acc != null) {
                // Cap session
                req.getSession().setAttribute("passSession", pass);
                // Dieu huong toi 'index.jsp'
                resp.sendRedirect(req.getContextPath() + "/notforgot.jsp");
            } else {
                // Dong goi thong diep ve doGet (login.jsp)
                req.setAttribute("msg", "This account does not exist");
                req.getRequestDispatcher("../forgot.jsp").forward(req, resp);
            }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            resp.sendRedirect("../index.jsp");
        } else {
            req.getRequestDispatcher("../forgot.jsp").forward(req, resp);
        }
    }

}
