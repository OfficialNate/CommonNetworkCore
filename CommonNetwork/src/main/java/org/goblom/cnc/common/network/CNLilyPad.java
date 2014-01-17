/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */
package org.goblom.cnc.common.network;

import java.util.List;
import lilypad.client.connect.api.Connect;
import lilypad.client.connect.api.request.impl.RedirectRequest;
import lilypad.client.connect.api.result.FutureResultListener;
import lilypad.client.connect.api.result.StatusCode;
import lilypad.client.connect.api.result.impl.RedirectResult;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.goblom.cnc.common.CNCore;
import org.goblom.cnc.core.network.Network;
import org.goblom.cnc.core.network.Server;
import org.goblom.cnc.core.network.User;

/**
 *
 * @author Goblom
 */
public class CNLilyPad implements Network {

    private final Connect lilyPadConnect;
    private final CNCore core;

    public CNLilyPad(CNCore core) {
        this.core = core;
        this.lilyPadConnect = (Connect) core.getServer().getServicesManager().getRegistration(Connect.class).getProvider();
    }

    public boolean send(final Player player, final String server) {
        if (server.length() == 0) { return false; }
        
        try {
            lilyPadConnect.request(new RedirectRequest(server, player.getName())).registerListener(
                    new FutureResultListener<RedirectResult>() {
                        public void onResult(RedirectResult result) {
                            if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
//                                return true;
                            }
                        }
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean send(String player, String server) {
                if (server.length() == 0) { return false; }
        
        try {
            lilyPadConnect.request(new RedirectRequest(server, player)).registerListener(
                    new FutureResultListener<RedirectResult>() {
                        public void onResult(RedirectResult result) {
                            if (result.getStatusCode().equals(StatusCode.SUCCESS)) {
//                                return true;
                            }
                        }
                    }
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Server> getServers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<User> getNetworkPlayers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
