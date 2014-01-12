/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.core.listener;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.core.Core;

/**
 *
 * @author Goblom
 */
public class HubSignListener extends CoreListener {

    public HubSignListener(Plugin plugin) {
        super(plugin);
    }
    
    @EventHandler
    public void onPlayerTouchSign(PlayerInteractEvent event) {
        if (event.getClickedBlock() instanceof Sign) {
            Sign sign = (Sign) event.getClickedBlock().getState();
            if (sign.getLine(1).startsWith("[") && sign.getLine(1).endsWith("]")) {
                String server = sign.getLine(1).substring(1).replace("]", "");
                Core.getNetwork().send(event.getPlayer(), server);
            }
        }
    }
}
