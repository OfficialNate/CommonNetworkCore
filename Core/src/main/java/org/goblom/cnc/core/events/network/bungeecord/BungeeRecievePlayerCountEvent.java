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
public class BungeeRecievePlayerCountEvent extends BungeeRecieveEvent {

    private final String server;
    private final int playerCount;
    
    public BungeeRecievePlayerCountEvent(DataInputStream in) throws IOException {
        super(in);
        
        this.server = in.readUTF();
        this.playerCount = in.readInt();
    }
    
    public String getServer() {
        return server;
    }
    
    public int getPlayerCount() {
        return playerCount;
    }
}
