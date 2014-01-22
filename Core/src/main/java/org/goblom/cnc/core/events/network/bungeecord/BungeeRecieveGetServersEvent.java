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
public class BungeeRecieveGetServersEvent extends BungeeRecieveEvent {
    
    private final String serverList;

    public BungeeRecieveGetServersEvent(DataInputStream in) throws IOException {
        super(in);
        
        this.serverList = in.readUTF();
    }
    
    public String getServers() {
        return serverList;
    }
    
    public String[] getServersArray() {
        return serverList.split(", ");
    }
}
