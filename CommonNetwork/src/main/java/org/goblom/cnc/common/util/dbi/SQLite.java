/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.util.dbi;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.command.database.DatabaseConnector;
import org.goblom.cnc.core.command.database.DatabaseType;

/**
 *
 * @author Goblom
 */
public class SQLite implements DatabaseConnector {

    public DatabaseType getDatabaseType() {
        return DatabaseType.SQLITE;
    }

    public String getHost() {
        return null;
    }

    public int getPort() {
        return -1;
    }

    public String getDatabaseName() {
        return null;
    }

    public String getUsername() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public File getSQLiteFile() {
        return new File(getPlugin().getDataFolder(), Core.getCoreConfiguration().getFileConfiguration().getString("Database.File"));
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
}
