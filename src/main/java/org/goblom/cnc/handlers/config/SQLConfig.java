/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.handlers.config;

/**
 *
 * @author Goblom
 */
public class SQLConfig {
    private final String host;
    private final int port;
    private final String dbName;
    private final String username;
    private final String password;
    
    public SQLConfig(String host, int port, String dbName, String username, String password) {
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }
    
    public String getHost() {
        return host;
    }
    
    public int getPort() {
        return port;
    }
    
    public String getDatabase() {
        return dbName;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}
