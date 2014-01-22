/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.core.events.network.bungeecord;

import java.io.DataInputStream;
import java.io.IOException;
import org.goblom.cnc.core.events.network.BungeeRecieveEvent;

/**
 *
 * @author Goblom
 */
public class BungeeRecieveIPEvent extends BungeeRecieveEvent {

    private final String ipAddress;
    private final int port;

    public BungeeRecieveIPEvent(DataInputStream in) throws IOException {
        super(in);

        this.ipAddress = in.readUTF();
        this.port = in.readInt();
    }

    public String getIP() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    public String getAddress() {
        return ipAddress + ":" + port;
    }
}