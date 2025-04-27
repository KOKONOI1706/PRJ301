/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.SkillDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIGABYTE
 */
public class SkillDAO {

    public List<SkillDTO> searchBySkillNameAndCategory(String skill_name, String category) {
        List<SkillDTO> list = new ArrayList<>();
        String sql = "Select * from Skills where skill_name Like ? And category Like ?";
        try {
            Connection conn = utils.DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + skill_name + "%");
            ps.setString(2, "%" + category + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SkillDTO sdto = new SkillDTO(rs.getInt("skill_id"),
                        rs.getString("skill_name"),
                        rs.getString("category"));
                list.add(sdto);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SkillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SkillDTO> getAllSkillsWithUserCount(String skill_name, String category) {
        List<SkillDTO> list = new ArrayList<>();
        String sql = "SELECT s.skill_id, s.skill_name, s.category, "
                + "COUNT(us.user_id) AS user_count "
                + "FROM Skills s "
                + "LEFT JOIN UserSkills us ON s.skill_id = us.skill_id "
                + "Where s.skill_name Like ? and  s.category Like ? "
                + "GROUP BY s.skill_id, s.skill_name, s.category";
        try {
            Connection conn = utils.DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + skill_name + "%");
            ps.setString(2, "%" + category + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SkillDTO sdto = new SkillDTO(rs.getInt("skill_id"),
                        rs.getString("skill_name"),
                        rs.getString("category"),
                        rs.getInt("user_count"));
                list.add(sdto);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SkillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public SkillDTO getSkillById(int skillId) {
        SkillDTO skill = null;
        String sql = "SELECT skill_id, skill_name, category FROM Skills WHERE skill_id = ?";

        try (Connection conn = utils.DBUtils.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, skillId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                skill = new SkillDTO(
                        rs.getInt("skill_id"),
                        rs.getString("skill_name"),
                        rs.getString("category")
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SkillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return skill;
    }

    public List<SkillDTO> getAllSkills() {
        List<SkillDTO> list = new ArrayList<>();
        String sql = "Select * from Skills";
        try {
            Connection conn = utils.DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SkillDTO sdto = new SkillDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list.add(sdto);
            }
            return list;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SkillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SkillDTO> getSkillsByUserId(int user_id) {
        List<SkillDTO> list = new ArrayList<>();
        String sql = "SELECT s.skill_id, s.skill_name, s.category "
                + "FROM skills s "
                + "JOIN UserSkills us ON s.skill_id = us.skill_id "
                + "WHERE us.user_id = ?";
        try {
            Connection conn = utils.DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SkillDTO sdto = new SkillDTO(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list.add(sdto);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SkillDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        SkillDAO sdao = new SkillDAO();
        List<SkillDTO> list = sdao.getAllSkills();
        System.out.println(list);
    }
}
