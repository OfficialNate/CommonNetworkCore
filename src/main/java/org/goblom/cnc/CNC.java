/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListenerRegistration;
import org.goblom.cnc.listeners.BungeeChannelListener;
import org.goblom.cnc.util.MessageManager;

/**
 *
 * @author Goblom
 */
public class CNC extends JavaPlugin {
    private PluginMessageListenerRegistration pmlr;
    private MessageManager messageManager;
    
    public void onEnable() {
        pmlr = getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeChannelListener(this));
        
        messageManager = new MessageManager(this);
    }
    
    public MessageManager getMessageManager() {
        return messageManager;
    }
}
