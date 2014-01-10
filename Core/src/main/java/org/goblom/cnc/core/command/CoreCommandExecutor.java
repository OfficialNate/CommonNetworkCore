/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public interface CoreCommandExecutor extends CommandExecutor {
    public String getAlias();
    public String getDescription();
    public String getUsage();
    public String getPermission();
    public String getNotAllowedMessage();
    public boolean onCommand(CommandSender sender, CoreCommand command, String label, String[] args);    
}
