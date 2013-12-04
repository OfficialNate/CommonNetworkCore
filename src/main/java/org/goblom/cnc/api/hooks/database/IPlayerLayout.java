/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.api.hooks.database;

/**
 *
 * @author Goblom
 */
public interface IPlayerLayout {
    public String getTable();
    public String[] getColumns();
    public String getRankColumn();
    public String getPlayerNameColumn();
    public String getMojangIDDatabase();
}
