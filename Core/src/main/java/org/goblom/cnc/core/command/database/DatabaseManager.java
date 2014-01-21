/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.command.database;

import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.command.database.type.SQLDatabase;

/**
 *
 * @author Goblom
 */
public interface DatabaseManager {
    boolean registerDatabase(Plugin plugin, SQLDatabase sql);
    Database getDatabase(Plugin plugin);
}
