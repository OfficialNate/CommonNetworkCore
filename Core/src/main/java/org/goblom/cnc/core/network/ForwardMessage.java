/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.core.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Goblom
 */
public class ForwardMessage {

    private final String server, customChannel;

    private final ByteArrayOutputStream msgBytes;
    private final DataOutputStream msgData;

    public ForwardMessage(String server, String customChannel) {
        this.server = server;
        this.customChannel = customChannel;

        msgBytes = new ByteArrayOutputStream();
        msgData = new DataOutputStream(msgBytes);
    }

    public String getServer() {
        return server;
    }

    public String getChannel() {
        return customChannel;
    }

    public ByteArrayOutputStream getBytesToForward() {
        return msgBytes;
    }

    public DataOutputStream getDataToForward() {
        return msgData;
    }

    public boolean write(byte[] b) {
        try {
            msgData.write(b);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean write(int b) {
        try {
            msgData.write(b);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean write(byte[] b, int off, int len) {
        try {
            msgData.write(b, off, len);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeBoolean(boolean bool) {
        try {
            msgData.writeBoolean(bool);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeByte(int v) {
        try {
            msgData.writeByte(v);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeBytes(String s) {
        try {
            msgData.writeBytes(s);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeChar(int v) {
        try {
            msgData.writeChar(v);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeChars(String s) {
        try {
            msgData.writeChars(s);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeDouble(double v) {
        try {
            msgData.writeDouble(v);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeFloat(float f) {
        try {
            msgData.writeFloat(f);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeInt(int v) {
        try {
            msgData.writeInt(v);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeLong(long v) {
        try {
            msgData.writeLong(v);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeShort(int v) {
        try {
            msgData.writeShort(v);
            return true;
        } catch(IOException e) {
            return false;
        }
    }

    public boolean writeUTF(String str) {
        try {
            msgData.writeUTF(str);
            return true;
        } catch(IOException e) {
            return false;
        }
    }
}
