/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Account;
import dal.Customer;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class AccountDAO extends DBContext {

    public Account getAccount(String email, String pass) {
        Account account = null;
        try {
            String sql = "select * from Accounts where Email=? and Password=?";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, email);
            ps.setString(2, pass);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
            }
        } catch (SQLException e) {
        }
        return account;
    }
    
    public Account checkAccountExist(String email) {
        Account account = null;
        try {
            String sql = "select * from Accounts where Email=?";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, email);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
                return account;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public void AddAccount(Account acc, Customer cust) {
        String sql1 = "insert into Customers values(?,?,?,?,?)";
        String sql2 = "insert into Accounts(Email,Password,CustomerID,Role) values (?,?,?,?)";
        try {
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, cust.getCustomerID());
            ps1.setString(2, cust.getCompanyName());
            ps1.setString(3, cust.getContactName());
            ps1.setString(4, cust.getContactTitle());
            ps1.setString(5, cust.getAddress());
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, acc.getEmail());
            ps2.setString(2, acc.getPassword());
            ps2.setString(3, cust.getCustomerID());
            ps2.setInt(4, 2);
            ps2.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account getAccountbyEmail(String email) {
        Account account = null;
        try {
            String sql = "select * from Accounts where Email = ?";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, email);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
            }
        } catch (SQLException e) {
        }
        return account;
    }
    
    public Account getAccountbyCustomerID(String id) {
        Account account = null;
        try {
            String sql = "select * from Accounts where CustomerID = ?";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, id);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role);
            }
        } catch (SQLException e) {
        }
        return account;
    }
    
    public void updateAccount(Account acc, Customer cust, String id) {
        String sql1 = "update Customers set CompanyName = ?, ContactName = ?, ContactTitle = ?, Address = ? where CustomerID = ?";
        String sql2 = "update Accounts set Email = ?, Password = ? where CustomerID = ?";
        try {
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setString(1, cust.getCompanyName());
            ps1.setString(2, cust.getContactName());
            ps1.setString(3, cust.getContactTitle());
            ps1.setString(4, cust.getAddress());
            ps1.setString(5, id);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setString(1, acc.getEmail());
            ps2.setString(2, acc.getPassword());
            ps2.setString(3, id);
            ps2.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int getCountOfAllAccount() {
        

        // Create : PrepareStatement
        try {
            String sql = "Select count(*) from Accounts";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
               return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }
}
