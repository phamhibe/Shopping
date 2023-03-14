/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.OrderDetail;
import dal.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class OrderDetailDAO extends DBContext {

    public void AddOrderDetail(OrderDetail od) {
        String sql = "insert into [Order Details](OrderID, ProductID, UnitPrice, Quantity) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, od.getOrderID());
            ps.setInt(2, od.getProductID());
            ps.setDouble(3, od.getUnitPrice());
            ps.setInt(4, od.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<OrderDetail> getOrderDetailbyOrderID(int id) {
        ArrayList<OrderDetail> listOD = new ArrayList<>();
        try {
            String sql = "select * from [Order Details] where OrderID = ?";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setInt(1, id);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int OrderID = rs.getInt("OrderID");
                int ProductID = rs.getInt("ProductID");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                OrderDetail orderdetail = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount);
                listOD.add(orderdetail);
            }
        } catch (SQLException e) {
        }
        return listOD;
    }

    public static void main(String[] args) {
        ArrayList<OrderDetail> list = new OrderDetailDAO().getAllOrderDetail();
        for (OrderDetail orderDetail : list) {
            Product p = new ProductDAO().getProductsByProductID(orderDetail.getProductID());
            System.out.println(p);
        }
    }

    public ArrayList<OrderDetail> getAllOrderDetail() {
        ArrayList<OrderDetail> listOD = new ArrayList<>();
        try {
            String sql = "select * from [Order Details]";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int OrderID = rs.getInt("OrderID");
                int ProductID = rs.getInt("ProductID");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                OrderDetail orderdetail = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount);
                listOD.add(orderdetail);
            }
        } catch (SQLException e) {
        }
        return listOD;
    }
    
    public ArrayList<OrderDetail> getWeeklySaleByOrdDet() {
        ArrayList<OrderDetail> ord = new ArrayList<>();
        LocalDate curD = java.time.LocalDate.now();
        String date = curD.toString();
        // Create : PrepareStatement
        try {
            String sql = "select od.OrderID, od.ProductID, od.UnitPrice, od.Quantity, od.Discount from [Order Details]  od\n"
                    + "join Orders o\n"
                    + "on o.OrderID = od.OrderID\n"
                    + "where ? - o.OrderDate < 7";
            PreparedStatement ps = connection.prepareStatement(sql);

            //Set value
            ps.setString(1, date);

            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {
                // Take data from 'rs' to biencucbo
                int OrderID = rs.getInt("OrderID");
                int ProductID = rs.getInt("ProductID");
                double UnitPrice = rs.getDouble("UnitPrice");
                int Quantity = rs.getInt("Quantity");
                double Discount = rs.getDouble("Discount");
                // Intinilizial object 
                OrderDetail ordt = new OrderDetail(OrderID, ProductID, UnitPrice, Quantity, Discount);
                // Add p to arraylist
                ord.add(ordt);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return ord;
    }
}
