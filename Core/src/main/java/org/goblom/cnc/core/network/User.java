/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.network;

/**
 *
 * @author Goblom
 */
public interface User {
    String getName();
    Server getServer();
    void sendMessage(String message);
    void sendToServer(String server);
    String getIP();
}
