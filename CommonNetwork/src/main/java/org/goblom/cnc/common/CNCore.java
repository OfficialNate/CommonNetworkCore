/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;
import org.goblom.cnc.common.network.CNBungeeCord;
import org.goblom.cnc.common.permissions.CNRankManager;
import org.goblom.cnc.core.CommonNetwork;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.command.CoreCommand;
import org.goblom.cnc.core.command.CoreCommandExecutor;
import org.goblom.cnc.core.network.Network;
import org.goblom.cnc.core.permissions.RankManager;

/**
 *
 * @author Goblom
 */
public class CNCore extends JavaPlugin implements CommonNetwork {

    private final RankManager rankManager = new CNRankManager();
    private final Network net = new CNBungeeCord();
    
    public void onLoad() { //Might get changed in future
        Core.setCore(this);
    }
    
    public RankManager getRankManager() {
        return rankManager;
    }

    public void registerCommand(String command, CoreCommandExecutor exe) {
        CoreCommand cmd = new CoreCommand(command);
        if (exe.getAlias() != null && exe.getAlias() != "") {
            cmd.setAliases(Arrays.asList(exe.getAlias()));
        }
        if (exe.getDescription() != null && exe.getDescription() != "") {
            cmd.setDescription(exe.getDescription());
        }
        if (exe.getUsage() != null && exe.getDescription() != "") {
            cmd.setUsage(exe.getUsage());
        }
        if (exe.getPermission() != null && exe.getPermission() != "") {
            cmd.setPermission(exe.getPermission());
        }
        if (exe.getNotAllowedMessage() != null && exe.getNotAllowedMessage() != "") {
            cmd.setPermissionMessage(exe.getNotAllowedMessage());
        }
        getCommandMap().register("", cmd);
        cmd.setExecutor(exe);
    }

    public CommandMap getCommandMap() {
        try {
            final Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            return (CommandMap) f.get(Bukkit.getServer());
        } catch (Exception e) {}
        return getCommandMap();
    }
    
    public Network getNetwork() {
        return net; //Only support BungeeCord for now
    }

    public String getVersion() {
        return getDescription().getVersion();
    }
    
    public String getCoreName() {
        return getDescription().getName();
    }
}
