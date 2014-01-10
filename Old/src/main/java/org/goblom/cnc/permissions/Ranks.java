/*
 * Copyright 2013 Goblom.
 *
 * All Rights Reserved unless otherwise explicitly stated.
 */

package org.goblom.cnc.permissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.goblom.cnc.CNC;
import org.goblom.cnc.api.hooks.IRank;

/**
 *
 * @author Goblom
 */
public class Ranks {
    
    private final CNC plugin;
    private final Map<String, IRank> ranks;
    
    public Ranks(CNC plugin) {
        this.plugin = plugin;
        ranks = new HashMap();
    }
    
    public void registerRank(IRank rank) {
        ranks.put(ChatColor.stripColor(rank.getName()), rank);
    }
    
    public void removeRank(String rankName) {
        ranks.remove(rankName);
    }
    
    public IRank getRank(String rankName) {
        return ranks.get(rankName);
    }
    
    public IRank[] getInheritance(String rankName) {
        return getRank(rankName).getInheritance();
    }
    
    public List<String> getPermsForRank(String rankName) {
        List<String> perms = new ArrayList();
        for (IRank rank : getRank(rankName).getInheritance()) {
            perms.addAll(Arrays.asList(rank.getPermissions()));
        }
        perms.addAll(Arrays.asList(getRank(rankName).getPermissions()));
        
        return perms;
    }
}
