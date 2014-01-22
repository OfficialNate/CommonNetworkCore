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
public class BungeeRecieveGetServerEvent extends BungeeRecieveEvent {

    private final String server;
    
    public BungeeRecieveGetServerEvent(DataInputStream in) throws IOException {
        super(in);
        
        this.server = in.readUTF();
    }
    
    public String getServer() {
        return server;
    }
    
}
