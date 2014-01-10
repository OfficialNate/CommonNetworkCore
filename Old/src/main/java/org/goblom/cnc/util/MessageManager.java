/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.goblom.cnc.CNC;

/**
 *
 * @author Goblom
 */
public class MessageManager {
    
    private final CNC plugin;
    
    public MessageManager(CNC plugin) {
        this.plugin = plugin;
    }
    
    public String get(String message) {
        return Messages.valueOf(message.toUpperCase()).getMessage();
    }
    
    public void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(get("prefix") + message);
    }
    
    public void sendMessage(Player player, String message) {
        player.sendMessage(get("prefix") + message);
    }
    
    private enum Messages {
        PREFIX(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GRAY + "CNC" + ChatColor.DARK_GRAY + "]");
        
        private final String message;
        private Messages(String message) { this.message = message; }
        public String getMessage() { return message + ChatColor.RESET + " "; }
    }
}
