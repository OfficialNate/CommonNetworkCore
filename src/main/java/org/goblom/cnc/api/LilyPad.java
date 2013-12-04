/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.api;

import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.RequestException;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import lilypad.client.connect.api.result.FutureResultListener;
import lilypad.client.connect.api.result.StatusCode;
import lilypad.client.connect.api.result.impl.RedirectResult;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.goblom.cnc.CNC;

/**
 *
 * @author Goblom
 */
public class LilyPad {
    private static Connect connect;
    private static CNC plugin;
    private static boolean returnStatus = true;
    
    public LilyPad(CNC plugin) {
        this.plugin = plugin;
    }
    
    public static boolean getConnect() {
        if (connect == null) {
            connect = (Connect) plugin.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
        }
        return (connect != null);
    }

    public static boolean connect(final Player player, String server) {
        returnStatus = true;
        if (getConnect()) {
            try {
                Connect conn = connect;

                conn.request(new RedirectRequest(server, player.getName())).registerListener(
                        new FutureResultListener<RedirectResult>() {
                            @Override
                            public void onResult(RedirectResult result) {
                                if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
                                    returnStatus = true;
                                } else {
                                    returnStatus = false;
                                    plugin.getMessageManager().sendMessage(player, ChatColor.RED + "An error occurred when trying to connect to server.");
                                }
                            }
                        }
                );
            } catch (RequestException e) {
                returnStatus = false;
                plugin.getMessageManager().sendMessage(player, ChatColor.RED + "An error occurred when trying to connect to server.");
            }
        } else {
            returnStatus = false;
            plugin.getMessageManager().sendMessage(player, ChatColor.RED + "LilyPad was not found on this server. Unable to connect to different LilyPad server");
        }
        return returnStatus;
    }
    
    public static boolean send(final String player, String server) {
        returnStatus = true;
        if (getConnect()) {
            try {
                Connect conn = connect;
                
                conn.request(new RedirectRequest(server, player)).registerListener(
                    new FutureResultListener<RedirectResult>() {
                        @Override
                        public void onResult(RedirectResult result) {
                            returnStatus = result.getStatusCode().equals(StatusCode.SUCCESS);
                        }
                    }
                );
            } catch (RequestException e) { returnStatus = false; }
        } else returnStatus = false;
        return returnStatus;
    }
}
