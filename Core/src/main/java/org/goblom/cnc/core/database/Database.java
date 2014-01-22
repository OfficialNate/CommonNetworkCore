/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.core.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.database.type.SQLDatabase;

/**
 *
 * @author Goblom
 */
public class Database {

    private final SQLDatabase db;
    private final String pluginName;

    public Database(Plugin plugin, SQLDatabase sqlDatabase) {
        this.db = sqlDatabase;
        this.pluginName = plugin.getName();
    }

    private SQLDatabase getDatabase() {
        return db;
    }

    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin(pluginName);
    }

    private void log(String sqlStatement, Exception ex) {
        getPlugin().getLogger().warning("[CNC Error] ==========================");
        getPlugin().getLogger().warning("[CNC Error] === Database Exception ===");
        getPlugin().getLogger().warning("[CNC Error] ==========================");
        getPlugin().getLogger().warning("[CNC Error] SQL Statement Executed");
        getPlugin().getLogger().warning("[CNC Error] ---> " + sqlStatement);
        getPlugin().getLogger().warning("[CNC Error] ==========================");
        getPlugin().getLogger().warning("[CNC Error] StackTrace");
        ex.printStackTrace();
        getPlugin().getLogger().warning("[CNC Error] ==========================");
    }

    public ResultSet query(String sql) {
        ThreadedQuery query = new ThreadedQuery(sql);
        query.start();
        return query.getResult();
    }

    public String queryString(String sql) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return null;
            }
            if (rs.isAfterLast()) {
                return null;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getString(1);
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
    }

    public String queryString(String sql, String column) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return null;
            }
            if (rs.isAfterLast()) {
                return null;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getString(column);
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
    }

    public Integer queryInteger(String sql) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getInt(1);
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
    }

    public Integer queryInteger(String sql, String column) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getInt(column);
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
    }

    public long queryLong(String sql) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getLong(1);
        } catch (SQLException ex) {
            log(sql, ex);
            return -1;
        }
    }

    public long queryLong(String sql, String column) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getLong(column);
        } catch (SQLException ex) {
            log(sql, ex);
            return -1;
        }
    }

    public float queryFloat(String sql) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getFloat(1);
        } catch (SQLException ex) {
            log(sql, ex);
            return -1;
        }
    }

    public float queryFloat(String sql, String column) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getFloat(column);
        } catch (SQLException ex) {
            log(sql, ex);
            return -1;
        }
    }

    public double queryDouble(String sql) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getDouble(1);
        } catch (SQLException ex) {
            log(sql, ex);
            return -1;
        }
    }

    public double queryDouble(String sql, String column) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            if (rs.isAfterLast()) {
                return -1;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getDouble(column);
        } catch (SQLException ex) {
            log(sql, ex);
            return -1;
        }
    }

    public boolean queryBoolean(String sql) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return false;
            }
            if (rs.isAfterLast()) {
                return false;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getBoolean(1);
        } catch (SQLException ex) {
            log(sql, ex);
            return false;
        }
    }

    public boolean queryBoolean(String sql, String column) {
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return false;
            }
            if (rs.isAfterLast()) {
                return false;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getBoolean(column);
        } catch (SQLException ex) {
            log(sql, ex);
            return false;
        }
    }

    public boolean update(String sql) {
        try {
            Connection conn = db.connect();
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            log(sql, ex);
            return false;
        }
    }

    public boolean doesTableContain(String table, String column, String value) {
        String sql = "SELECT COUNT(" + column + ") AS " + column + "Count FROM " + table + " WHERE " + column + "='" + value + "'";
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return false;
            }
            if (rs.isAfterLast()) {
                return false;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getInt(1) != 0;
        } catch (SQLException ex) {
            log(sql, ex);
            return false;
        }
    }

    public boolean doesTableContain(String table, String c1, String v1, String c2, String v2) {
        String sql = "SELECT COUNT(" + c1 + ") AS " + c1 + "Count FROM " + table + " WHERE " + c1 + "='" + v1 + "' AND " + c2 + "='" + v2 + "'";
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return false;
            }
            if (rs.isAfterLast()) {
                return false;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return rs.getInt(1) != 0;
        } catch (SQLException ex) {
            log(sql, ex);
            return false;
        }
    }

    public boolean doesTableContain(String table, String c1, String v1, String c2, String v2, String c3, String v3) {
        String sql = "SELECT COUNT(" + c1 + ") AS " + c1 + "Count FROM " + table + " WHERE " + c1 + "='" + v1 + "' AND " + c2 + "='" + v2 + "' AND " + c3 + "='" + v3 + "'";
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return false;
            }
            if (rs.isAfterLast()) {
                return false;
            }
            if (rs.isBeforeFirst()) {
                rs.next();
            }
            return (rs.getInt(1) != 0);
        } catch (SQLException ex) {
            log(sql, ex);
            return false;
        }
    }

    public List<String> queryStringList(String sql) {
        List<String> list = new ArrayList();
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
        return list;
    }

    public List<String> queryStringList(String sql, String column) {
        List<String> list = new ArrayList();
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                list.add(rs.getString(column));
            }
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
        return list;
    }

    public Integer getRowsInTable(String table) {
        String sql = "SELECT COUNT(*) FROM '" + table + "';";
        try {
            ResultSet rs = query(sql);
            if (rs == null) {
                return -1;
            }
            return rs.getInt("Count(*)");
        } catch (SQLException ex) {
            log(sql, ex);
            return null;
        }
    }

    public boolean createTable(String tableName, String columns) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + "(" + columns + ");";
        try {
            Connection conn = db.connect();
            Statement state = conn.createStatement();
            state.executeUpdate(sql);
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            log(sql, ex);
            return false;
        }
    }
    
    private class ThreadedQuery extends Thread {
        private ResultSet rs = null;
        private final String sql;
        
        private ThreadedQuery(String sql) {
            this.sql = sql;
        }
        
        @Override
        public void run() {
            try (Connection conn = db.connect()) {
                Statement state = conn.createStatement();
                this.rs = state.executeQuery(sql);
                if (rs == null) {
                    return;
                }
                if (rs.isAfterLast()) {
                    return;
                }
                if (rs.isBeforeFirst()) {
                    rs.next();
                }
                state.close();
                conn.close();
            } catch (ClassNotFoundException | SQLException ex) {
                log(sql, ex);
            }
        }
        
        public ResultSet getResult() {
            return rs;
        }
    }
}