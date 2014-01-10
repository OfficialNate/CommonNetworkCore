/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.api.hooks;

import org.bukkit.command.CommandExecutor;
import org.goblom.cnc.permissions.Ranks;

/**
 *
 * @author Goblom
 */
public interface ICore {
    public Ranks getRanksManager();
    public void registerCommand(String command, CommandExecutor exe);
}
