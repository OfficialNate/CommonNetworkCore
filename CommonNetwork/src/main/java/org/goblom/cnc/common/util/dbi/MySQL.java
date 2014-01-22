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
public class MySQL implements DatabaseConnector {

    @Override
    public DatabaseType getDatabaseType() {
        return DatabaseType.MYSQL;
    }

    @Override
    public String getHost() {
        return Core.getCoreConfiguration().getFileConfiguration().getString("Database.Host");
    }

    @Override
    public int getPort() {
        return Core.getCoreConfiguration().getFileConfiguration().getInt("Database.Port");
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
