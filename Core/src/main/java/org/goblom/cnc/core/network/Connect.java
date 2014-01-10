/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.network;

import org.bukkit.entity.Player;

/**
 *
 * @author Goblom
 */
public interface Connect {
    /*static */boolean connect(ConnectType type, final Player player, String server);
    /*static */boolean send(ConnectType type, final String player, String server);
    public enum ConnectType {
        BUNGEECORD;//, LILYPAD;
    }
}

