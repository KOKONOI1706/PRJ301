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


/**
 *
 * @author GIGABYTE
 */
public class DBUtils implements Serializable {

    private static final String DB_NAME = "SkillSwapHub";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "12345";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + DB_NAME;
        // jdbc:sqlserver://190.128.4.195\instanceName:1433;databaseName=unicodedemo;useUnicode=true&characterEncoding=UTF-8
        conn = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
        return conn;
    }
}
