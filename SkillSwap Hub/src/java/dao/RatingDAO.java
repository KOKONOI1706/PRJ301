/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;

/**
 *
 * @author GIGABYTE
 */
public class RatingDAO {

    public boolean addRating(int userId, int skillId, int ratingValue) {
        String sql = "INSERT INTO Ratings (user_id, skill_id, rating_value) VALUES (?, ?, ?)";

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, skillId);
            ps.setInt(3, ratingValue);
            return ps.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double getAverageRating(int skillId) {
        String sql = "SELECT AVG(rating_value) AS avgRating FROM Ratings WHERE skill_id = ?";
        double avgRating = 0.0;

        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, skillId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                avgRating = rs.getDouble("avgRating");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return avgRating;
    }
}
