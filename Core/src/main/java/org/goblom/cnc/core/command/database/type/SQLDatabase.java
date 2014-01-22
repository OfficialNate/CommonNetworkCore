/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.core.command.database.type;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.command.database.DatabaseConnector;
import org.goblom.cnc.core.command.database.DatabaseType;

/**
 *
 * @author Goblom
 */
public class SQLDatabase {

    private final String pluginName;
    private final DatabaseConnector dbConnector;

    public SQLDatabase(Plugin plugin, DatabaseConnector dbConnector) {
        this.pluginName = plugin.getName();
        this.dbConnector = dbConnector;
    }

    public DatabaseConnector getDatabaseConnector() {
        return dbConnector;
    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName(getDatabaseConnector().getDatabaseType().getClazz());
        switch (getDatabaseConnector().getDatabaseType()) {
            case MYSQL:
                conn = DriverManager.getConnection(
                        getURL(DatabaseType.MYSQL) + getDatabaseConnector().getHost() + ":" + getDatabaseConnector().getPort() + "/" + getDatabaseConnector().getDatabaseName(),
                        getDatabaseConnector().getUsername(),
                        getDatabaseConnector().getPassword());
                break;
            case SQLITE:
                if (!getDatabaseConnector().getSQLiteFile().exists()) {
                    try {
                        getDatabaseConnector().getSQLiteFile().createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                        getPlugin().getLogger().severe("Could not create SQLite Database File!!!");
                    }
                }
                conn = DriverManager.getConnection(getURL(DatabaseType.SQLITE) + getDatabaseConnector().getSQLiteFile());
                break;
            case POSTGRESQL:
                conn = DriverManager.getConnection(
                        getURL(DatabaseType.POSTGRESQL) + getDatabaseConnector().getHost() + ":" + getDatabaseConnector().getPort() + "/" + getDatabaseConnector().getDatabaseName(),
                        getDatabaseConnector().getUsername(),
                        getDatabaseConnector().getPassword());
                break;
        }
        return conn;
    }

    public Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin(pluginName);
    }

    private String getURL(DatabaseType type) {
        return type.getURL();
    }
}
