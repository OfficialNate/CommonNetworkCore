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
public interface Network {
    boolean send(final Player player, String server);
    boolean send(final String player, String server);
}

