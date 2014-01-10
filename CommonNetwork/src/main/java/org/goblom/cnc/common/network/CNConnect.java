/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.Messenger;
import org.goblom.cnc.common.CNCore;
import org.goblom.cnc.core.network.Connect;


/**
 *
 * @author Goblom
 */
public class CNConnect implements Connect {

//    private boolean lilyStatus = false;
//    private lilypad.client.connect.api.Connect lily;
    
    private final CNCore core;
    
    public CNConnect(CNCore core) {
        this.core = core;
        
        Messenger messenger = Bukkit.getMessenger();
        if (!messenger.isOutgoingChannelRegistered(core, "BungeeCord")) {
            messenger.registerOutgoingPluginChannel(core, "BungeeCord");
        }
    }
    
    public boolean connect(ConnectType type, Player player, String server) {
        switch (type) {
            case BUNGEECORD: 
                try {
                    if (server.length() == 0) {
//                        plugin.getMessageManager().sendMessage(player, ChatColor.RED + "That server does not exist");
                        return false;
                    }

                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    DataOutputStream out = new DataOutputStream(byteArray);

                    out.writeUTF("Connect");
                    out.writeUTF(server);

                    player.sendPluginMessage(core, "BungeeCord", byteArray.toByteArray());
                } catch (Exception e) { return false; }
                return true;
//            case LILYPAD: break;
        }
        return true;
    }

    public boolean send(ConnectType type, String player, String server) {
        switch (type) {
            case BUNGEECORD: 
                try {
                    if (server.length() == 0) { return false; }

                    ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                    DataOutputStream out = new DataOutputStream(byteArray);

                    out.writeUTF("Connect");
                    out.writeUTF(server);

                    Bukkit.getOnlinePlayers()[0].sendPluginMessage(core, "BungeeCord", byteArray.toByteArray());
                } catch (Exception e) { return false; }
                return true;
//            case LILYPAD: break;
        }
        return true;
    }
    
}
