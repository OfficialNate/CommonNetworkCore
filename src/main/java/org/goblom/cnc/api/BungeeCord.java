/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.api;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.Messenger;
import org.goblom.cnc.CNC;

/**
 *
 * @author Goblom
 */
public class BungeeCord {

    private static CNC plugin;

    public BungeeCord(CNC plugin) {
        this.plugin = plugin;
        
        Messenger messenger = Bukkit.getMessenger();
        if (!messenger.isOutgoingChannelRegistered(plugin, "BungeeCord")) {
            messenger.registerOutgoingPluginChannel(plugin, "BungeeCord");
        }
    }

    public static boolean connect(Player player, String server) {
        try {
            if (server.length() == 0) {
                plugin.getMessageManager().sendMessage(player, ChatColor.RED + "That server does not exist");
                return false;
            }

            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteArray);

            out.writeUTF("Connect");
            out.writeUTF(server);

            player.sendPluginMessage(plugin, "BungeeCord", byteArray.toByteArray());
        } catch (Exception e) { return false; }
        return true;
    }
    
    public static boolean send(String player, String server) {
        try {

            if (server.length() == 0) { return false; }

            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteArray);

            out.writeUTF("Connect");
            out.writeUTF(server);

            Bukkit.getOnlinePlayers()[0].sendPluginMessage(plugin, "BungeeCord", byteArray.toByteArray());
        } catch (Exception e) { return false; }
        return true;
    }
}
