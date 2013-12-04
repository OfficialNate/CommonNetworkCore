/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.api.hooks;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/**
 *
 * @author Goblom
 */
public abstract class ACommand implements CommandExecutor {
    
    public final String label, permNode;
    
    public ACommand(String commandLabel) {
        this(commandLabel, null);
    }
    
    public ACommand(String commandLabel, String permNode) {
        this.label = commandLabel;
        this.permNode = permNode;
        
        ((ICore) Bukkit.getPluginManager().getPlugin("Common Network Core")).registerCommand(label, this);
    }
    
    public boolean isPlayer(CommandSender sender) { return (sender instanceof Player); }
    public boolean isAuthorized(CommandSender sender, String permission) { return sender.hasPermission(permission); }
    public boolean isAuthorized(Player player, String permission) { return player.hasPermission(permission); }
    public boolean isAuthorized(CommandSender sender, Permission perm) { return sender.hasPermission(perm); }
    public boolean isAuthorized(Player player, Permission perm) { return player.hasPermission(perm); }
    
    @Override
    public abstract boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args);
    
    public abstract List<String> helpMessage();
//    public abstract String[] helpMessage();
}
