/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.command.database;

/**
 *
 * @author Goblom
 */
public enum DatabaseType {

        MYSQL("com.mysql.jdbc.Driver", "jdbc:mysql://"),
        SQLITE("org.sqlite.JDBC", "jdbc:sqlite:"),
        POSTGRESQL("org.postgresql.Driver", "jdbc:postgresql://");
        
        private final String url, clazz;

        DatabaseType(String clazz, String url) {
            this.clazz = clazz;
            this.url = url;
        }

        public String getURL() {
            return url;
        }

        public String getClazz() {
            return clazz;
        }
    }
