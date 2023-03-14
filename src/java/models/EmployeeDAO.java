/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import dal.DBContext;
import dal.Employee;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author msi
 */
public class EmployeeDAO extends DBContext {

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "select * from Employees";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int EmployeeID = rs.getInt("EmployeeID");
                String LastName = rs.getString("LastName");
                String FirstName = rs.getString("FirstName");
                int DepartmentID = rs.getInt("DepartmentID");
                String Title = rs.getString("Title");
                String TitleOfCourtesy = rs.getString("TitleOfCourtesy");
                Date BirthDate = rs.getDate("BirthDate");
                Date HireDate= rs.getDate("HireDate");
                String Address = rs.getString("Address");
                Employee e = new Employee(EmployeeID, LastName, FirstName, DepartmentID, Title, TitleOfCourtesy, BirthDate, HireDate, Address);
                employees.add(e);
            }
        } catch (Exception e) {
        }
        return employees;
    }
    
    public Employee getEmployeeByOrder(int id) {
        Employee employee = null;
        try {
            String sql = "select * from Employees where EmployeeID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int EmployeeID = rs.getInt("EmployeeID");
                String LastName = rs.getString("LastName");
                String FirstName = rs.getString("FirstName");
                int DepartmentID = rs.getInt("DepartmentID");
                String Title = rs.getString("Title");
                String TitleOfCourtesy = rs.getString("TitleOfCourtesy");
                Date BirthDate = rs.getDate("BirthDate");
                Date HireDate= rs.getDate("HireDate");
                String Address = rs.getString("Address");
                employee = new Employee(EmployeeID, LastName, FirstName, DepartmentID, Title, TitleOfCourtesy, BirthDate, HireDate, Address);
                return employee;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
