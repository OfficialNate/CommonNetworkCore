/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.events.network;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Goblom
 */
public abstract class BungeeEvent extends Event {
    
    @Override
    public abstract HandlerList getHandlers();
    
}
