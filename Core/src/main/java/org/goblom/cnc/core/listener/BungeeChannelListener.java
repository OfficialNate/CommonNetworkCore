/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.listener;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.events.network.BungeeRecieveEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecieveCNCEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecieveForwardEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecieveGetServerEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecieveGetServersEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecieveIPEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecievePlayerCountEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecievePlayerListEvent;
import org.goblom.cnc.core.events.network.bungeecord.BungeeRecieveUnknownEvent;

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
                case "Forward": 
                    callEvent(new BungeeRecieveForwardEvent(in));
                    break;
                case "IP": 
                    callEvent(new BungeeRecieveIPEvent(in));
                    break;
                case "PlayerCount": 
                    callEvent(new BungeeRecievePlayerCountEvent(in));
                    break;
                case "PlayerList":
                    callEvent(new BungeeRecievePlayerListEvent(in));
                    break;
                case "GetServers": 
                    callEvent(new BungeeRecieveGetServersEvent(in));
                    break; 
                case "GetServer": 
                    callEvent(new BungeeRecieveGetServerEvent(in));
                    break;
                case "CommonNetworkCore":
                    callEvent(new BungeeRecieveCNCEvent(in));
                    break;
                case "Connect": break; // No Response
                case "ConnectOther": break; // No Response
                case "Message": break; // No Response
                default:
                    callEvent(new BungeeRecieveUnknownEvent(in));
                    break;
            }
        } catch (IOException ex) {
            Core.getLogger().warning("Unable to read incoming Bungee Plugin Message.");
        }
    }
    
    private void callEvent(BungeeRecieveEvent event) {
        Bukkit.getPluginManager().callEvent(event);
    }
}