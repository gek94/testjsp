package com.gc.clients.db;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author george
 */
public class DbConnection {
    
    private com.mysql.jdbc.Connection jdbcConnection;
    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPassword;
    
    /**
     * 
     * @param jdbcURL
     * @param jdbcUsername
     * @param jdbcPassword 
     */
    public DbConnection(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
 
    /**
     * 
     * @throws SQLException 
     */
    public void conect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = (com.mysql.jdbc.Connection) DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    /**
     * 
     * @throws SQLException 
     */
    public void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
    /**
     * 
     * @return jdbcConnection
     */
    public com.mysql.jdbc.Connection getConnection() {
        return jdbcConnection;
    }
    
}
