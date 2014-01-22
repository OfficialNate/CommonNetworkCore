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

    @Override
    public DatabaseType getDatabaseType() {
        return DatabaseType.POSTGRESQL;
    }

    @Override
    public String getHost() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Host");
    }

    @Override
    public int getPort() {
        return Core.getCoreConfiguration().getFileConfiguration().getInt("Database.Host");
    }

    @Override
    public String getDatabaseName() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Name");
    }

    @Override
    public String getUsername() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Username");
    }

    @Override
    public String getPassword() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Password");
    }

    @Override
    public File getSQLiteFile() {
        return null;
    }
    
}
