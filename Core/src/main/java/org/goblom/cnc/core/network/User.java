/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.network;

import org.bukkit.entity.Player;

/**
 *
 * @author Goblom
 */
public interface User {
    
    Player getPlayer();
    String getServer();
    void sendMessage(String message);
    void sendToServer(String server);
}
