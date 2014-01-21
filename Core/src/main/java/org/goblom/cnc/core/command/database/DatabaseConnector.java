/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.command.database;

import java.io.File;

/**
 *
 * @author Goblom
 */
public interface DatabaseConnector {
    DatabaseType getDatabaseType();
    String getHost();
    int getPort();
    String getDatabaseName();
    String getUsername();
    String getPassword();
    File getSQLiteFile();
}
