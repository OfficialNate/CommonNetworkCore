/*
 * Copywrite 2014 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.common.features;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.goblom.cnc.common.util.ItemSerialization;
import org.goblom.cnc.core.Core;
import org.goblom.cnc.core.database.Database;
import org.goblom.cnc.core.features.Feature;

/**
 *
 * @author Goblom
 */
public class PlayerUpdater implements Feature {
    
    public PlayerUpdater() {
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
        return "Player Updater";
    }
    
    private Database get() {
        return Core.getDatabaseManager().getDatabase(getPlugin());
    }
    
    private Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("Common Network Core");
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (doesContain(player)) {
            player.getInventory().setContents(getInventory(player).getContents());
            player.getEnderChest().setContents(getEnderChest(player).getContents());
            player.teleport(getLocation(player));
            player.setLevel(getLevel(player));
            player.setExp(getExp(player));
            player.setExhaustion(getExhaustion(player));
            player.setFoodLevel(getFood(player));
            player.setHealthScale(getHealthScale(player));
            player.setHealth(getHealth(player));
            player.setSaturation(getSaturation(player));
        }
    }
    
    //SQL Statements
    private boolean doesContain(Player player) {
        return get().doesTableContain("PlayerLogger", "player", player.getName());
    }
    
    private Inventory getInventory(Player player) {
        String string = get().queryString("SELECT `inventory` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "inventory");
        return ItemSerialization.fromBase64(string);
    }
    
    private Inventory getEnderChest(Player player) {
        String string = get().queryString("SELECT `enderchest` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "enderchest");
        return ItemSerialization.fromBase64(string);
    }
    
    private Location getLocation(Player player) {
        String world = get().queryString("SELECT `loc_world` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "loc_world");
        int x = get().queryInteger("SELECT `loc_x` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "loc_x");
        int y = get().queryInteger("SELECT `loc_y` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "loc_y");
        int z = get().queryInteger("SELECT `loc_z` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "loc_z");
        return new Location(Bukkit.getWorld(world), x, y, z);
    }
    
    private int getLevel(Player player) {
        return get().queryInteger("SELECT `level` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "level");
    }
    
    private float getExp(Player player) {
        return get().queryFloat("SELECT `xp` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "xp");
    }
    
    private float getExhaustion(Player player) {
        return get().queryFloat("SELECT `exhaustion` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "exhaustion");
    }
    
    private int getFood(Player player) {
        return get().queryInteger("SELECT `food` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "food");
    }
    
    private double getHealth(Player player) {
        return get().queryDouble("SELECT `health` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "health");
    }
    
    private double getHealthScale(Player player) {
        return get().queryDouble("SELECT `hpScale` FROM `PlayerLogger` WHER `player`='" + player.getName() + "'", "hpScale");
    }
    
    private float getSaturation(Player player) {
        return get().queryFloat("SELECT `saturation` FROM `PlayerLogger` WHERE `player`='" + player.getName() + "'", "saturation");
    }
}
