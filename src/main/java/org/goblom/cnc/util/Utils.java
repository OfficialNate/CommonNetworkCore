/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.util;

import java.lang.reflect.Field;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.goblom.cnc.CNC;
import org.goblom.cnc.api.hooks.IUtil;

/**
 *
 * @author Goblom
 */
public class Utils implements IUtil {
    protected static CommandMap cmap;
    private final CNC plugin;
    
    public Utils(CNC plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public final CommandMap getCommandMap() {
        if (cmap == null) {
            try {
                final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                f.setAccessible(true);
                cmap = (CommandMap) f.get(Bukkit.getServer());
                return getCommandMap();
            } catch (Exception e) { e.printStackTrace(); }
        } else if (cmap != null) { return cmap; }
        return getCommandMap();
    }
}
