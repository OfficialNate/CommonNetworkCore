/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.common.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.Messenger;
import org.goblom.cnc.common.CNCore;
import org.goblom.cnc.common.Message;
import org.goblom.cnc.core.network.Network;
import org.goblom.cnc.core.network.Server;
import org.goblom.cnc.core.network.User;

/**
 *
 * @author Goblom
 */
public class CNBungeeCord implements Network {

    private final CNCore core;

    public CNBungeeCord(CNCore core) {
        this.core = core;

        Messenger messenger = Bukkit.getMessenger();
        if (!messenger.isOutgoingChannelRegistered(core, "BungeeCord")) {
            messenger.registerOutgoingPluginChannel(core, "BungeeCord");
        }
    }

    public boolean send(Player player, String server) {
        try {
            if (server.length() == 0) {
                player.sendMessage(Message.getMessage(Message.PREFIX) + Message.getMessage(Message.TARGET_SERVER_NOT_EXIST));
                return false;
            }

            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteArray);

            out.writeUTF("Connect");
            out.writeUTF(server);

            player.sendPluginMessage(core, "BungeeCord", byteArray.toByteArray());
        } catch (Exception e) { return false; }
        return true;
    }

    public boolean send(String player, String server) {
        try {
            if (server.length() == 0) { return false; }

            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(byteArray);

            out.writeUTF("Connect");
            out.writeUTF(server);

            Bukkit.getOnlinePlayers()[0].sendPluginMessage(core, "BungeeCord", byteArray.toByteArray());
        } catch (Exception e) { return false; }
        return true;
    }

    public List<Server> getServers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<User> getNetworkPlayers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
