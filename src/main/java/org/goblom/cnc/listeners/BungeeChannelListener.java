/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.listeners;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.goblom.cnc.CNC;
import org.goblom.cnc.api.events.BungeeCordForwardEvent;

/**
 *
 * @author Goblom
 */
public class BungeeChannelListener implements PluginMessageListener {

    private final CNC plugin;
    
    public BungeeChannelListener(CNC plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;
        
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        try {
            String subChannel = in.readUTF();
            switch (subChannel) {
                case "Forward":
                    BungeeCordForwardEvent brf = new BungeeCordForwardEvent(in.readUTF(), in);
                    Bukkit.getServer().getPluginManager().callEvent(brf);
                    break;
                case "IP": break;
                case "PlayerCount": break; 
                case "PlayerList": break;
                case "GetServers": break; 
                case "GetServer": break; 
                case "BungeePI": break;
                case "Connect": break;
                case "ConnectOther": break;
                case "Message": break;
                default:
                    break;
            }
        } catch (IOException ex) {
            plugin.getLogger().warning("Unable to read incoming Bungee Plugin Message.");
        }
    }
}
