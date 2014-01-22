/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.manager;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.database.Database;
import org.goblom.cnc.core.database.DatabaseManager;
import org.goblom.cnc.core.database.type.SQLDatabase;

/**
 *
 * @author Goblom
 */
public class CNDatabaseManager implements DatabaseManager {

    private final Map<String, Database> registered = new HashMap();
    
    public boolean registerDatabase(Plugin plugin, SQLDatabase sql) {
        if (!registered.containsKey(plugin.getName())) {
            registered.put(plugin.getName(), new Database(plugin, sql));
            return true;
        }
        return false;
    }

    public Database getDatabase(Plugin plugin) {
        Database db = null;
        for (String string : registered.keySet()) {
            if (plugin.getName().equals(string)) {
                db = registered.get(plugin.getName());
            }
        }
        return db;
    }
    
}
