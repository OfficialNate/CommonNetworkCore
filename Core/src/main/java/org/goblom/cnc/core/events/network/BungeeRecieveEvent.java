/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.events.network;

import java.io.DataInputStream;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Goblom
 */
public abstract class BungeeRecieveEvent extends BungeeEvent {
    
    private final DataInputStream in;
     private static final HandlerList handlers = new HandlerList();
     
    public BungeeRecieveEvent(DataInputStream in) {
        this.in = in;
    }
    
    public DataInputStream getInputStream() {
        return in;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
