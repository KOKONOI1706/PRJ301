/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import utils.DBUtils;
import java.sql.*;

public class StudentDAO {
    // INSERT operation
    public void insertStudent(String fullName, String gender) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Student (FullName, Gender) VALUES (?, ?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fullName);
            stmt.setString(2, gender);
            stmt.executeUpdate();
        }
    }

    // UPDATE operation
    public void updateStudent(int id, String fullName, String gender) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Student SET FullName = ?, Gender = ? WHERE IDStudent = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fullName);
            stmt.setString(2, gender);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }
    }

    // DELETE operation
    public void deleteStudent(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Student WHERE IDStudent = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // SELECT operation (optional: for testing or listing students)
    public void getAllStudents() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Student";
        try (Connection conn = DBUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("IDStudent"));
                System.out.println("FullName: " + rs.getString("FullName"));
                System.out.println("Gender: " + rs.getString("Gender"));
                System.out.println("-------------------------");
            }
        }
    }
}
