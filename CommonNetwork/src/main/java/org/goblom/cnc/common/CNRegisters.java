/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common;

import org.goblom.cnc.common.features.PlayerLogger;
import org.goblom.cnc.common.features.PlayerUpdater;
import org.goblom.cnc.common.util.dbi.MySQL;
import org.goblom.cnc.common.util.dbi.PostgreSQL;
import org.goblom.cnc.common.util.dbi.SQLite;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.database.type.SQLDatabase;

/**
 *
 * @author Goblom
 */
public class CNRegisters {
    
    private final CNCore core;
    
    public CNRegisters(CNCore core) {
        this.core = core;
        
        init();
    }
    
    private void init() {
        setupDB();
        registerFeatures();
        enableFeatures();
    }
    
    private void setupDB() {
       String dbType = Core.getCoreConfiguration().getFileConfiguration().getString("Database.Type");
        switch (dbType.toLowerCase()) {
            case "mysql":
                Core.getDatabaseManager().registerDatabase(core, new SQLDatabase(core, new MySQL()));
                break;
            case "postgresql":
                Core.getDatabaseManager().registerDatabase(core, new SQLDatabase(core, new PostgreSQL()));
                break;
            case "sqlite":
                Core.getDatabaseManager().registerDatabase(core, new SQLDatabase(core, new SQLite()));
                break;
            default:
                Core.getCoreConfiguration().getFileConfiguration().set("Database.Type", "SQLite");
                Core.getCoreConfiguration().getFileConfiguration().set("Database.File", "core.db");
                Core.getCoreConfiguration().save();
                Core.getDatabaseManager().registerDatabase(core, new SQLDatabase(core, new SQLite()));
                break;
        }
    }
    
    private void registerFeatures() {
        Core.getFeatureManager().registerFeature(new PlayerLogger());
        Core.getFeatureManager().registerFeature(new PlayerUpdater());
    }
    
    private void enableFeatures() {
        for (String string : Core.getCoreConfiguration().getFileConfiguration().getConfigurationSection("Features").getKeys(false)) {
            boolean b = Core.getCoreConfiguration().getFileConfiguration().getBoolean("Features." + string);
            if (b) Core.getFeatureManager().enableFeature(string);
        }
    }
}
