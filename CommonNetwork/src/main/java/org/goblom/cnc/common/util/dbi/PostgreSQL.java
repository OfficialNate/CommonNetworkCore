/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.util.dbi;

import java.io.File;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.database.DatabaseConnector;
import org.goblom.cnc.core.database.DatabaseType;

/**
 *
 * @author Goblom
 */
public class PostgreSQL implements DatabaseConnector {

    public DatabaseType getDatabaseType() {
        return DatabaseType.POSTGRESQL;
    }

    public String getHost() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Host");
    }

    public int getPort() {
        return Core.getCoreConfiguration().getFileConfiguration().getInt("Database.Host");
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
