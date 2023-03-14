/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.Category;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class CategoryDAO extends DBContext {

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            String sql = "select * from Categories";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");
                String Picture = rs.getString("Picture");
                Category c = new Category(CategoryID, CategoryName, Description, Picture);
                categories.add(c);
            }
        } catch (SQLException e) {
        }
        return categories;
    }
    
    public Category getCategoryByID(int cateID) {
        Category category = null;
        try {
            String sql = "select * from Categories where CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cateID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");
                String Picture = rs.getString("Picture");
                category = new Category(CategoryID, CategoryName, Description, Picture);
            }
        } catch (SQLException e) {
        }
        return category;
    }
    
    public static void main(String[] args) {
        ArrayList<Category> list = new CategoryDAO().getCategories();
        for (Category category : list) {
            System.out.println(category);
        }
    }
}
