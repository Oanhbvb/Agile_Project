/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Customer;
import java.sql.*;

/**
 *
 * @author Hieucode
 */
public class DangNhapRepository {
    public Customer loginCustomer(String username, String password) {
        Customer cus = new Customer();
        String sql = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PASSWORD_USER = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setObject(1, username);
                ps.setObject(2, password);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cus.setUsername(rs.getString("USERNAME"));
                    cus.setPassword(rs.getString("PASSWORD_USER"));
                    return cus;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
