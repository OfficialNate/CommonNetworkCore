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
public interface CommonNetwork {
    RankManager getRankManager();
    void registerCommand(String command, CoreCommandExecutor exe);
//    CommandMap getCommandMap();
    Network getNetwork();
    Logger getLogger();
    String getVersion();
    String getCoreName();
    Configuration getConfiguration();
    DatabaseManager getDatabaseManager();
    FeatureManager getFeatureManager();
}
