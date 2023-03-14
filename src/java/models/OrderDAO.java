/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Customer;
import dal.DBContext;
import dal.Order;
import dal.Year;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class OrderDAO extends DBContext {

    public void AddOrder(Customer cus, Order o) {
        String sql = "insert into Orders(CustomerID, EmployeeID, OrderDate, RequiredDate, ShipAddress) values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cus.getCustomerID());
            ps.setInt(2, o.getEmployeeID());
            ps.setDate(3, o.getOrderDate());
            ps.setDate(4, o.getRequiredDate());
            ps.setString(5, o.getShipAddress());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getLastOrder() {
        int OrderID = 0;
        try {
            String sql = "select * from Orders where OrderID = (select max(OrderID) from Orders)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderID = rs.getInt("OrderID");
            }
        } catch (Exception e) {
        }
        return OrderID;
    }

    public ArrayList<Order> getOrderbyCustomerID(String id) {
        ArrayList<Order> listO = new ArrayList<>();
        try {
            String sql = "select * from Orders where CustomerID = ?\n"
                    + "order by OrderID desc";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, id);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                Order order = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                listO.add(order);
            }
        } catch (SQLException e) {
        }
        return listO;
    }

    public ArrayList<Order> getOrderbyCustomerIDv2(String id) {
        ArrayList<Order> listO = new ArrayList<>();
        try {
            String sql = "select * from Orders where CustomerID = ? and RequiredDate is null\n"
                    + "order by OrderID desc";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, id);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                Order order = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                listO.add(order);
            }
        } catch (SQLException e) {
        }
        return listO;
    }

    public ArrayList<Order> getAllOrder() {
        ArrayList<Order> listO = new ArrayList<>();
        try {
            String sql = "select * from Orders\n"
                    + "order by OrderID desc";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                Order order = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                listO.add(order);
            }
        } catch (SQLException e) {
        }
        return listO;
    }

    public ArrayList<Order> getOrderbyOrderDate(String fromDate, String toDate) {
        ArrayList<Order> listO = new ArrayList<>();
        try {
            String sql = "select * from Orders where OrderDate between ? and ?"
                    + "order by OrderID desc";
            // B2: Tao doi tuong PrepareStatment
            PreparedStatement ps = connection.prepareStatement(sql);
            // Set cac gia tri cho cac tham so cua 'sql'
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            // B3: Thuc thi truy van
            ResultSet rs = ps.executeQuery();
            // B4: Xu ly ket qua tra ve
            while (rs.next()) {
                // Lay du lieu tu 'rs' gan cho cac bien cuc bo
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                Order order = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                listO.add(order);
            }
        } catch (SQLException e) {
        }
        return listO;
    }

    public ArrayList<Order> pagingOrder(int index) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "select * from Orders\n"
                    + "order by OrderID desc\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                Order o = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                orders.add(o);
            }
        } catch (Exception e) {
        }
        return orders;
    }

    public ArrayList<Order> pagingOrderByOrderDate(String fromDate, String toDate, int index) {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            String sql = "select * from Orders where OrderDate between ? and ?\n"
                    + "order by OrderID desc\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ps.setInt(3, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                Order o = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
                orders.add(o);
            }
        } catch (Exception e) {
        }
        return orders;
    }

    public int getTotalOrder() {
        String sql = "select count(*) from Orders";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalOrderByOrderDate(String fromDate, String toDate) {
        String sql = "select count(*) from Orders where OrderDate between ? and ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public void cancelOrder(int OrderID) {
        String sql = "update Orders set RequiredDate = null where OrderID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, OrderID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int countOrderByMonth(int month) {
        try {
            String sql = "SELECT count(*) from Orders \n"
                    + "where MONTH(OrderDate) = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, month);

            //Set value
            // Implement statement
            ResultSet rs = ps.executeQuery();

            // Progress result returned
            while (rs.next()) {

                return rs.getInt(1);
            }
        } catch (Exception e) {
        }

        return 0;
    }

    public ArrayList<Integer> getYearOrderDate() {
        ArrayList<Integer> listYear = new ArrayList<>();
        try {
            String sql = "select distinct YEAR(OrderDate) from Orders";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listYear.add(rs.getInt(1));
            }
        } catch (Exception e) {
        }
        return listYear;
    }

    public static void main(String[] args) {
        
    }

    public Order getOrderbyOrderID(int id) {
        Order o = null;
        try {
            String sql = "select * from Orders where OrderID = ?";
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID = rs.getInt("OrderID");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                Date OrederDate = rs.getDate("OrderDate");
                Date RequiredDate = rs.getDate("RequiredDate");
                Date ShippedDate = rs.getDate("ShippedDate");
                double Freight = rs.getDouble("Freight");
                String ShipName = rs.getString("ShipName");
                String ShipAddress = rs.getString("ShipAddress");
                String ShipCity = rs.getString("ShipCity");
                String ShipRegion = rs.getString("ShipRegion");
                String ShipPostalCode = rs.getString("ShipPostalCode");
                String ShipCountry = rs.getString("ShipCountry");
                o = new Order(OrderID, CustomerID, EmployeeID, OrederDate, RequiredDate, ShippedDate, Freight, ShipName, ShipAddress, ShipCity, ShipRegion, ShipPostalCode, ShipCountry);
            }
        } catch (Exception e) {
        }
        return o;
    }
}
