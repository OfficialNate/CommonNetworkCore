/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common;

import org.bukkit.ChatColor;

/**
 *
 * @author Goblom
 */
public enum Message {
    PREFIX(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "CNC" + ChatColor.DARK_GRAY + "]" + ChatColor.RESET),
    TARGET_SERVER_NOT_EXIST(ChatColor.RED + "Target server does not exist");
    private final String message;
    Message(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public static String getMessage(Message message) {
        return message.getMessage();
    }
}
