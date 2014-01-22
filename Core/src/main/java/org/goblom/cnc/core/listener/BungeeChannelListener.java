/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.listener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.goblom.cnc.core.Core;

/**
 *
 * @author Goblom
 */
public class BungeeChannelListener implements PluginMessageListener {
    
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) return;
        
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(message));
        try {
            String subChannel = in.readUTF();
            switch (subChannel) {
                case "Forward": break;
                case "IP": break;
                case "PlayerCount": break; 
                case "PlayerList": break;
                case "GetServers": break; 
                case "GetServer": break; 
                case "BungeePI": break;
                case "Connect": break;
                case "ConnectOther": break;
                case "Message": break;
                case "CommonNetworkCore": break;
                default: break;
            }
        } catch (IOException ex) {
            Core.getLogger().warning("Unable to read incoming Bungee Plugin Message.");
        }
    }
}