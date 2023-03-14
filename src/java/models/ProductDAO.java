/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsByCategoryID(int cateID) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public Product getProductsByProductID(int proID) {
        Product product = null;
        try {
            String sql = "select * from Products where productID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, proID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                product = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                return product;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Product> getProductsByProductName(String proName) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + proName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsByCategoryIDandProductName(int cateID, String proName) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where CategoryID = ? and ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ps.setString(2, "%" + proName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public static void main(String[] args) {
        System.out.println(new ProductDAO().getProductsByProductName("in"));
    }

    public ArrayList<Product> getProductsHot() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products order by UnitPrice asc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> getProductsBestSale() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select top 4 p.ProductID, p.CategoryID, p.ProductName, p.QuantityPerUnit, p.ReorderLevel, p.UnitPrice, p.UnitsInStock, p.UnitsOnOrder, p.Discontinued\n"
                        + "from Products p, [Order Details] od\n"
                        + "where p.ProductID = od.ProductID\n"
                        + "order by od.Discount desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }
    
    public ArrayList<Product> getProductsNew() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products order by ProductID desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public int getTotalProduct() {
        String sql = "select count(*) from Products";
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

    public int getTotalProductByCategoryID(int cateID) {
        String sql = "select count(*) from Products where CategoryID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalProductByProductName(String proName) {
        String sql = "select count(*) from Products where ProductName like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + proName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalProductByCategoryIDandProductName(int cateID, String proName) {
        String sql = "select count(*) from Products where CategoryID=? and ProductName like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ps.setString(2, "%" + proName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Product> pagingProduct(int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products\n"
                    + "order by ProductID\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> pagingProductByCategoryID(int cateID, int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where CategoryID=?\n"
                    + "order by ProductID\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> pagingProductByProductName(String proName, int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where ProductName like ?\n"
                    + "order by ProductID\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + proName + "%");
            ps.setInt(2, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public ArrayList<Product> pagingProductByCategoryIDandProductName(int cateID, String proName, int index) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products where CategoryID=? and ProductName like ?\n"
                    + "order by ProductID\n"
                    + "offset ? rows fetch next 5 rows only";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ps.setString(2, "%" + proName + "%");
            ps.setInt(3, (index - 1) * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String QuantityPerUnit = rs.getString("QuantityPerUnit");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                Product p = new Product(ProductID, ProductName, CategoryID, QuantityPerUnit, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued);
                products.add(p);
            }
        } catch (Exception e) {
        }
        return products;
    }

    public void editProduct(int ProductID, String ProductName, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, boolean Discontinued) {
        String sql = "update Products \n"
                + "set ProductName = ?,\n"
                + "CategoryID = ?,\n"
                + "QuantityPerUnit = ?,\n"
                + "UnitPrice = ?,\n"
                + "UnitsInStock = ?,\n"
                + "UnitsOnOrder = ?,\n"
                + "ReorderLevel = ?,\n"
                + "Discontinued = ?\n"
                + "where ProductID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ProductName);
            ps.setInt(2, CategoryID);
            ps.setString(3, QuantityPerUnit);
            ps.setDouble(4, UnitPrice);
            ps.setInt(5, UnitsInStock);
            ps.setInt(6, UnitsOnOrder);
            ps.setInt(7, ReorderLevel);
            ps.setBoolean(8, Discontinued);
            ps.setInt(9, ProductID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(int pid) {
        String sql1 = "delete from [Order Details]\n"
                + "where ProductID = ?";
        String sql2 = "delete from Products\n"
                + "where ProductID = ?";
        try {
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, pid);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setInt(1, pid);
            ps2.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void createProduct(String ProductName, int CategoryID, String QuantityPerUnit, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, boolean Discontinued) {
        String sql = "insert into Products values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ProductName);
            ps.setInt(2, CategoryID);
            ps.setString(3, QuantityPerUnit);
            ps.setDouble(4, UnitPrice);
            ps.setInt(5, UnitsInStock);
            ps.setInt(6, UnitsOnOrder);
            ps.setInt(7, ReorderLevel);
            ps.setBoolean(8, Discontinued);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
