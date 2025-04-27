/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.NotificationDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GIGABYTE
 */
public class NotificationDAO {

    public List<NotificationDTO> getNotificationsByUserId(int userId) {
        List<NotificationDTO> notifications = new ArrayList<>();
        String sql = "SELECT notification_id, message, is_read, created_at FROM Notifications WHERE user_id = ? ORDER BY created_at DESC";

        try (Connection conn = utils.DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                notifications.add(new NotificationDTO(
                        rs.getInt("notification_id"),
                        userId,
                        rs.getString("message"),
                        rs.getBoolean("is_read"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notifications;
    }
}
