/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Customer;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class CustomerDAO extends DBContext {

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "select * from Customers";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                String CustomerID = rs.getString("CustomerID");
                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                Customer c = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address);
                customers.add(c);
            }
        } catch (SQLException e) {
        }
        return customers;
    }
    
    public Customer getCustomerbyID(String id) {
        Customer customer = null;
        try {
            String sql = "select * from Customers where CustomerID = ?";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, id);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                String CustomerID = rs.getString("CustomerID");
                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                customer = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address);
            }
        } catch (SQLException e) {
        }
        return customer;
    }
    
    public void AddCustomer(Customer cus) {
        String sql = "insert into Customers values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cus.getCustomerID());
            ps.setString(2, cus.getCompanyName());
            ps.setString(3, cus.getContactName());
            ps.setString(4, cus.getContactTitle());
            ps.setString(5, cus.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public int getCountAllCus() {
        // Create : PrepareStatement
        try {
            String sql = "Select count(*) from Customers";
            PreparedStatement ps = connection.prepareStatement(sql);

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }
    
    public int getCountNewCus() {
        // Create : PrepareStatement
        LocalDate curD = java.time.LocalDate.now();
        String date = curD.toString();
        try {
            String sql = "select count(*) from Customers\n"
                    + "where ? - Date < 30";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, date);
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return 0;
    }
}
