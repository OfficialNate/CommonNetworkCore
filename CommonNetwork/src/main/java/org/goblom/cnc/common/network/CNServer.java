/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.network.ForwardMessage;
import org.goblom.cnc.core.network.Server;
import org.goblom.cnc.core.network.User;

/**
 *
 * @author Goblom
 */
public class CNServer implements Server {

    private final String serverName, ip;
    private final List<User> users;
    
    public CNServer(String serverName, String ip, List<User> users) {
        this.serverName = serverName;
        this.ip = ip;
        this.users = users;
    }
    
    @Override
    public String getName() {
        return serverName;
    }

    @Override
    public String getIP() {
        return ip;
    }

    @Override
    public List<User> getPlayers() {
        return users;
    }

    @Override
    public void forward(ForwardMessage m) throws IOException {
        if (m == null) return;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF("Forward");
        out.writeUTF(m.getServer());
        out.writeUTF(m.getChannel());
        
        out.writeShort(m.getBytesToForward().toByteArray().length);
        out.write(m.getBytesToForward().toByteArray());
        
        Bukkit.getOnlinePlayers()[0].sendPluginMessage(getPlugin(), "BungeeCord", byteArray.toByteArray());
    }

    @Override
    public void sendMessageToPlayer(String player, String message) throws IOException {
        if (player == null) return;
        if (message == null) return;
        
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);
        
        out.writeUTF("Message");
        out.writeUTF(player);
        out.writeUTF(message);
        
        Bukkit.getOnlinePlayers()[0].sendPluginMessage(getPlugin(), "BungeeCord", byteArray.toByteArray());
    }

    @Override
    public int getPlayerCount() {
       return getPlayers().size();
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
}
