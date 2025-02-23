/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author GIGABYTE
 */
public class BookDAO implements IDAO<BookDTO, String>{

    @Override
    public boolean create(BookDTO entity) {
        return true;
    }

    @Override
    public List<BookDTO> readAll() {
        return null;
    }

    @Override
    public BookDTO readById(String id) {
        return null;
    }

    @Override
    public boolean update(BookDTO entity) {
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<BookDTO> search(String searchTerm) {
        return null;
    }
    
    public List<BookDTO> searchByID(String searchTerm) {
        List<BookDTO> result = new ArrayList<>();
        String sql = "SELECT * FROM tblBooks WHERE title like ?";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+searchTerm+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BookDTO b = new BookDTO(
                        rs.getString("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getInt("PublishYear"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity")
                );
                result.add(b);
                        
            }
            
        } catch (Exception e) {
        }
        return result;
    }
    
}
