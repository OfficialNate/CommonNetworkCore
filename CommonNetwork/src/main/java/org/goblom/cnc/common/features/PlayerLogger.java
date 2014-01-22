/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.features;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.common.util.ItemSerialization;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.database.Database;
import org.goblom.cnc.core.features.Feature;

/**
 *
 * @author Goblom
 */
public class PlayerLogger implements Feature {

    public PlayerLogger() {
        get().createTable("PlayerLogging", 
                            "player varchar(255) UNIQUE NOT NULL, " +
                            "level int NOT NULL, " +
                            "xp int NOT NULL, " +
                            "inventory text NOT NULL, " +
                            "loc_world varchar(255) NOT NULL, " +
                            "loc_x int NOT NULL, " +
                            "loc_y int NOT NULL, " +
                            "loc_z int NOT NULL, " +
                            "exhaustion float NOT NULL, " +
                            "food int NOT NULL, " +
                            "health double NOT NULL, " + 
                            "hpScale double NOT NULL, " +
                            "saturation float NOT NULL, " +
                            "enderchest text NOT NULL"
                          );
    }
    
    @Override
    public String getName() {
        return "Player Logger";
    }
    
    private Database get() {
        return Core.getDatabaseManager().getDatabase(getPlugin());
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        update(event.getPlayer());
    }
    
    public void update(Player player) {
        if (!get().doesTableContain("PlayerLogging", "player", player.getName())) {
            get().update(
                    "INSERT INTO `PlayerLogging` (`player`,`level`,`xp`,`inventory`,`loc_world`,`loc_x`,`loc_y`,`loc_z`,`exhaustion`,`food`,`health`,`hpScale`,`saturation`,`enderchest`)" +
                    "VALUES ( '" + 
                            player.getName() + "', '" + 
                            player.getLevel() + "', '" + 
                            player.getExp()+ "', '" + 
                            ItemSerialization.toBase64(player.getInventory()) + "', '" +
                            player.getLocation().getWorld().getName() + "', '" + 
                            player.getLocation().getBlockX() + "', '" + 
                            player.getLocation().getBlockY() + "', '" + 
                            player.getLocation().getBlockZ() + "', '" + 
                            player.getExhaustion() + "', '" + 
                            player.getFoodLevel() + "', '" + 
                            player.getHealth() + "', '" + 
                            player.getHealthScale() + "', '" + 
                            ItemSerialization.toBase64(player.getEnderChest()) + "'" +
                        ");");
        } else {
            get().update("UPDATE `PlayerLogging` SET " + 
                    "`level`='" + player.getLevel() + "', " +
                    "`xp`='" + player.getExp() + "', " +
                    "`inventory`='" + ItemSerialization.toBase64(player.getInventory()) + "', " +
                    "`loc_world`='" + player.getLocation().getWorld().getName() + "', " +
                    "`loc_x`='" + player.getLocation().getBlockX() + "', " +
                    "`loc_y`='" + player.getLocation().getBlockY() + "', " +
                    "`loc_z`='" + player.getLocation().getBlockZ() + "', " +
                    "`exhaustion`='" + player.getExhaustion() + "', " +
                    "`food`='" + player.getFoodLevel() + "', " +
                    "`health`='" + player.getHealth() + "', " +
                    "`hpScale`='" + player.getHealthScale() + "', " +
                    "`saturation`='" + player.getSaturation() + "', " +
                    "`enderchest`='" + ItemSerialization.toBase64(player.getEnderChest()) + 
                "'");
        }
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
}
