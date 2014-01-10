/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.handlers.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.goblom.cnc.handlers.config.SQLConfig;

/**
 *
 * @author Goblom
 */
public class ConnectSQL {
    private final Connection connection;
    private final SQLConfig config;
    
    public ConnectSQL(SQLConfig config) throws ClassNotFoundException, SQLException {
        this.config = config;
        
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + config.getHost() + ":" + config.getPort() + "/" + config.getDatabase() + "?autoReconnect=true", config.getUsername(), config.getPassword());
    }
    
    public SQLConfig getSQLConfig() {
        return config;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public boolean isConnected() {
        return (getConnection() != null);
    }
    
    public void close() {
        try {
            getConnection().close();
        } catch (SQLException ex) {
            System.out.println("Couldn't close connection");
        }
    }
    
    public ResultSet execute(String sql) { return execute(sql, true); }
    public int update(String sql) { return update(sql, true); }
    
    public ResultSet execute(String sql, boolean keepOpen) {
        ResultSet rs = null;
        try {
            Statement s = getConnection().createStatement();
            rs = s.executeQuery(sql);
            if (keepOpen) s.close();
        } catch (SQLException e) { e.printStackTrace(); }
        return rs;
    }
    
    public int update(String sql, boolean keepOpen) {
        int u = 0;
        try {
            Statement s = getConnection().createStatement();
            u = s.executeUpdate(sql);
            if (keepOpen) s.close();
        } catch (SQLException e) { e.printStackTrace(); }
        return u;
    }
    
    public boolean createTable(String table, String... columns) {
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS " + table + " (");
        for (int i = 0; i < columns.length; i++) {
            if (i == (columns.length - 1)) sql.append(columns[i]);
            else sql.append(columns[i] + ", ");
        }
        sql.append(");");
        
        try { // update(sql.toString(), false);
            Statement s = getConnection().createStatement();
            s.executeUpdate(sql.toString());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void dropTable(String table) {
        update("DROP TABLE IF EXISTS " + table, false);
    }
    
    public Object get(DataTypes type, ResultSet rs, String column) {
        try {
            switch (type) {
                case ARRAY:
                    return rs.getArray(column);
                case BIGDECIMAL:
                    return rs.getBigDecimal(column);
                case BLOB:
                    return rs.getBlob(column);
                case BOOLEAN:
                    return rs.getBoolean(column);
                case BYTE:
                    return rs.getByte(column);
                case BYTES:
                    return rs.getBytes(column);
                case DATE:
                    return rs.getDate(column);
                case CLOB:
                    return rs.getClob(column);
                case DOUBLE:
                    return rs.getDouble(column);
                case FLOAT:
                    return rs.getFloat(column);
                case INTEGER:
                    return rs.getInt(column);
                case LONG:
                    return rs.getLong(column);
                case OBJECT:
                    return rs.getObject(column);
                case SHORT:
                    return rs.getShort(column);
                case STRING:
                    return rs.getString(column);
                case TIMESTAMP:
                    return rs.getTimestamp(column);
                case TIME:
                    return rs.getTime(column);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return null;
    }
    
    public Object getData(ResultSet result, String column) {
        try {
            if (!result.isClosed()) {
                if (result.next()) {
                    Object obj = result.getObject(column);
                    result.close();
                    return obj;
                }
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        return null;
    }
    
    public enum DataTypes {
        ARRAY, BIGDECIMAL, BLOB, BOOLEAN, BYTE, BYTES,
        DATE, CLOB, DOUBLE, FLOAT, INTEGER, LONG, OBJECT,
        SHORT, STRING, TIMESTAMP, TIME;
    }
}
