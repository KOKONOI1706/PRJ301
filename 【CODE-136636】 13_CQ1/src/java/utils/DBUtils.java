/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIGABYTE
 */
public class DBUtils implements Serializable {

    private static final String DB_NAME = "Student";
    private static final String DB_USER_NAME = "sa";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
        return conn;
    }

    public static void main(String[] args) {
        try {
            
            Connection c = getConnection();

            String sql = "USE master;"
                    + "GO"
                    + "CREATE DATABASE " + DB_NAME + ";"
                    + "COLLATE SQL_Latin1_General_CP1254_CI_AS;"
                    + "USE " + DB_NAME + ";"
                    + "GO"
                    + "IF EXIST (SELECT * FROM sys.tables WHERE name = '" + DB_NAME + "')"
                    + "Begin"
                    + " DROP TABLE " + DB_NAME + ";"
                    + "END"
                    + "GO"
                    + "CREATE TABLE" + DB_NAME + "("
                    + "IDStudent INT KEY AUTO_INCREMENT,"
                    + "FullName VARCHAR(100) NOT NULL,"
                    + "Gender ENUM('Male', 'Female') NOT NULL"
                    + ");";

            Statement st = c.createStatement();
            int result = st.executeUpdate(sql);
            System.out.println(result);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}



















