/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.api.events;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 *
 * @author Goblom
 */
public class BungeeCordForwardEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    
    private final String customChannel;
    private final DataInputStream in;
    private final byte[] messageRecieved;
    private final int messageLength;
    
    public BungeeCordForwardEvent(String channel, DataInputStream in) throws IOException {
        this.customChannel = channel;
        this.in = in;
        
        this.messageLength = in.readShort();
        this.messageRecieved = new byte[messageLength];
        
        in.readFully(messageRecieved);
    }
    
    public String getCustomChannel() {
        return customChannel;
    }
    
    public DataInputStream getInputStream() {
        return in;
    }
    
    public byte[] getMessageRecieved() {
        return messageRecieved;
    }
    
    public DataInputStream getDataAsWritten() {
        return new DataInputStream(new ByteArrayInputStream(messageRecieved));
    }
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    
    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}
