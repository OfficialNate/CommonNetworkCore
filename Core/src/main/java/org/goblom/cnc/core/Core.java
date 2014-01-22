/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core;

import java.util.logging.Logger;
import org.goblom.cnc.core.command.CoreCommandExecutor;
import org.goblom.cnc.core.database.DatabaseManager;
import org.goblom.cnc.core.features.FeatureManager;
import org.goblom.cnc.core.network.Network;
import org.goblom.cnc.core.permissions.RankManager;

/**
 *
 * @author Goblom
 */
public class Core {
    private static CommonNetwork cn;
    
    public static RankManager getRankManager() {
        return cn.getRankManager();
    }
    
    public static void registerCommand(String command, CoreCommandExecutor exe) {
        cn.registerCommand(command, exe);
    }
    
//    public static CommandMap getCommandMap() {
//        return cn.getCommandMap();
//    }
    
    public static Network getNetwork() {
        return cn.getNetwork();
    }
    
    public static void setCore(CommonNetwork cn) {
        if (Core.cn != null) {
            throw new UnsupportedOperationException("Cannot redefine singleton CommonNetwork");
        }
        Core.cn = cn;
        
        cn.getLogger().info("This server is running " + getName() + " version " + getVersion());
    }
    
    public static String getName() {
        return cn.getCoreName();
    }
    
    public static String getVersion() {
        return cn.getVersion();
    }
    
    public static Logger getLogger() {
        return cn.getLogger();
    }
    
    public static DatabaseManager getDatabaseManager() {
        return cn.getDatabaseManager();
    }
    
    public static FeatureManager getFeatureManager() {
        return cn.getFeatureManager();
    }
    
    public static Configuration getCoreConfiguration() {
        return cn.getConfiguration();
    }
}
