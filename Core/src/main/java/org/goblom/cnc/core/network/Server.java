/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.network;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Goblom
 */
public interface Server {
    String getName();
    String getIP();
    List<User> getPlayers();
//    Status getStatus();
    void forward(ForwardMessage forward) throws IOException;
    void sendMessageToPlayer(String player, String message) throws IOException;
    int getPlayerCount();
}
