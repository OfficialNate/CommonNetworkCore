/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core;

import org.bukkit.command.CommandMap;
import org.goblom.cnc.core.command.CoreCommandExecutor;
import org.goblom.cnc.core.permissions.RankManager;

/**
 *
 * @author Goblom
 */
public interface Core {
    public RankManager getRankManager();
    public void registerCommand(String command, CoreCommandExecutor exe);
    public CommandMap getCommandMap();
}
