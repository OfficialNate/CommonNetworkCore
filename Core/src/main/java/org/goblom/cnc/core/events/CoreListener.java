/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.events;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Goblom
 */
public abstract class CoreListener implements Listener {
    
    public CoreListener(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    public void unRegister() {
        HandlerList.unregisterAll(this);
    }
}
