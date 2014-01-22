/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.network.Server;
import org.goblom.cnc.core.network.User;

/**
 *
 * @author Goblom
 */
public class CNUser implements User {

    private final String user, server, ip;
    public CNUser(String user, String server, String ip) {
        this.user = user;
        this.server = server;
        this.ip = ip;
    }
    
    @Override
    public String getName() {
        return user;
    }

    @Override
    public Server getServer() {
        for (Server s : Core.getNetwork().getServers()) {
            if (s.getName().equals(server)) {
                return s;
            }
        }
        return null;
    }

    @Override
    public void sendMessage(String message) throws IOException {
        getServer().sendMessageToPlayer(getName(), message);
    }

    @Override
    public void sendToServer(String server) throws IOException {
        if (server.length() == 0) return;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF("ConnectOther");
        out.writeUTF(getName());
        out.writeUTF(server);
        
        Bukkit.getOnlinePlayers()[0].sendPluginMessage(null, server, byteArray.toByteArray());
    }

    @Override
    public String getIP() {
        return ip;
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
    
}
