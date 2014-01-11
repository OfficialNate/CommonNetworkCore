/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.network;

import java.util.List;
import org.bukkit.entity.Player;
import org.goblom.cnc.core.network.Network;
import org.goblom.cnc.core.network.Server;
import org.goblom.cnc.core.network.User;

/**
 *
 * @author Goblom
 */
public class CNLilyPad implements Network {
    
    public boolean send(Player player, String server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean send(String player, String server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Server> getServers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<User> getNetworkPlayers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
