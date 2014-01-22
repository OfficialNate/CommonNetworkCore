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
import org.goblom.cnc.core.database.DatabaseConnector;
import org.goblom.cnc.core.database.DatabaseType;

/**
 *
 * @author Goblom
 */
public class SQLite implements DatabaseConnector {

    @Override
    public DatabaseType getDatabaseType() {
        return DatabaseType.SQLITE;
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public int getPort() {
        return -1;
    }

    @Override
    public String getDatabaseName() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public File getSQLiteFile() {
        return new File(getPlugin().getDataFolder(), Core.getCoreConfiguration().getFileConfiguration().getString("Database.File"));
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
}
