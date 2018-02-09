package com.gc.clients.db;

import java.sql.SQLException;

/**
 *
 * @author george
 */
public class Connection {

    protected final DbConnection db;
    protected final StringBuilder sql;
    protected String message;

    public Connection(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        this.db = new DbConnection(jdbcURL, jdbcUsername, jdbcPassword);
        this.sql = new StringBuilder();
        db.conect();
    }
        
}
