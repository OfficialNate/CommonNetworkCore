/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.handlers.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.goblom.cnc.api.hooks.database.IPlayerLayout;

/**
 *
 * @author Goblom
 */
public class PlayerData {
    
    private final IPlayerLayout db;
    private final ConnectSQL sql;
    
    public PlayerData(ConnectSQL sql, IPlayerLayout db) {
        this.sql = sql;
        this.db = db;
    }
    
    public ConnectSQL getSQL() {
        return sql;
    }
    
    public IPlayerLayout getLayout() {
        return db;
    }
    
    public ResultSet getData(String playerName) {
        return getSQL().execute("SELECT * FROM " + getLayout().getTable() + " WHERE " + getLayout().getPlayerNameColumn() + "='" + playerName + "'");
    }
    
    public boolean doesExists(String playerName) {
        ResultSet rs = getData(playerName);
        try {
            boolean exists = rs.next();
            rs.close();
            return exists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
