/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.util.dbi;

import java.io.File;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.command.database.DatabaseConnector;
import org.goblom.cnc.core.command.database.DatabaseType;

/**
 *
 * @author Goblom
 */
public class MySQL implements DatabaseConnector {

    public DatabaseType getDatabaseType() {
        return DatabaseType.MYSQL;
    }

    public String getHost() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Host");
    }

    public int getPort() {
        return Core.getCoreConfiguration().getFileConfiguration().getInt("Database.Port");
    }

    public String getDatabaseName() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Name");
    }

    public String getUsername() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Username");
    }

    public String getPassword() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Password");
    }

    public File getSQLiteFile() {
        return null;
    }
    
}
