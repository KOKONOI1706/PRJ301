/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.SwapRequestDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author GIGABYTE
 */
public class SwapRequestDAO {

    private static final Logger LOGGER = Logger.getLogger(SwapRequestDAO.class.getName());

    public boolean createSwapRequest(int senderId, int receiverId, int skillRequestedId, int skillOfferedId) {
        String sql = "INSERT INTO SwapRequest (sender_id, receiver_id, skill_requested_id, skill_offered_id, status, request_date) "
                + "VALUES (?, ?, ?, ?, 'Pending', GETDATE())";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, skillRequestedId);
            ps.setInt(4, skillOfferedId);

            return ps.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error creating swap request: {0}", ex.getMessage());
            return false;
        }
    }

    /**
     * Get all swap requests for a specific user (either sender or receiver)
     */
    public List<SwapRequestDTO> getSwapRequestsByUserId(int userId) {
        List<SwapRequestDTO> swapRequests = new ArrayList<>();
        String sql = "SELECT request_id, sender_id, receiver_id, skill_requested_id, skill_offered_id, status, request_date "
                + "FROM SwapRequest WHERE sender_id = ? OR receiver_id = ? ORDER BY request_date DESC";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                swapRequests.add(new SwapRequestDTO(
                        rs.getInt("request_id"),
                        rs.getInt("sender_id"),
                        rs.getInt("receiver_id"),
                        rs.getInt("skill_requested_id"),
                        rs.getInt("skill_offered_id"),
                        rs.getString("status"),
                        rs.getTimestamp("request_date")
                ));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error fetching swap requests: {0}", ex.getMessage());
        }
        return swapRequests;
    }

    /**
     * Update swap request status (Accept/Reject)
     */
    public boolean updateSwapRequestStatus(int requestId, String status) {
        String sql = "UPDATE SwapRequest SET status = ? WHERE request_id = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, requestId);

            return ps.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error updating swap request status: {0}", ex.getMessage());
            return false;
        }
    }

    /**
     * Delete a swap request (Cancel request)
     */
    public boolean deleteSwapRequest(int requestId) {
        String sql = "DELETE FROM SwapRequest WHERE request_id = ?";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, requestId);
            return ps.executeUpdate() > 0;

        } catch (ClassNotFoundException | SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error deleting swap request: {0}", ex.getMessage());
            return false;
        }
    }

    public boolean acceptSwapRequest(int requestId, int senderId) {
        String sqlUpdate = "UPDATE SwapRequest SET status = 'Accepted' WHERE request_id = ?";
        String sqlNotify = "INSERT INTO Notifications (user_id, message, is_read) VALUES (?, ?, 0)";

        try (Connection conn = DBUtils.getConnection();
                PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate);
                PreparedStatement psNotify = conn.prepareStatement(sqlNotify)) {

            // ✅ Update the swap request status to "Accepted"
            psUpdate.setInt(1, requestId);
            int rowsAffected = psUpdate.executeUpdate();

            if (rowsAffected > 0) {
                // ✅ Insert a notification for the sender
                psNotify.setInt(1, senderId);
                psNotify.setString(2, "Your swap request was accepted! Contact the user now.");
                psNotify.executeUpdate();

                return true;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
