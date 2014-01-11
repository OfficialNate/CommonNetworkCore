/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.network;

import org.bukkit.entity.Player;
import org.goblom.cnc.core.network.Network;

/**
 *
 * @author Goblom
 */
public class CNBungeeCord implements Network {

    public boolean send(Player player, String server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean send(String player, String server) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
