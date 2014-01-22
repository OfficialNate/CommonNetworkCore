/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.network;

import java.io.IOException;

/**
 *
 * @author Goblom
 */
public interface User {
    String getName();
    Server getServer();
    void sendMessage(String message) throws IOException;
    void sendToServer(String server) throws IOException;
    String getIP();
}