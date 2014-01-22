/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.events.network.bungeecord;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import org.goblom.cnc.core.events.network.BungeeRecieveEvent;

/**
 *
 * @author Goblom
 */
public class BungeeRecieveForwardEvent extends BungeeRecieveEvent {
    private final String subChannel;
    private final int messageLength;
    private final byte[] messageRecieved;
        
    public BungeeRecieveForwardEvent(DataInputStream in) throws IOException {
        super(in);
        
        this.subChannel = in.readUTF();
        this.messageLength = in.readShort();
        this.messageRecieved = new byte[messageLength];
        
        in.readFully(messageRecieved);
    }
    
    public String getChannel() {
        return subChannel;
    }
    
    public int getMessageLength() {
        return messageLength;
    }
    
    public byte[] getMessageRecieved() {
        return messageRecieved;
    }
    
    public DataInputStream getDataAsWritten() {
        return new DataInputStream(new ByteArrayInputStream(messageRecieved));
    }
}
