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
public class BungeeRecievePlayerListEvent extends BungeeRecieveEvent {

    private final String server, playerList;
    
    public BungeeRecievePlayerListEvent(DataInputStream in) throws IOException {
        super(in);
        
        this.server = in.readUTF();
        this.playerList = in.readUTF();
    }
    
    public String getServer() {
        return server;
    }
    
    public String getPlayers() {
        return playerList;
    }
}
