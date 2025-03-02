/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author GIGABYTE
 */
public class UserDAO implements IDAO<UserDTO, String> {

    @Override
    public boolean create(UserDTO entity) {
        return false;
    }

    @Override
    public List<UserDTO> readAll() {
        return null;
    }

    @Override
    public UserDTO readById(String id) {
        String sql = "SELECT * FROM [Users] WHERE [UserID] = ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UserDTO(
                        rs.getString("UserID"),
                        rs.getString("FullName"),
                        rs.getInt("Phone"),
                        rs.getString("Password"),
                        rs.getString("Email"),
                        rs.getString("Role"));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(UserDTO entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<UserDTO> search(String searchTerm) {
        return null;
    }

}
