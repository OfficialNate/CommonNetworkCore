/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListenerRegistration;
import org.goblom.cnc.util.ReflectCommand;
import org.goblom.cnc.api.hooks.ICore;
import org.goblom.cnc.listeners.BungeeChannelListener;
import org.goblom.cnc.permissions.Ranks;
import org.goblom.cnc.util.MessageManager;
import org.goblom.cnc.util.Utils;

/**
 *
 * @author Goblom
 */
public class CNC extends JavaPlugin implements ICore {
    private Utils utils;
    private PluginMessageListenerRegistration pmlr;
    private MessageManager messageManager;
    private Ranks rankManager;
    
    @Override
    public void onEnable() {
        pmlr = getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeChannelListener(this));
        
        messageManager = new MessageManager(this);
        rankManager = new Ranks(this);
        utils = new Utils(this);
    }
    
    public MessageManager getMessageManager() {
        return messageManager;
    }
    
    public PluginMessageListenerRegistration getBungeeCordChannelListener() {
        return pmlr;
    }
    
    @Override
    public Ranks getRanksManager() {
        return rankManager;
    }

    public Utils getUtils() {
        return utils;
    }
    
    @Override
    public void registerCommand(String command, CommandExecutor exe) {
        ReflectCommand cmd = new ReflectCommand(command);
        cmd.setExecutor(exe);
        getUtils().getCommandMap().register("", cmd);
    }
}
