
package com.riwi.academia.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/academia";
    private static final String USER = "yiss";
    private static final String PASS = "yiss123";
    
public static Connection getConexion() throws SQLException{
    return DriverManager.getConnection(URL, USER, PASS);
}
}